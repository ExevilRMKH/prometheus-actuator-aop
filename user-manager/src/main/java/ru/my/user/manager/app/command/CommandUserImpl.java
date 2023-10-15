package ru.my.user.manager.app.command;

import ru.my.user.manager.users.model.dto.UserDTO;

public interface CommandUser {
    void add(UserDTO user);
    void delete(String uid);
    void update(UserDTO user);
}
