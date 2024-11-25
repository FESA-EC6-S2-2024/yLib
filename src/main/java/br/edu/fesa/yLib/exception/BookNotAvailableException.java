package br.edu.fesa.yLib.exception;

public class BookNotAvailableException extends IllegalArgumentException {
  public BookNotAvailableException() {
    super("Book has no available copies");
  }
}
