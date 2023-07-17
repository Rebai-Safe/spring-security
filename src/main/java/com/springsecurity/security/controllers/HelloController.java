package com.springsecurity.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/login")
    public String greetings() {
        return "Hello";
    }

    @GetMapping(value = "/user")
    public String user() {
        return "Hi user";
    }


    @GetMapping(value = "/logout")
    public String goodBye() {
        return "Good Bye";
    }
}
