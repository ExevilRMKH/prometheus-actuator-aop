package ru.my.messenger.messenger.model.mappers;

import ru.my.messenger.messenger.model.dto.ChannelDTO;
import ru.my.messenger.messenger.model.entity.ChannelEntity;

public class ChannelMapper {
    public static ChannelDTO fromEntityToDTO(ChannelEntity entity){
        return ChannelDTO
                .builder()
                .name(entity.getName())
                .uid(entity.getUid())
                .build();
    }
}
