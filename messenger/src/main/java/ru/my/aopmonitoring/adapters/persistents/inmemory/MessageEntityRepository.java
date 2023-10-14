package ru.my.aopmonitoring.adapters.persistents.inmemory;

import org.springframework.stereotype.Repository;
import ru.my.aopmonitoring.messaging.model.MessageEntity;

import java.util.List;

public interface MessageEntityRepository {
    void put(MessageEntity message);

    void putListMessage(List<MessageEntity> messageEntities);

    MessageEntity get(String id);

    List<MessageEntity> getAllByUuid(String uuid);
}
