package com.EcoTech.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-word")
public class InnovationController {

    @GetMapping("/get")
    public String hello_word(){
        return "Hello World!";
    }

    @GetMapping("setup")
    public String setup(){
        return "setup";
    }
}
