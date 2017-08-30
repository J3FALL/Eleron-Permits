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

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String personsPage() {
        return "persons";
    }

    @RequestMapping(value = "/orgs", method = RequestMethod.GET)
    public String orgsPage() {
        return "orgs";
    }

    @RequestMapping(value = "/positions", method = RequestMethod.GET)
    public String positionsPage() {
        return "positions";
    }
}
