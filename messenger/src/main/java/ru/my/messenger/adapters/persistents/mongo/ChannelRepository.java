package ru.my.messenger.adapters.persistents.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Mono;
import ru.my.messenger.messaging.model.entity.ChannelEntity;

@EnableReactiveMongoRepositories
public interface ChannelRepository extends ReactiveMongoRepository<ChannelEntity, String> {
    Mono<ChannelEntity> findChannelEntityByName(String name);
}
