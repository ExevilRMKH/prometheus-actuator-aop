package ru.my.messenger.app.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.my.messenger.adapters.persistents.mongo.ChannelRepository;
import ru.my.messenger.messenger.model.dto.ChannelDTO;
import ru.my.messenger.messenger.model.entity.ChannelEntity;
import ru.my.messenger.messenger.model.mappers.ChannelMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommandChannelImpl implements CommandChannel{
    private final ChannelRepository repository;
    @Override
    public Mono<UUID> add(Mono<ChannelDTO> body) {
        return body.map(ChannelMapper::fromDTOToEntity)
                .flatMap(repository::save)
                .map(ChannelEntity::getUid);
    }

    @Override
    public Mono<Void> delete(Mono<String> channelId, String token) {
        return Mono.empty();
    }

    @Override
    public Mono<Void> changeOwner(Mono<String> uuid, String token) {
        return Mono.empty();
    }
}
