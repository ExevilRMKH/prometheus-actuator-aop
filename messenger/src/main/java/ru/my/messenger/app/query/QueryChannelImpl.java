package ru.my.messenger.app.query;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.my.messenger.adapters.persistents.mongo.ChannelRepository;
import ru.my.messenger.messenger.model.dto.ChannelDTO;
import ru.my.messenger.messenger.model.mappers.ChannelMapper;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Observed(name = "query-message-service")
public class QueryChannelImpl implements QueryChannel{
    private final ChannelRepository repository;
    @Override
    public Flux<ChannelDTO> findAll() {
        return repository.findAll().map(ChannelMapper::fromEntityToDTO);
    }

    @Override
    public Mono<ChannelDTO> findById(UUID id) {
        return repository.findById(id).map(ChannelMapper::fromEntityToDTO);
    }

    @Override
    public Mono<ChannelDTO> findByName(String name) {
        return repository.findChannelEntityByName(name).map(ChannelMapper::fromEntityToDTO);
    }

}
