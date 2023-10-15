package ru.my.user.manager.users.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class UserDTO {
    private UUID uuid;
    private String fullName;
}
