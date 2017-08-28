package com.pavel.permits.permits.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Pavel on 28.08.2017.
 */

@Controller
public class ViewController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {

        return "home";
    }
}
