package ru.my.messenger.infrastructure.metrics.persistents;

import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MessageTable {
    private final ObservationRegistry registry;

//    @Bean
//    public
}
