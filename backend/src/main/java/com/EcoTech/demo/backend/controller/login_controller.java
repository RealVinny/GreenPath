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

    private login_service login_service;
    private user_repository user_repository;

    @GetMapping("/{email}/{senha}")
    public login_resposeDTO loginAttempt(@PathVariable String email, @PathVariable String senha) {
        login_service login_service = new login_service(user_repository);
        login_resposeDTO loginResposeDTO = login_service.loginAttempt(email, senha);

        return loginResposeDTO;

    }
}
