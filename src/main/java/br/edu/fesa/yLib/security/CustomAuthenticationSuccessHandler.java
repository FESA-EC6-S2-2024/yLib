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
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

/**
 * @author Grupo_7
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  @Autowired private LoggingService loggingService;

  @Autowired private UserRepository userRepository;

  @Autowired @Lazy private RequestCache requestCache;

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    String email = request.getParameter("username");

    User user =
        userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

    loggingService.log(LogType.LOGIN, "User " + user.getName() + " logged in successfully.", user);

    SavedRequest savedRequest = requestCache.getRequest(request, response);

    try {
      if (savedRequest != null && savedRequest.getRedirectUrl() != null) {
        String redirectUrl = savedRequest.getRedirectUrl();
        if (redirectUrl.contains("favicon.ico")) {
          redirectUrl = "/home";
        }
        response.sendRedirect(redirectUrl);
      } else {
        response.sendRedirect("/home");
      }
    } catch (IOException e) {
      loggingService.log(
          LogType.ERROR,
          "Error during redirect after authentication success for user: " + user.getName(),
          user);
      loggingService.log(
          LogType.DEBUG, "Detailed exception during redirect: " + e.getMessage(), user);

      try {
        response.sendRedirect("/error");
      } catch (IOException ioException) {
        loggingService.log(
            LogType.ERROR, "Fallback redirect failed for user: " + user.getName(), user);
        loggingService.log(
            LogType.DEBUG, "Detailed fallback exception: " + ioException.getMessage(), user);
      }
    }
  }
}
