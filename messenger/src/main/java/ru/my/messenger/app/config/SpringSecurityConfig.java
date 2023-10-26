package ru.my.messenger.app.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
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
public class SpringSecurityConfig implements ReactiveAuthenticationManager {
    @Value("${messenger.username-manager}")
    String url;
    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http, ReactiveAuthenticationManager authenticationManager)  {
         http.csrf(ServerHttpSecurity.CsrfSpec::disable)
                 .authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec
                         .pathMatchers("/actuator/**")
                         .permitAll()
                         .anyExchange()
                         .authenticated()
                 )
                 .oauth2ResourceServer(oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec.jwt(jwtSpec -> jwtSpec.authenticationManager(authenticationManager)));
        return http.build();
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .uri(authentication.getCredentials().toString())
                .retrieve()
                .onStatus(HttpStatus.FORBIDDEN::equals, response -> Mono.error(new IllegalStateException("Token is not valid")))
                .toBodilessEntity()
                .map(entity -> {
                    if (entity.getStatusCode().is2xxSuccessful()){
                        authentication.setAuthenticated(true);
                        return authentication;
                    }
                    return authentication;
                });
    }
}
