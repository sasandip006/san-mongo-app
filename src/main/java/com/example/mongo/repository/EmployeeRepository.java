package com.example.mongo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.mongo.beans.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
    Flux<Employee> findByAge(int age);

    Mono<Employee> findByFname(String fname);

}
