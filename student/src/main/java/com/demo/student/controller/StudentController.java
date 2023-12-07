package com.demo.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/getWelcomeMessage")
    public String getWelcomeMessage(){
        return "Welcome to Student Application";
    }
}
