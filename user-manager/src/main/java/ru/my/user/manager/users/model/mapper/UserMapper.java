package ru.my.user.manager.users.model.mapper;

import ru.my.user.manager.users.model.dto.UserDTO;
import ru.my.user.manager.users.model.entity.UserEntity;

public class UserMapper {
    public static UserDTO fromEntityToDTO(UserEntity entity){
        return UserDTO
                .builder()
                .fullName(entity.getFullName())
                .uuid(entity.getUuid())
                .build();
    }
}
