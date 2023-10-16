package ru.my.user.manager.users.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import ru.my.user.manager.users.model.entity.UserEntity;

@Component
@RequiredArgsConstructor
public class UserManager {
    private final JwtProvider provider;

    @Getter
    @Setter
    @Accessors(chain = true)
    static class User{
        private String login;
        private String fullName;
        private String uuid;
    }

    public boolean validateToken(String token){
        return provider.validateAccessToken(token);
    }

    public String getToken(UserEntity entity){
        var user = new User()
                .setFullName(entity.getFullName())
                .setLogin(entity.getLogin())
                .setUuid(entity.getUuid().toString());
        return provider.generateAccessToken(user);
    }
}
