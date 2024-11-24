package br.edu.fesa.yLib.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grupo7
 */
@Controller
@RequestMapping("/")
public class HomeController {

  @GetMapping({"/", "/home"})
  public String home(Model model) {
    if (!isAuthenticated()) return "/errors/unauthorized";
    return "index";
  }

  private boolean isAuthenticated() {
    return SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
        && !SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal()
            .equals("anonymousUser");
  }
}
