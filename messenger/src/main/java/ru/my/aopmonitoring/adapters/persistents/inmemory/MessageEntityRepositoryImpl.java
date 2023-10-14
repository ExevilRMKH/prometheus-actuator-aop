package ru.my.aopmonitoring.adapters.persistents.inmemory;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.my.aopmonitoring.infrastructure.persistents.MessageTable;
import ru.my.aopmonitoring.messaging.model.MessageEntity;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
@Observed(name = "message.repository")
public class MessageEntityRepositoryImpl implements MessageEntityRepository {
    private final MessageTable table;

    public void put(MessageEntity message){
        table.getMessageEntities().put(message.getId(),message);
    }

    public void putListMessage(List<MessageEntity> messageEntities){
        var map = messageEntities
                .stream()
                .collect(Collectors.toMap(MessageEntity::getId, k -> k));
        table.getMessageEntities().putAll(map);
    }

    public MessageEntity get(String id){
        return table.getMessageEntities().get(id);
    }

    public List<MessageEntity> getAllByUuid(String uuid){
        var list = table.getMessageEntities()
                .values()
                .stream()
                .filter(message -> uuid.equals(message.getUuidSender()) || uuid.equals(message.getUuidRecipient()))
                .toList();

        if(list.isEmpty()){
            throw new RuntimeException("");
        }
        
        return list;
    }
}
