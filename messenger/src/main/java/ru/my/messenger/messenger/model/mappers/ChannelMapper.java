package ru.my.messenger.messager.model.mappers;

import ru.my.messenger.messager.model.dto.ChannelDTO;
import ru.my.messenger.messager.model.entity.ChannelEntity;

public class ChannelMapper {
    public static ChannelDTO fromEntityToDTO(ChannelEntity entity){
        return ChannelDTO
                .builder()
                .name(entity.getName())
                .uid(entity.getUid())
                .build();
    }
}
