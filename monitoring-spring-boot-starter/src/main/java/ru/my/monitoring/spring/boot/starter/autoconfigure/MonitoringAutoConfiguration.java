package ru.my.monitoring.spring.boot.starter.autoconfigure;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class MonitoringAutoConfiguration {
    private final BuildProperties buildProperties;
    MonitoringAutoConfiguration(BuildProperties buildProperties){
        this.buildProperties = buildProperties;
    }

    @Bean
    public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        return new ObservedAspect(observationRegistry);
    }

    @Bean
    public MeterFilter meterFilter(){
        return MeterFilter.commonTags(Tags.of("application", buildProperties.getArtifact()).and("version", buildProperties.getVersion()));
    }
}