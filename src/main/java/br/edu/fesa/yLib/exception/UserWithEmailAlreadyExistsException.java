package br.edu.fesa.yLib.exception;

/**
 * @author Grupo_7
 */
public class UserWithEmailAlreadyExistsException extends IllegalArgumentException {
  public UserWithEmailAlreadyExistsException() {
    super("User with email already exists.");
  }
}
