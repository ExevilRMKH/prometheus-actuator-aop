package ru.my.messenger.app.query;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.my.messenger.messenger.model.dto.ChannelDTO;


public interface QueryChannel {
    Flux<ChannelDTO> findAll();
    Mono<ChannelDTO> findById(String id);
    Mono<ChannelDTO> findByName(String name);
}
