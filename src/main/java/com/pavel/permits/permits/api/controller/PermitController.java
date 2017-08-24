package com.pavel.permits.permits.api.controller;

import com.pavel.permits.permits.api.dto.PermitDto;
import com.pavel.permits.permits.core.service.CodeService;
import com.pavel.permits.permits.core.service.PermitService;
import com.pavel.permits.permits.model.Permit;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.Api;

/**
 * Created by Pavel on 24.08.2017.
 */

//TODO: Date format
@RestController
@RequestMapping("/api/permit")
@Api(value = "/api/permit", description = "Permits")
public class PermitController {

    @Autowired
    private PermitService service;

    @Autowired
    private CodeService codeService;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PermitDto createPermit(@RequestBody PermitDto permitDto) {
        Permit permit = convertToEntity(permitDto);
        Permit createdPermit = service.save(permit);

        return convertToDto(createdPermit);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PermitDto> getAllPermits() {
        List<Permit> permits = service.findAll();

        return permits.stream()
                .map(p -> convertToDto(p))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public PermitDto getPermit(@PathVariable("id") Integer id) {

        return convertToDto(service.findOne(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public PermitDto updatePermit(
            @PathVariable("id") Integer id, @RequestBody PermitDto permitDto) {
        Permit permit = convertToEntity(permitDto);
        permit.setId(id);

        return convertToDto(service.save(permit));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deletePermit(@PathVariable("id") Integer id) {

        service.delete(id);
    }

    private PermitDto convertToDto(Permit permit) {
        PermitDto permitDto = mapper.map(permit, PermitDto.class);
        return permitDto;
    }

    private Permit convertToEntity(PermitDto permitDto) {
        Permit permit = mapper.map(permitDto, Permit.class);

        //TODO: add configs for ModelMapper
        permit.setCodes(new ArrayList<>());
        for (Integer codeId : permitDto.getCodeIds()) {
            permit.getCodes().add(codeService.findOne(codeId));
        }
        return permit;
    }
}
