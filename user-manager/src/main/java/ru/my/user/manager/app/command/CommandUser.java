package ru.my.user.manager.app.command;

import ru.my.user.manager.users.model.dto.UserDTO;

import java.util.UUID;

public interface CommandUser {
    void add(UserDTO user);
    void delete(UUID uid);
    void update(UserDTO user);
}
