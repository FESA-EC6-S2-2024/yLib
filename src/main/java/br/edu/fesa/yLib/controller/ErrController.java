package br.edu.fesa.yLib.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Grupo7
 */
@Controller
@RequestMapping("/error")
public class ErrController implements ErrorController {

  @GetMapping
  public String handleError(HttpServletRequest request) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

    if (status != null) {
      int statusCode = Integer.parseInt(status.toString());

      if (statusCode == HttpStatus.FORBIDDEN.value()) {
        return "errors/forbidden";
      } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
        return "errors/unauthorized";
      } else if (statusCode == HttpStatus.NOT_FOUND.value()) {
        return "errors/not-found";
      }
    }
    return "errors/internal";
  }

  @GetMapping("/forbidden")
  public String forbidden() {
    return "errors/forbidden";
  }

  @GetMapping("/unauthorized")
  public String unauthorized() {
    return "errors/unauthorized";
  }
}
