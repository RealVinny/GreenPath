package com.EcoTech.demo.backend.security;


import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableAutoConfiguration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "jwt")
@Component
@Data
public class token_properties {

    private String jwt_secret;
    private String jwt_expiration;

}
