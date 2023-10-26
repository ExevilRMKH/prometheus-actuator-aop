package ru.my.user.manager.ports;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
    public Mono<UserDTO> getUserById(@PathVariable String uuid){
        return query.getById(UUID.fromString(uuid));
    }

    @PostMapping
    public void add(@RequestBody UserDTO dto){
        command.add(dto);
    }

    @PutMapping
    public void update(@RequestBody UserDTO dto){
        command.update(dto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteById(@PathVariable String uuid){
        command.delete(UUID.fromString(uuid));
    }

    @GetMapping("/token/{login}/{uuid}")
    public String getToken(@PathVariable String login, @PathVariable String uuid){
        return query.getTokenByLoginAndUuid(login, UUID.fromString(uuid));
    }

    @GetMapping("/validate/{token}")
    public void tokenValidate(@PathVariable String token){
        query.validateToken(token);
    }

}
