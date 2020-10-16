package com.spring_boot.jpa_crud_example.controller;

import com.spring_boot.jpa_crud_example.model.Person;
import com.spring_boot.jpa_crud_example.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {
    private PersonService personService;

    @GetMapping
    public List<Person> getAll() {
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

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }
}
