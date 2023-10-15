package ru.my.messenger.messager.model.mappers;

import ru.my.messenger.messager.model.dto.MessageDTO;
import ru.my.messenger.messager.model.entity.MessageEntity;

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
