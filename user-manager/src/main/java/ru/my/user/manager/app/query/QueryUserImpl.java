package ru.my.user.manager.app.query;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.my.user.manager.adapters.persistents.UserRepository;
import ru.my.user.manager.app.exception.NotFoundException;
import ru.my.user.manager.app.exception.UserManagerException;
import ru.my.user.manager.users.domain.UserManager;
import ru.my.user.manager.users.model.dto.UserDTO;
import ru.my.user.manager.users.model.mapper.UserMapper;

import java.util.UUID;

import static ru.my.user.manager.app.exception.ExceptionMessages.INVALID_TOKEN;
import static ru.my.user.manager.app.exception.ExceptionMessages.NOT_USER_FOUND;

@Service
@RequiredArgsConstructor
@Observed(name = "user_manager.query")
public class QueryUserImpl implements QueryUser{
    private final UserRepository repository;
    private final UserManager manager;
    @Override
    public Flux<UserDTO> getAll() {
        return Flux.fromStream(() -> repository.findAll().stream().map(UserMapper::fromEntityToDTO));
    }

    @Override

    public Mono<UserDTO> getById(UUID uuid) {
        return Mono.fromCallable(() ->
                repository
                        .findById(uuid)
                        .orElseThrow(() -> new NotFoundException(NOT_USER_FOUND)))
                .map(UserMapper::fromEntityToDTO)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public String getTokenByLoginAndUuid(String login, UUID uuid) {
        var entity = repository
                .findById(uuid)
                .orElseThrow(() -> new NotFoundException(NOT_USER_FOUND));

        if(entity.getLogin().equals(login))
            return manager.getToken(entity);

        throw new UserManagerException(NOT_USER_FOUND);
    }

    @Override
    public void validateToken(String token) {
        if(manager.validateToken(token))
            return;

        throw new UserManagerException(INVALID_TOKEN);
    }
}
