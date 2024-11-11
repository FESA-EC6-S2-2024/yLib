package br.edu.fesa.yLib.exception;

public class UserWithEmailAlreadyExistsException extends IllegalArgumentException {
    public UserWithEmailAlreadyExistsException() {
        super("User with email already exists.");
    }
}
