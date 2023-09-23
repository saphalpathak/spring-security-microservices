package com.saphal.gateway.config;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import java.util.function.Consumer;

/**
 * @author Saphal Pathak
 * @version 1.0
 * @Package com.saphal.gateway.config
 * @project treeleaf-demo
 * @since 2023-09-23, Saturday
 **/
public class HeaderConsumers implements Consumer<HttpHeaders> {

    private final MultiValueMap<String, String> map;

    public HeaderConsumers(MultiValueMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void accept(HttpHeaders httpHeaders) {
        this.map.forEach((key1, value) -> value.forEach(obj -> {
            httpHeaders.add(key1, obj);
        }));
    }
}
