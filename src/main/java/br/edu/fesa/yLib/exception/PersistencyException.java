package br.edu.fesa.yLib.exception;

/**
 * @author Grupo7
 */
public class PersistencyException extends Exception {

  public PersistencyException() {}

  public PersistencyException(String message) {
    super(message);
  }

  public PersistencyException(String message, Throwable cause) {
    super(message, cause);
  }

  public PersistencyException(Throwable cause) {
    super(cause);
  }

  public PersistencyException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
