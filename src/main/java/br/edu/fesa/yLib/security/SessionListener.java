package br.edu.fesa.yLib.security;

import br.edu.fesa.yLib.enumerator.LogType;
import br.edu.fesa.yLib.model.User;
import br.edu.fesa.yLib.repository.UserRepository;
import br.edu.fesa.yLib.service.LoggingService;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;

/**
 * @author Grupo_7
 */
@Component
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

  @Autowired private LoggingService loggingService;

  @Autowired private UserRepository userRepository;

  @Override
  public void attributeAdded(HttpSessionBindingEvent event) {
    try {
      if ("SPRING_SECURITY_CONTEXT".equals(event.getName())) {
        Object securityContextObj = event.getValue();

        if (securityContextObj instanceof SecurityContextImpl securityContext) {
          Authentication authentication = securityContext.getAuthentication();

          if (authentication != null
              && authentication.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            String email = userDetails.getEmail();
            User user = userRepository.findByEmail(email).orElse(null);

            String sessionId = event.getSession().getId();

            if (user != null) {
              loggingService.log(
                  LogType.SESSION,
                  "User " + user.getName() + "'s session initialized. Session ID: " + sessionId,
                  user);
            }
          }
        }
      }
    } catch (Exception e) {
      loggingService.log(
          LogType.ERROR, "Error during session construction handling: " + e.getMessage(), null);
      loggingService.log(
          LogType.DEBUG, "Exception during session construction: " + e.toString(), null);
    }
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    try {
      Object securityContextObj = se.getSession().getAttribute("SPRING_SECURITY_CONTEXT");

      if (securityContextObj instanceof SecurityContextImpl securityContext) {
        Authentication authentication = securityContext.getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
          CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
          String email = userDetails.getEmail();
          User user = userRepository.findByEmail(email).orElse(null);

          String sessionId = se.getSession().getId();

          if (user != null) {
            loggingService.log(
                LogType.SESSION,
                "User "
                    + user.getName()
                    + "'s session has been destroyed or expired. SESSION ID: "
                    + sessionId,
                user);
            loggingService.log(
                LogType.LOGOUT, "User " + user.getName() + " logged out successfully.", user);
            loggingService.log(LogType.INFO, "User role at logout: " + user.getUserType(), user);
          }
        }
      }
    } catch (Exception e) {
      loggingService.log(
          LogType.ERROR, "Error during session destruction handling: " + e.getMessage(), null);
      loggingService.log(
          LogType.DEBUG, "Exception during session destruction: " + e.toString(), null);
    }
  }
}
