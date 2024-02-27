package com.codewithzaar.Employee.Services;

import com.codewithzaar.Employee.Model.EmployeeDTO;
import org.bson.types.ObjectId;

import java.util.List;

public interface EmployeeService {
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    public List<EmployeeDTO> getAllEmployees();

    public boolean deleteEmployee(ObjectId id);

    public EmployeeDTO getEmployeeById(ObjectId id);

    public EmployeeDTO updateEmployeeById(ObjectId id, EmployeeDTO employeeDTO);
}
