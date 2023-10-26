package ru.my.messenger.app.query;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.my.messenger.messenger.model.dto.ChannelDTO;

import java.util.UUID;


public interface QueryChannel {
    Flux<ChannelDTO> findAll();
    Mono<ChannelDTO> findById(UUID id);
    Mono<ChannelDTO> findByName(String name);
}
