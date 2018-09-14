package com.metacube.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class WelcomeToWebsite {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }
}
