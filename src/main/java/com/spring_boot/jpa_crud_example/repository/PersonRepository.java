package com.spring_boot.jpa_crud_example.repository;

import com.spring_boot.jpa_crud_example.model.Person;
import com.spring_boot.jpa_crud_example.model.PersonEmployeeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getAllPersons() {
        return entityManager.createNativeQuery("SELECT * FROM person", Person.class).getResultList();
    }

    @Transactional
    public Person savePerson(Person person) {
        entityManager.persist(person);
        return person;
    }

    public int countLines() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(() -> {
           return ((BigInteger) entityManager.createNativeQuery("call countproc").getSingleResult()).intValue();
        });
        try {
            return (int) future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Person> findAllPersonsProcedure() {
        return entityManager.createNativeQuery("call getPersonList").getResultList();
    }

    public List<Person> findAllPersonsByName(String name) {
        return entityManager.createNativeQuery("call getPersonListByName (:name)").setParameter("name", name).getResultList();
    }

    public List<PersonEmployeeDTO> composePersonsAndEmployees() {
        return entityManager
                .createQuery("SELECT p.firstName, p.lastName, e.position FROM Person p, Employee e WHERE p.firstName = e.firstName AND p.lastName = e.lastName")
                .getResultList();
    }
}
