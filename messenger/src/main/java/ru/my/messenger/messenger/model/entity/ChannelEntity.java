package ru.my.messenger.messenger.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Setter
@Getter
@Builder
public class ChannelEntity {
    @Id
    private UUID uid;
    private String name;
}
