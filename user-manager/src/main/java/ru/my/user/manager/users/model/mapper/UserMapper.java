package ru.my.user.manager.users.model.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.my.user.manager.users.model.dto.UserDTO;
import ru.my.user.manager.users.model.entity.UserEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
    public static UserDTO fromEntityToDTO(UserEntity entity){
        return UserDTO
                .builder()
                .fullName(entity.getFullName())
                .uuid(entity.getUuid())
                .build();
    }

    public static UserEntity fromDTOToEntity(UserDTO dto){
        return new UserEntity()
                .setFullName(dto.getFullName())
                .setLogin(dto.getLogin());
    }
}
