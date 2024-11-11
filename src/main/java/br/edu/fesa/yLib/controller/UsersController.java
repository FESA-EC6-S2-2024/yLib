package br.edu.fesa.yLib.controller;

import br.edu.fesa.yLib.enumerator.UserType;
import br.edu.fesa.yLib.exception.UserWithEmailAlreadyExistsException;
import br.edu.fesa.yLib.model.User;
import br.edu.fesa.yLib.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasRole('ADMIN')")
public class UsersController {

    @Autowired
    private UserService userService;

    // Lista todos os usuários
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "users/list";
    }

    // Exibe o formulário para criar um novo usuário
    @GetMapping("/create")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userTypes", UserType.values());
        return "users/create";
    }

    // Salva o novo usuário no banco de dados
    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userTypes", UserType.values());
            return "/users/create";
        }

        try {
            userService.createUser(user);
        } catch (UserWithEmailAlreadyExistsException e) {
            result.rejectValue("email", "error.user", e.getMessage());
            model.addAttribute("userTypes", UserType.values());
            return "users/create";
        } catch (Exception e) {
            result.reject("globalError", "An unexpected error occurred. Please try again.");
            model.addAttribute("userTypes", UserType.values());
            return "users/create";
        }

        return "redirect:/users";
    }

    // Exibe o formulário para editar um usuário existente
    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable("id") int id, Model model) {
        Optional<User> userOptional = userService.findUserById(id);
        if (userOptional.isEmpty()) {
            return "redirect:/users";
        }

        model.addAttribute("user", userOptional.get());
        model.addAttribute("userTypes", UserType.values());
        return "users/edit";
    }

    // Salva as alterações feitas no usuário existente
    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userTypes", UserType.values());
            return "users/edit";
        }

        try {
            userService.updateUser(id, user);
        } catch (UserWithEmailAlreadyExistsException e) {
            result.rejectValue("email", "error.user", e.getMessage());
            model.addAttribute("userTypes", UserType.values());
            return "users/edit";
        }

        return "redirect:/users";
    }

    // Exclui um usuário existente
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
