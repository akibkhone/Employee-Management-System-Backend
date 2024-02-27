package com.codewithzaar.Employee.Services;

import com.codewithzaar.Employee.Entities.EmployeeEntity;
import com.codewithzaar.Employee.Model.EmployeeDTO;
import com.codewithzaar.Employee.Repositories.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = employeeEntities
                .stream()
                .map(employee ->
                        new EmployeeDTO(String.valueOf(employee.getId()),
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getEmail()))
                .collect(Collectors.toList());
        return employeeDTOS;
    }

    @Override
    public boolean deleteEmployee(ObjectId id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeRepository.delete(employeeEntity);
        return true;
    }

    @Override
    public EmployeeDTO getEmployeeById(ObjectId id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
//        EmployeeDTO employeeDTO = new EmployeeDTO(String.valueOf(employeeEntity.getId()), employeeEntity.getFirstName(), employeeEntity.getLastName(), employeeEntity.getEmail())
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employeeEntity, employeeDTO);
        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployeeById(ObjectId id, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeRepository.save(employeeEntity);
        return employeeDTO;
    }
}
