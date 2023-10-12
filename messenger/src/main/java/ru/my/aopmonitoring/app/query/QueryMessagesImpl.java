package ru.my.aopmonitoring.app.query;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.my.aopmonitoring.adapters.persistents.MessageEntityRepository;
import ru.my.aopmonitoring.messaging.domain.Message;
import ru.my.aopmonitoring.messaging.model.MessageDTO;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Observed(name = "query-message-service")
public class QueryMessagesImpl implements QueryMessages{
    private final MessageEntityRepository repository;
    @Override
    public List<MessageDTO> getAllMessageByUUID(String uuid) {
        return repository
                .getAllByUuid(uuid)
                .stream()
                .map(Message::fromEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO findMessageByMessageId(String id) {
        return null;
    }
}
