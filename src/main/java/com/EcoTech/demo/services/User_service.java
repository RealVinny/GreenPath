package com.EcoTech.demo.services;

import com.EcoTech.demo.DTOs.UserDTO;
import com.EcoTech.demo.repositorios.User_repo;
import com.EcoTech.demo.user.User;
import org.springframework.stereotype.Service;

@Service
public class User_service {

    private final User_repo user_repo;

    public User_service(User_repo usRep){
        user_repo = usRep;
    }

    public UserDTO getUser(Long id) {
       User user = user_repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

       return toDTO(user);
    }

    private UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNomeCliente(user.getNomeCliente());
        userDTO.setEmailCliente(user.getEmailUsuario());
        userDTO.setSaldoGreenWallet(user.getSaldoGreenWallet());
        userDTO.setUltimoCredito(user.getUltimoCredito());
        userDTO.setProposta(user.getProposta());
        return userDTO;
    }
}
