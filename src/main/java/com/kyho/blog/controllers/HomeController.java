package com.kyho.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {

        return "index";
    }

    @RequestMapping(value = "/signup")
    public String signUp() {
        return "signup";
    }

}
