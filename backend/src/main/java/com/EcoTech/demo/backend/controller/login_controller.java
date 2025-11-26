package com.EcoTech.demo.backend.controller;

import com.EcoTech.demo.backend.DTO.login_attemptDTO;
import com.EcoTech.demo.backend.DTO.login_resposeDTO;
import com.EcoTech.demo.backend.repository.user_repository;
import com.EcoTech.demo.backend.service.login_service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class login_controller {

    private final user_repository user_repository;


    public login_controller(user_repository userRepository) {
        user_repository = userRepository;

    }

    @PostMapping("/login/")
    public login_resposeDTO loginAttempt(@RequestBody login_attemptDTO login_attemptDTO) {
        login_service login_service = new login_service(user_repository);

        return login_service.loginAttempt(login_attemptDTO.getEmail(), login_attemptDTO.getSenha());

    }
}
