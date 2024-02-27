package com.codewithzaar.Employee.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
