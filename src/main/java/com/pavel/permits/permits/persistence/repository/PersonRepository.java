package com.pavel.permits.permits.persistence.repository;

import com.pavel.permits.permits.model.Person;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pavel on 21.08.2017.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
