package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.enumerator.UserType;
import br.edu.fesa.yLib.exception.UserWithEmailAlreadyExistsException;
import br.edu.fesa.yLib.model.User;
import br.edu.fesa.yLib.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grupo7
 */
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String defaultRoute() {
        if (isAuthenticated())
            return "index";

        return "auth/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (isAuthenticated())
            return "index";

        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (isAuthenticated())
            return "index";

        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (isAuthenticated())
            return "index";

        if (result.hasErrors()) {
            return "auth/register";
        }

        try {
            user.setUserType(UserType.CLIENT);
            userService.registerUser(user);
        } catch (UserWithEmailAlreadyExistsException e) {
            result.rejectValue("email", "error.user", "Email already exists");
            return "auth/register";
        } catch (IllegalArgumentException e) {
            result.reject("globalError", e.getMessage());
            return "auth/register";
        }

        return "redirect:/home";
    }

    private boolean isAuthenticated() {
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                && !SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser");
    }
}
