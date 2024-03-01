package com.codewithzaar.Employee.Controller;

import com.codewithzaar.Employee.Model.EmployeeDTO;
import com.codewithzaar.Employee.Services.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addEmployee")
    public EmployeeDTO createEmployee(@RequestBody  EmployeeDTO employeeDTO)
    {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeDTO> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable String id)
    {
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(new ObjectId(id));
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String id)
    {
        EmployeeDTO employeeDTO = null;
        employeeDTO = employeeService.getEmployeeById(new  ObjectId(id));
        return ResponseEntity.ok(employeeDTO);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable String id, @RequestBody EmployeeDTO employeeDTO)
    {
        employeeDTO = employeeService.updateEmployeeById(new  ObjectId(id), employeeDTO);
        return ResponseEntity.ok(employeeDTO);
    }

}
