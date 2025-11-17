package com.EcoTech.demo.controller;

import com.EcoTech.demo.DTOs.UserDTO;
import com.EcoTech.demo.services.User_service;
import com.EcoTech.demo.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class user_controller {

    private final User_service user_service;

    public user_controller(User_service userService) {
        this.user_service = userService;

    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable long id) {
        return user_service.getUser(id);
    }
    @GetMapping("/error")
    public String error() {
        return "erro";
    }
}
