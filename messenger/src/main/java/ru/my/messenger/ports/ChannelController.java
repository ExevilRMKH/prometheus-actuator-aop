package ru.my.messenger.ports;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.my.messenger.app.command.CommandChannel;
import ru.my.messenger.app.query.QueryChannel;
import ru.my.messenger.messenger.model.dto.ChannelDTO;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_NDJSON_VALUE;

@RestController
@RequestMapping(value = "/v1/channel", produces = APPLICATION_NDJSON_VALUE)
@RequiredArgsConstructor
public class ChannelController {
    private final QueryChannel query;
    private final CommandChannel command;
    @GetMapping
    public Flux<ChannelDTO> getAll(){
        return query.findAll();
    }

    @GetMapping("/id/{id}")
    public Mono<ChannelDTO> getChannelById(@PathVariable String id){
        return query.findById(UUID.fromString(id));
    }

    @GetMapping("/name/{name}")
    public Mono<ChannelDTO> getChannelByName(@PathVariable String name){
        return query.findByName(name);
    }

    @PostMapping(value = "/add", consumes = APPLICATION_JSON_VALUE)
    public Mono<UUID> addChannel(@RequestBody Mono<ChannelDTO> body){
        return command.add(body);
    }

    @PatchMapping("/owner/{uuid}")
    public Mono<Void> changeOwner(@PathVariable Mono<String> uuid, @RequestHeader String token){
        return command.changeOwner(uuid, token);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable Mono<String> id, @RequestHeader String token){
        return command.changeOwner(id, token);
    }
}
