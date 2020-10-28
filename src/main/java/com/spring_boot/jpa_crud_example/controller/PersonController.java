package com.spring_boot.jpa_crud_example.controller;

import com.spring_boot.jpa_crud_example.model.Person;
import com.spring_boot.jpa_crud_example.model.PersonEmployeeDTO;
import com.spring_boot.jpa_crud_example.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/person")
@AllArgsConstructor
@Log4j2
public class PersonController {
    private PersonService personService;

    @GetMapping
    public List<Person> getAll() {
        log.info("getAllPersons");
        log.debug("getAllPersons");
        return personService.getAll();
    }

    @GetMapping("/count")
    public int countLines() {
        return personService.countLines();
    }

    @GetMapping("/proc")
    public List<Person> findAllProcedure() {
        return personService.findAllProcedure();
    }

    @GetMapping("/{name}")
    public List<Person> getAllPersonsByName(@PathVariable String name) {
        return personService.findAllPersonsByName(name);
    }

    @GetMapping("/compose")
    public List<PersonEmployeeDTO> composePersonsAndEmployees() {
        return personService.composePersonsAndEmployees();
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }
}
