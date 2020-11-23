package com.spring.webflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author: Rhys.Ni
 * @date: 2020/6/3
 * @time: 16:37
 * @email rhys.ni@softtek.com
 */
@Component
public class CityHandler {
    public Mono<ServerResponse> helloCity(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello City,I'm Rhys!"));
    }
}
