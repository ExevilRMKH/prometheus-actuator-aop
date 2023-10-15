package ru.my.messenger.app.command;

import reactor.core.publisher.Mono;
import ru.my.messenger.messenger.model.dto.ChannelDTO;

public interface CommandChannel {
    void add(Mono<ChannelDTO> channelId, String token);
    void delete(Mono<String> channelId, String token);
    void changeOwner(Mono<String> uuid, String token);
}
