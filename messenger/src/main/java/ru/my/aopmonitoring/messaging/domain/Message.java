package ru.my.aopmonitoring.messaging.domain;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;
import ru.my.aopmonitoring.messaging.model.MessageDTO;
import ru.my.aopmonitoring.messaging.model.MessageEntity;

public class Message {
    public static MessageDTO fromEntityToDTO(MessageEntity entity){
        return MessageDTO
                .builder()
                .message(entity.getMessage())
                .uuidSender(entity.getUuidSender())
                .uuidRecipient(entity.getUuidRecipient())
                .build();
    }
}
