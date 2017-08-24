package com.pavel.permits.permits.api.controller;

import com.pavel.permits.permits.api.dto.PersonDto;
import com.pavel.permits.permits.core.service.PersonService;
import com.pavel.permits.permits.model.Person;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.Api;

/**
 * Created by Pavel on 24.08.2017.
 */

@RestController
@RequestMapping("/api/person")
@Api(value = "/api/person", description = "Persons")
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        Person person = convertToEntity(personDto);


        Person createdPerson = service.save(person);

        return convertToDto(createdPerson);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PersonDto> getAllPersons() {
        List<Person> persons = service.findAll();

        return persons.stream()
                .map(p -> convertToDto(p))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public PersonDto getPerson(@PathVariable("id") Integer id) {

        return convertToDto(service.findOne(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public PersonDto updatePerson(
            @PathVariable("id") Integer id, @RequestBody PersonDto personDto) {
        Person person = convertToEntity(personDto);
        person.setId(id);

        return convertToDto(service.save(person));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") Integer id) {

        service.delete(id);
    }

    private PersonDto convertToDto(Person person) {
        PersonDto personDto = mapper.map(person, PersonDto.class);
        return personDto;
    }

    private Person convertToEntity(PersonDto personDto) {
        Person person = mapper.map(personDto, Person.class);
        return person;
    }
}
