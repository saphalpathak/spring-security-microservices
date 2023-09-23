package com.saphal.gateway.interceptor;

import com.saphal.gateway.config.HeaderConsumers;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.gateway.interceptor
 * @project treeleaf-demo
 * @since 2023-09-23, Saturday
 **/
@Component
public class AuthenticationPrefilter extends AbstractGatewayFilterFactory<AuthenticationPrefilter.Config> {

    private final WebClient.Builder webclientBuilder;

    private final String authenticationUrl = "http://AUTH-SERVICE/api/v1/user/validate";

    public AuthenticationPrefilter(WebClient.Builder webclientBuilder) {
        super(Config.class);
        this.webclientBuilder = webclientBuilder;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String bearerToken = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            LinkedMultiValueMap<String, String> header = new LinkedMultiValueMap<>();
            header.add(HttpHeaders.AUTHORIZATION, bearerToken);

            return webclientBuilder
                    .build()
                    .get()
                    .uri(authenticationUrl)
                    .headers(new HeaderConsumers(header))
                    .retrieve()
                    .onStatus(HttpStatus.UNAUTHORIZED::equals, clientResponse -> {
                        ServerHttpResponse response = exchange.getResponse();
                        response.setStatusCode(HttpStatus.UNAUTHORIZED);
                        return Mono.error(new RuntimeException());
                    })
                    .onStatus(HttpStatus.FORBIDDEN::equals, clientResponse -> {
                        ServerHttpResponse response = exchange.getResponse();
                        response.setStatusCode(HttpStatus.FORBIDDEN);
                        return Mono.error(new RuntimeException());
                    })
                    .bodyToMono(Boolean.class)
                    .map(response -> exchange)
                    .flatMap(chain::filter)
                    .onErrorResume(throwable -> exchange.getResponse().setComplete());
        };
    }

    public static class Config {

    }
}

