package ru.my.user.manager.app.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.my.user.manager.adapters.persistents.UserRepository;
import ru.my.user.manager.app.exception.NotFoundException;
import ru.my.user.manager.users.model.dto.UserDTO;
import ru.my.user.manager.users.model.mapper.UserMapper;

import java.util.UUID;

import static ru.my.user.manager.app.exception.ExceptionMessages.NOT_USER_FOUND;

@Service
@RequiredArgsConstructor
public class CommandUserImpl implements CommandUser{
    private final UserRepository repository;
    @Override
    public void add(UserDTO user) {
        repository.save(UserMapper.fromDTOToEntity(user));
    }

    @Override
    public void delete(UUID uid) {
        repository.deleteById(uid);
    }

    @Override
    public void update(UserDTO user) {
        var userEntity = repository
                .findById(user.getUuid())
                .orElseThrow(() -> new NotFoundException(NOT_USER_FOUND));
        userEntity.setFullName(user.getFullName());
        repository.save(userEntity);
    }

}
