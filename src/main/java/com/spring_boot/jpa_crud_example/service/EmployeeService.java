package com.spring_boot.jpa_crud_example.service;

import com.spring_boot.jpa_crud_example.model.Employee;
import com.spring_boot.jpa_crud_example.model.PersonEmployeeDTO;
import com.spring_boot.jpa_crud_example.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    public List<PersonEmployeeDTO> composePersonsAndEmployees() {
        return employeeRepository.composePersonsAndEmployees();
    }
}
