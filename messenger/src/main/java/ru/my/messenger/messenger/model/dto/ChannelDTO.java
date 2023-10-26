package ru.my.messenger.messenger.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class ChannelDTO {
    private String name;
    private UUID uid;
}
