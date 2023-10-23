package ru.my.user.manager.app.query;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.my.user.manager.users.model.dto.UserDTO;

import java.util.UUID;

public interface QueryUser {
    Flux<UserDTO> getAll();
    Mono<UserDTO> getById(UUID uuid);
    String getTokenByLoginAndUuid(String login,UUID uuid);
    void validateToken(String token);
}
