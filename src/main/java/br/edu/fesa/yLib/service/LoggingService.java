package br.edu.fesa.yLib.service;

import br.edu.fesa.yLib.enumerator.LogType;
import br.edu.fesa.yLib.model.Logging;
import br.edu.fesa.yLib.model.User;
import br.edu.fesa.yLib.repository.LoggingRepository;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoggingService {

  @Autowired private LoggingRepository loggingRepository;

  // Generalized log function that works for any LogType
  public void log(LogType logType, String message, User user) {
    Logging logging =
        Logging.builder()
            .message(message)
            .logDate(LocalDateTime.now())
            .logType(logType)
            .user(user)
            .build();

    loggingRepository.save(logging);

    // Use SLF4J to log to the console or a file based on the log type
    switch (logType) {
      case ERROR:
        log.error("Error: {}", message);
        break;
      case INFO:
        log.info("Info: {}", message);
        break;
      case DEBUG:
        log.debug("Debug: {}", message);
        break;
      case WARNING:
        log.warn("Warning: {}", message);
        break;
      case LOGIN:
        log.info("Login: {}", message);
        break;
      case LOGOUT:
        log.info("Logout: {}", message);
        break;
      case SESSION:
        log.info("Session: {}", message);
        break;
      default:
        log.info("Unknown log type: {}", message);
    }
  }
}
