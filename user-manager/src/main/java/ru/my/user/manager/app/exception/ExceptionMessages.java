package ru.my.user.manager.app.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {
    public static final String NOT_USER_FOUND = "user not found";
    public static final String INVALID_TOKEN = "invalid token";
}
