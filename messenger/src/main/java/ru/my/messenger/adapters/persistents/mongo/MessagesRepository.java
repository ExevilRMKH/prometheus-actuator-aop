package ru.my.messenger.adapters.persistents.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;
import ru.my.messenger.messaging.model.entity.MessageEntity;

@EnableReactiveMongoRepositories
public interface MessagesRepository extends ReactiveMongoRepository<MessageEntity, String> {
    Flux<MessageEntity> findAllByChannelId(String channelId);
    Flux<MessageEntity> findAllByUuidRecipientOrUuidSender(String recipient, String sender);
}
