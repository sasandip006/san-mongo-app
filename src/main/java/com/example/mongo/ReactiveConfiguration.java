package com.example.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.mongo.controller.ComponentMongoHandler;

@Configuration(proxyBeanMethods = false)
public class ReactiveConfiguration {

    @Bean
    RouterFunction<ServerResponse> routerFunction(ComponentMongoHandler handler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                handler::requestHello);
    }

}
