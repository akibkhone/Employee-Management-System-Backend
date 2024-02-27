package com.codewithzaar.Employee.Repositories;

import com.codewithzaar.Employee.Entities.EmployeeEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, ObjectId> {
}
