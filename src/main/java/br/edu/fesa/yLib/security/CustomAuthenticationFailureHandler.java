package br.edu.fesa.yLib.security;

import br.edu.fesa.yLib.enumerator.LogType;
import br.edu.fesa.yLib.model.User;
import br.edu.fesa.yLib.repository.UserRepository;
import br.edu.fesa.yLib.service.LoggingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * @author Grupo7
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

  @Autowired private LoggingService loggingService;

  @Autowired private UserRepository userRepository;

  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
    String email = request.getParameter("username");

    User user = userRepository.findByEmail(email).orElse(null);

    if (user != null) {
      loggingService.log(LogType.LOGIN, "Failed login attempt for user: " + user.getName(), user);
    } else {
      loggingService.log(
          LogType.WARNING, "Failed login attempt for non-existent user with email: " + email, null);
    }

    try {
      response.sendRedirect("/auth/login?error=true");
    } catch (IOException e) {
      loggingService.log(
          LogType.ERROR, "Error redirecting after login failure for email: " + email, user);

      loggingService.log(LogType.DEBUG, "Redirect exception: " + e.getMessage(), user);
    }
  }
}
