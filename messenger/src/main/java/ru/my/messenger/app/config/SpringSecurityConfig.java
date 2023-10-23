package ru.my.messenger.app.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
@EnableMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class SpringSecurityConfig {

    @Value("${messenger.username-manager}")
    private String url;

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http)  {
        return http.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec
                        .pathMatchers("/actuator/**")
                        .permitAll()
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.authenticationManager(authentication -> {
                    String token = authentication.getCredentials().toString();

                    return WebClient.builder()
                            .baseUrl(url)
                            .build()
                            .get()
                            .uri(token)
                            .retrieve()
                            .onStatus(HttpStatus.FORBIDDEN::equals, response -> Mono.error(new IllegalStateException("Token is not valid")))
                            .bodyToMono(Authentication.class);
                }) ))
                .build();
    }
}
