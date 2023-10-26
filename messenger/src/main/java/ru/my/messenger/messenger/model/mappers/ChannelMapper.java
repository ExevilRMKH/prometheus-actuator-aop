package ru.my.messenger.messenger.model.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.my.messenger.messenger.model.dto.ChannelDTO;
import ru.my.messenger.messenger.model.entity.ChannelEntity;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChannelMapper {
    public static ChannelDTO fromEntityToDTO(ChannelEntity entity){
        return ChannelDTO
                .builder()
                .name(entity.getName())
                .uid(entity.getUid())
                .build();
    }

    public static ChannelEntity fromDTOToEntity(ChannelDTO dto){
        return ChannelEntity
                .builder()
                .name(dto.getName())
                .uid(UUID.randomUUID())
                .build();
    }
}
