package org.upcy.simbia.exception;

public class LoginAlreadyExistsException extends RuntimeException {

    public LoginAlreadyExistsException(String username) {
        super("The username " + username + " already have a registered login");
    }
}