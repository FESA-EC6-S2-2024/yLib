package br.edu.fesa.yLib.security;

import br.edu.fesa.yLib.enumerator.LogType;
import br.edu.fesa.yLib.service.LoggingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author Grupo7
 */
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

  @Autowired private LoggingService loggingService;

  @Override
  public void onLogoutSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

    try {
      response.sendRedirect("/auth/login");
    } catch (IOException e) {
      loggingService.log(LogType.ERROR, "Error during logout redirect.", null);
      loggingService.log(LogType.DEBUG, "Redirect exception: " + e.getMessage(), null);
    }
  }
}
