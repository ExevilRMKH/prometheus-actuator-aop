package ru.my.messenger.app.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.mongodb.MongoMetricsCommandListener;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration {
    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return "messenger";
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient client) {
        return new ReactiveMongoTemplate(client, "messenger");
    }

    @Bean
    public MongoClientSettingsBuilderCustomizer mongoClientSettingsBuilderCustomizer(MeterRegistry meterRegistry) {
        return builder -> builder.addCommandListener(new MongoMetricsCommandListener(meterRegistry));
    }
}
