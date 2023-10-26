package ru.my.messenger.app.command;

import reactor.core.publisher.Mono;
import ru.my.messenger.messenger.model.dto.ChannelDTO;

import java.util.UUID;

public interface CommandChannel {
    Mono<UUID> add(Mono<ChannelDTO> body);
    Mono<Void> delete(Mono<String> channelId, String token);
    Mono<Void> changeOwner(Mono<String> uuid, String token);
}
