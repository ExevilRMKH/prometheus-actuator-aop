package ru.my.messenger.messager.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@Builder
public class ChannelEntity {
    @Id
    private String uid;
    private String name;
}
