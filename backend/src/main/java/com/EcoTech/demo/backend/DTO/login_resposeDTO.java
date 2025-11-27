package com.EcoTech.demo.backend.DTO;


import com.EcoTech.demo.backend.entity.User;
import lombok.Data;

@Data
public class login_resposeDTO {

    private Long user_id;
    private String user_name;
    private String token;

    public login_resposeDTO loginResposeDTO(User user, String token) {
        this.user_id = user.getId();
        this.user_name = user.getNomeCliente();
        this.token = token;

        return this;
    }

}
