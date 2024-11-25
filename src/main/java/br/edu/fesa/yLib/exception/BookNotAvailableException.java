package br.edu.fesa.yLib.exception;

/**
 * @author Grupo_7
 */
public class BookNotAvailableException extends IllegalArgumentException {
  public BookNotAvailableException() {
    super("Book has no available copies");
  }
}
