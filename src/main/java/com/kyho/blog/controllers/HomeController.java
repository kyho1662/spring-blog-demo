package com.kyho.blog.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
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


    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(value = "/write")
    public String write() {return "write"; }

    @RequestMapping(value = "/login")
    public String login() {return "login"; }

    @RequestMapping(value = "/mypage")
    public String myPage() {return "mypage"; }





}
