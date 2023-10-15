package ru.my.user.manager.app.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import ru.my.user.manager.adapters.persistents.UserRepository;
import ru.my.user.manager.app.exception.NotFoundException;
import ru.my.user.manager.users.model.dto.UserDTO;
import ru.my.user.manager.users.model.mapper.UserMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QueryUserImpl implements QueryUser{
    private final UserRepository repository;
    @Override
    public Flux<UserDTO> getAll() {
        return Flux.fromStream(() -> repository.findAll().stream().map(UserMapper::fromEntityToDTO));
    }

    @Override
    public Mono<UserDTO> getById(UUID uuid) {
        return Mono.fromCallable(() ->
                repository
                        .findById(uuid)
                        .orElseThrow(() -> new NotFoundException("User not found")))
                .map(UserMapper::fromEntityToDTO)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<String> getTokenByLogin(String uuid) {
        return null;
    }
}
