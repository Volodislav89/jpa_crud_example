package com.spring_boot.jpa_crud_example.service;

import com.spring_boot.jpa_crud_example.model.Person;
import com.spring_boot.jpa_crud_example.model.PersonEmployeeDTO;
import com.spring_boot.jpa_crud_example.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.getAllPersons();
    }

    public List<PersonEmployeeDTO> composePersonsAndEmployees() {
        return personRepository.composePersonsAndEmployees();
    }

    public Person savePerson(Person person) {
        return personRepository.savePerson(person);
    }

    public int countLines() {
        return personRepository.countLines();
    }

    public List<Person> findAllProcedure() {
        return personRepository.findAllPersonsProcedure();
    }

    public List<Person> findAllPersonsByName(String name) {
        return personRepository.findAllPersonsByName(name);
    }
}
