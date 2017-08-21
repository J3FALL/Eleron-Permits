package com.pavel.permits.permits.api.controller;

import com.pavel.permits.permits.model.Code;
import com.pavel.permits.permits.persistence.repository.CodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Pavel on 20.08.2017.
 */
@RestController
@Api(value = "/api/test", description = "Controller for swagger integration check")
public class TestController {

    @Autowired
    private CodeRepository codeRepository;

    @RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom()
    {
        Code code = new Code();
        code.setName("test");
        codeRepository.save(code);

        Code savedCode = codeRepository.findOne(code.getId());
        System.out.println(savedCode.toString());
        return "custom";
    }
}

