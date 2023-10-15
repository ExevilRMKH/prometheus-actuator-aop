package ru.my.messenger.app.query;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.my.messenger.adapters.persistents.mongo.MessagesRepository;
import ru.my.messenger.messenger.model.mappers.MessageMapper;
import ru.my.messenger.messenger.model.dto.MessageDTO;

@RequiredArgsConstructor
@Service
@Observed(name = "query-message-service")
public class QueryMessagesImpl implements QueryMessages{
    private final MessagesRepository repository;

    @Override
    public Flux<MessageDTO> findAllByChannelId(String id) {
        return repository.findAllByChannelId(id).map(MessageMapper::fromEntityToDTO);
    }

    @Override
    public Mono<MessageDTO> findMessageByMessageId(String id) {
        return repository.findById(id).map(MessageMapper::fromEntityToDTO);
    }
}
