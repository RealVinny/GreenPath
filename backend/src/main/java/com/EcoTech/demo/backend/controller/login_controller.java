package com.EcoTech.demo.backend.controller;

import com.EcoTech.demo.backend.DTO.login_resposeDTO;
import com.EcoTech.demo.backend.repository.user_repository;
import com.EcoTech.demo.backend.service.login_service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class login_controller {

    private final user_repository user_repository;

    public login_controller(user_repository userRepository) {
        user_repository = userRepository;
    }

    @GetMapping("/{email}/{senha}")
    public login_resposeDTO loginAttempt(@PathVariable String email, @PathVariable String senha) {
        login_service logS = new login_service(user_repository);

        return logS.loginAttempt(email, senha);

    }
}
