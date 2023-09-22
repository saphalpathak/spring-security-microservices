package com.saphal.gateway.config;

import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.gateway.config
 * @project treeleaf-demo
 * @since 2023-09-23, Saturday
 **/

@RestController
public class SwaggerConfig {

    private final DiscoveryClient discoveryClient;

    public SwaggerConfig(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/swagger-config.json")
    public Map<String, Object> swaggerConfig() {
        List<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls = new ArrayList<>();
        discoveryClient.getServices()
                .forEach(serviceName ->
                        discoveryClient.getInstances(serviceName).forEach(serviceInstance ->
                                urls.add(new AbstractSwaggerUiConfigProperties.SwaggerUrl(serviceName, serviceInstance.getUri() + "/v1/api-docs", serviceName)
                                )
                        ));
        return Map.of("urls", urls);

    }
}
