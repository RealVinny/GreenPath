package com.EcoTech.demo.backend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class jwt_service {

    token_properties tks_prop = new token_properties();

    public jwt_service() {

    }

    public String genToken() {
        String new_token = JWT.create().sign(Algorithm.HMAC256(tks_prop.getJwt_secret()));
        return new_token;
    }

    public String valToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        if (decodedJWT.getClaim("token") == null && decodedJWT.getExpiresAt().before(new Date())) {
            System.out.println("Token invalido");
            return null;
        } else {
            return decodedJWT.getClaim("token").toString();
        }
    }

    public Long getUserId(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        if (decodedJWT.getClaim("token") == null) {
            System.out.println("Token invalido");
            return null;
        } else {
            return decodedJWT.getClaim("token").asLong();
        }
    }

}
