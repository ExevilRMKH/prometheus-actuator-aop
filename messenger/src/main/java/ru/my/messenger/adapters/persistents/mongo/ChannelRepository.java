package ru.my.messenger.adapters.persistents.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Mono;
import ru.my.messenger.messenger.model.entity.ChannelEntity;

import java.util.UUID;

@EnableReactiveMongoRepositories
public interface ChannelRepository extends ReactiveMongoRepository<ChannelEntity, UUID> {
    Mono<ChannelEntity> findChannelEntityByName(String name);
}
