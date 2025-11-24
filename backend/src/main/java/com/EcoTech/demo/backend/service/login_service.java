package com.EcoTech.demo.backend.service;


import com.EcoTech.demo.backend.DTO.login_resposeDTO;
import com.EcoTech.demo.backend.entity.User;
import com.EcoTech.demo.backend.repository.user_repository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class login_service {

    private final user_repository usRep;

    public login_service(user_repository usRep) {
        this.usRep = usRep;

    }

    public login_resposeDTO loginAttempt(String email, String password) {
        User userLog = usRep.findByEmailUsuarioAndSenhaCliente(email, password);

        login_resposeDTO logRes = new login_resposeDTO();
        logRes.setToken(JWT.create().sign(Algorithm.HMAC256(password)));
        logRes.setUser_name(userLog.getNomeCliente());
        logRes.setUser_id(userLog.getId());

        return logRes;


    }
}
