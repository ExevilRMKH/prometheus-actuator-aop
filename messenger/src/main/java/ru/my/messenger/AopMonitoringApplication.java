package ru.my.messenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EnableReactiveMongoRepositories
public class AopMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopMonitoringApplication.class, args);
    }

}
