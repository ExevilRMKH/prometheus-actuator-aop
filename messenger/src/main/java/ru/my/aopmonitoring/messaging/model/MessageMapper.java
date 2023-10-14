package ru.my.aopmonitoring.messaging.model;

import ru.my.aopmonitoring.messaging.model.MessageDTO;
import ru.my.aopmonitoring.messaging.model.MessageEntity;

public class MessageMapper {
    public static MessageDTO fromEntityToDTO(MessageEntity entity){
        return MessageDTO
                .builder()
                .message(entity.getMessage())
                .uuidSender(entity.getUuidSender())
                .uuidRecipient(entity.getUuidRecipient())
                .build();
    }
}
