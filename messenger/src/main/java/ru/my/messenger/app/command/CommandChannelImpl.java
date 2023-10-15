package ru.my.messenger.app.command;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.my.messenger.messenger.model.dto.ChannelDTO;

@Service
public class CommandChannelImpl implements CommandChannel{
    @Override
    public void add(Mono<ChannelDTO> channelId, String token) {

    }

    @Override
    public void delete(Mono<String> channelId, String token) {

    }

    @Override
    public void changeOwner(Mono<String> uuid, String token) {

    }
}
