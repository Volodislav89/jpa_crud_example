package com.spring_boot.jpa_crud_example.repository;

import com.spring_boot.jpa_crud_example.model.Employee;
import com.spring_boot.jpa_crud_example.model.PersonEmployeeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getAllEmployees() {
        return entityManager.createNativeQuery("SELECT * FROM employee", Employee.class).getResultList();
    }

    public List<PersonEmployeeDTO> composePersonsAndEmployees() {
        return entityManager
                .createQuery("SELECT p.firstName, p.lastName, e.position FROM Person p, Employee e WHERE p.firstName = e.firstName AND p.lastName = e.lastName")
                .getResultList();
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }
}
