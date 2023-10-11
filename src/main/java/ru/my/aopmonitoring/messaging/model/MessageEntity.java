package ru.my.aopmonitoring.messaging.model;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class MessageEntity {
    private String id;
    private String uuidRecipient;
    private String uuidSender;
    private String message;
    private Timestamp timestamp;
}
