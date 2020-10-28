package com.spring_boot.jpa_crud_example.controller;

import com.spring_boot.jpa_crud_example.model.Employee;
import com.spring_boot.jpa_crud_example.model.PersonEmployeeDTO;
import com.spring_boot.jpa_crud_example.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/compose")
    public List<PersonEmployeeDTO> composePersonsAndEmployees() {
        return employeeService.composePersonsAndEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
}
