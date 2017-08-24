package com.pavel.permits.permits.api.controller;

import com.pavel.permits.permits.api.dto.PassDto;
import com.pavel.permits.permits.core.service.PassService;
import com.pavel.permits.permits.model.Pass;

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
@RequestMapping("/api/pass")
@Api(value = "/api/pass", description = "Passes")
public class PassController {
    @Autowired
    private PassService service;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PassDto createPass(@RequestBody PassDto passDto) {
        Pass pass = convertToEntity(passDto);
        Pass createdPass = service.save(pass);

        return convertToDto(createdPass);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PassDto> getAllPasses() {
        List<Pass> passes = service.findAll();

        return passes.stream()
                .map(p -> convertToDto(p))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public PassDto getPass(@PathVariable("id") Integer id) {

        return convertToDto(service.findOne(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public PassDto updatePass(
            @PathVariable("id") Integer id, @RequestBody PassDto passDto) {
        Pass pass = convertToEntity(passDto);
        pass.setId(id);

        return convertToDto(service.save(pass));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deletePass(@PathVariable("id") Integer id) {

        service.delete(id);
    }

    private PassDto convertToDto(Pass pass) {
        PassDto passDto = mapper.map(pass, PassDto.class);
        return passDto;
    }

    private Pass convertToEntity(PassDto passDto) {
        Pass pass = mapper.map(passDto, Pass.class);
        return pass;
    }
}
