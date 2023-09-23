package com.saphal.gateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.gateway.config
 * @project treeleaf-demo
 * @since 2023-09-23, Saturday
 **/
@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();

    }
}
