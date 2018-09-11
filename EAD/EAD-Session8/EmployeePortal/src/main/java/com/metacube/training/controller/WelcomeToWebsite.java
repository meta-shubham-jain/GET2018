package com.metacube.training.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class WelcomeToWebsite {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }
}
