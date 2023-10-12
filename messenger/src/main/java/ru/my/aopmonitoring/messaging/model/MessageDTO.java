package ru.my.aopmonitoring.messaging.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageDTO {
    private String uuidRecipient;
    private String uuidSender;
    private String message;
}
