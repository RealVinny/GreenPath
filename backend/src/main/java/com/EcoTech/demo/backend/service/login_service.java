package com.EcoTech.demo.backend.service;


import com.EcoTech.demo.backend.DTO.login_resposeDTO;
import com.EcoTech.demo.backend.entity.User;
import com.EcoTech.demo.backend.repository.user_repository;
import com.EcoTech.demo.backend.security.jwt_service;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@AutoConfiguration
public class login_service {

    private final user_repository usRep;
    private jwt_service jwService;

    public login_service(user_repository usRep) {
        this.usRep = usRep;
    }

    public login_resposeDTO loginAttempt(String email, String password) {

        if (usRep.findByEmailUsuarioAndSenhaCliente(email, password) == null) {
            return null;
        } else {
            User user = usRep.findByEmailUsuarioAndSenhaCliente(email, password);
            login_resposeDTO login_resposeDTO = new login_resposeDTO();
            login_resposeDTO.setUser_id(user.getId());
            login_resposeDTO.setUser_name(user.getNomeCliente());
            login_resposeDTO.setToken(jwService.genToken());
            return login_resposeDTO;
        }


    }
}
