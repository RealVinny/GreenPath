package com.EcoTech.demo.backend.DTO;


import lombok.Data;

@Data
public class login_resposeDTO {

    private Long user_id;
    private String user_name;
    private String token;

}
