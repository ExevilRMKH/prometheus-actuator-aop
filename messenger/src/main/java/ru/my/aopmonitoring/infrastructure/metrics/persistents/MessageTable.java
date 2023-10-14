package ru.my.aopmonitoring.infrastructure.metrics.persistents;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessageTable {
    private final ObservationRegistry registry;

//    @Bean
//    public
}
