package ru.my.aopmonitoring.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.my.aopmonitoring.infrastructure.persistents.MessageTable;
import ru.my.aopmonitoring.messaging.model.MessageEntity;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.UUID;

@Configuration
public class PersistenceConfig {
    @Bean
    public MessageTable persistence(){
        var messages = new HashMap<String, MessageEntity>();
        var table = new MessageTable();

        var firstMessage = MessageEntity
                .builder()
                .message("первое сообщение от пользователя 1")
                .uuidRecipient("2")
                .uuidSender("1")
                .id(UUID.randomUUID().toString())
                .timestamp(Timestamp.from(Instant.now()))
                .build();

        var secondMessage = MessageEntity
                .builder()
                .uuidSender("2")
                .uuidRecipient("1")
                .message("первое сообщение от пользователя 2")
                .timestamp(Timestamp.from(Instant.now()))
                .id(UUID.randomUUID().toString())
                .build();

        messages.put(firstMessage.getId(), firstMessage);
        messages.put(secondMessage.getId(), secondMessage);
        table.setMessageEntities(messages);

        return table;
    }
}
