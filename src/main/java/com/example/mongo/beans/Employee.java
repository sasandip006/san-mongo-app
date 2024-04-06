package com.example.mongo.beans;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Employee {

    @Id
    private String id;
    private String fname;
    private String lName;
    private int age;
    private LocalDate dateOfBirth;

}
