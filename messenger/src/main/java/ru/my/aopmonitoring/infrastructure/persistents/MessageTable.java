package ru.my.aopmonitoring.infrastructure.persistents;

import lombok.Getter;
import lombok.Setter;
import ru.my.aopmonitoring.messaging.model.MessageEntity;

import java.util.Map;

@Getter
@Setter
public class MessageTable {
    Map<String, MessageEntity> messageEntities;
}
