package com.pavel.permits.permits.core.service.impl;

import com.pavel.permits.permits.core.service.PersonService;
import com.pavel.permits.permits.model.Person;
import com.pavel.permits.permits.persistence.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Pavel on 21.08.2017.
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
