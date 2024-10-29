package br.edu.fesa.yLib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grupo7
 */
@Controller
@RequestMapping("/login")
public class LoginController {

  @GetMapping
  public String login() {
    return "login";
  }
}
