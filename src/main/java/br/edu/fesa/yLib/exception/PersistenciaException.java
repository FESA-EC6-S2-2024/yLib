package br.edu.fesa.yLib.exception;

/**
 * @author Grupo7
 */
public class PersistenciaException extends Exception {

  public PersistenciaException() {}

  public PersistenciaException(String message) {
    super(message);
  }

  public PersistenciaException(String message, Throwable cause) {
    super(message, cause);
  }

  public PersistenciaException(Throwable cause) {
    super(cause);
  }

  public PersistenciaException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
