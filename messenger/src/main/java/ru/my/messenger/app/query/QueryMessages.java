package ru.my.messenger.app.query;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.my.messenger.messenger.model.dto.MessageDTO;


public interface QueryMessages {
    Flux<MessageDTO> findAllByChannelId(String id);
    Mono<MessageDTO> findMessageByMessageId(String id);
}
