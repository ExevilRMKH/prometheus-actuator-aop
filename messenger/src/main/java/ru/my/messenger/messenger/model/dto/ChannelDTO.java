package ru.my.messenger.messager.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChannelDTO {
    private String name;
    private String uid;
}
