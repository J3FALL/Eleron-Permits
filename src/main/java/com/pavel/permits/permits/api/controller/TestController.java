package com.pavel.permits.permits.api.controller;

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

    @RequestMapping(value = "/custom", method = RequestMethod.POST)
    public String custom() {
        return "custom";
    }
}

