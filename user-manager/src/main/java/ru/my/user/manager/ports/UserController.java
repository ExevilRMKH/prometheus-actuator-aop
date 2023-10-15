package ru.my.user.manager.ports;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.my.user.manager.app.command.CommandUser;
import ru.my.user.manager.app.query.QueryUser;
import ru.my.user.manager.users.model.dto.UserDTO;

import java.util.UUID;

@RestController
@RequestMapping(value = "/manager", produces = MediaType.APPLICATION_NDJSON_VALUE)
@RequiredArgsConstructor
public class UserController {
    private final QueryUser query;
    private final CommandUser command;
    @GetMapping
    public Flux<UserDTO> getAll(){
        return query.getAll();
    }

    @GetMapping("/{uuid}")
    public Mono<UserDTO> getUserById(@PathVariable UUID uuid){
        return query.getById(uuid);
    }

    @GetMapping("/token/{login}")
    public Mono<String> getUserById(@PathVariable String login){
        return query.getTokenByLogin(login);
    }

}
