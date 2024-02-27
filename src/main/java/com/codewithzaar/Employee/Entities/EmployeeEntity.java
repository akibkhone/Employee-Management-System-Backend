package com.codewithzaar.Employee.Entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("employees")
public class EmployeeEntity {

    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;
}