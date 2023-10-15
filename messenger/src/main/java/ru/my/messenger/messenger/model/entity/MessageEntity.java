package ru.my.messenger.messenger.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Getter
@Builder
@Document
public class MessageEntity {
    @Id
    private String id;
    private String channelId;
    private String uuidRecipient;
    private String uuidSender;
    private String parentId;
    private String message;
    private Timestamp timestamp;
}
