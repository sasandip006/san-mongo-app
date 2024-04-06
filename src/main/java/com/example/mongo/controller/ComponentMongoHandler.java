package com.example.mongo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.mongo.beans.Employee;
import com.example.mongo.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ComponentMongoHandler {

    @Autowired
    EmployeeRepository repo;

    public Mono<ServerResponse> requestHello(ServerRequest request) {
        log.info("THis is Request Handletr Method form the request Hello ---------------------------------- ok ok "
                + request.path());
        Mono<Employee> emp = repo.save(new Employee(null, "Sandy", "Andhale", 32, LocalDate.now()));
        emp.subscribe();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Employee()));
    }

}
