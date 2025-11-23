package com.EcoTech.demo.backend.service;


import com.EcoTech.demo.backend.DTO.login_resposeDTO;
import com.EcoTech.demo.backend.entity.User;
import com.EcoTech.demo.backend.repository.user_repository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class login_service {
    private final user_repository usRep;

    public login_service(user_repository usRep) {
        this.usRep = usRep;

    }

    public login_resposeDTO loginAttempt(String email, String password) {
        User usrEmail = usRep.findByEmailUsuario(email);
        User usrPass = usRep.findBySenhaCliente(password);

        if (usrEmail.equals(usrPass)) {
            login_resposeDTO loginResposeDTO = new login_resposeDTO();
            loginResposeDTO.setUser_name(usrPass.getNomeCliente());
            loginResposeDTO.setUser_id(usrPass.getId());
            loginResposeDTO.setToken(JWT.create().sign(Algorithm.HMAC256(usrPass.getSenhaCliente())));

            return loginResposeDTO;
        }
        return null;
    }
}
