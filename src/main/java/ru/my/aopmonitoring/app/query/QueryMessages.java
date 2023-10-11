package ru.my.aopmonitoring.app.query;

import ru.my.aopmonitoring.messaging.model.MessageDTO;

import java.util.List;


public interface QueryMessages {
    List<MessageDTO> getAllMessageByUUID(String uuid);
    MessageDTO findMessageByMessageId(String id);
}
