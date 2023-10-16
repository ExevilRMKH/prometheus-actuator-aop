package ru.my.user.manager.app.exception;

public class UserManagerException extends RuntimeException {
    public UserManagerException() {
    }

    public UserManagerException(String message) {
        super(message);
    }

    public UserManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
