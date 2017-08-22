package com.pavel.permits.permits.api.controller;

import com.pavel.permits.permits.api.dto.CodeDto;
import com.pavel.permits.permits.core.service.CodeService;
import com.pavel.permits.permits.model.Code;

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
 * Created by Pavel on 22.08.2017.
 */
@RestController
@RequestMapping("/api/code")
@Api(value = "/api/code", description = "Codes")
public class CodeController {

    @Autowired
    private CodeService service;

    @Autowired
    private ModelMapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public CodeDto createCode(@RequestBody CodeDto codeDto) {
        Code code = convertToEntity(codeDto);
        Code createdCode = service.save(code);

        return convertToDto(createdCode);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<CodeDto> getAllCodes() {
        List<Code> codes = service.findAll();

        return codes.stream()
                .map(code -> convertToDto(code))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public CodeDto getCode(@PathVariable("id") Integer id) {
        return convertToDto(service.findOne(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CodeDto updateCode(@PathVariable("id") Integer id, @RequestBody CodeDto codeDto) {
        Code code = convertToEntity(codeDto);
        code.setId(id);
        return convertToDto(service.save(code));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCode(@PathVariable("id") Integer id) {
        service.delete(id);
    }

    private CodeDto convertToDto(Code code) {
        CodeDto codeDto = mapper.map(code, CodeDto.class);
        return codeDto;
    }

    private Code convertToEntity(CodeDto codeDto) {
        Code code = mapper.map(codeDto, Code.class);
        return code;
    }
}
