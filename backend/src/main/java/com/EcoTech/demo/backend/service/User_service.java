package com.EcoTech.demo.backend.service;

import com.EcoTech.demo.backend.DTO.user_full_responseDTO;
import com.EcoTech.demo.backend.DTO.user_summary_responseDTO;
import com.EcoTech.demo.backend.DTO.user_updateDTO;
import com.EcoTech.demo.backend.entity.User;
import com.EcoTech.demo.backend.repository.user_repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class User_service {

    private final user_repository user_repo;

    public User_service(user_repository usRep) {
        user_repo = usRep;
    }

    public void update_repo(user_repository user_repo) {
        user_repository user_repo1 = user_repo;

    }

    public user_full_responseDTO getUser(Long id) {
        User user = user_repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return toResponse(user);
    }

    public user_summary_responseDTO getUserSummary(Long id) {
        User user = user_repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return toSummary(user);
    }

    @Transactional
    public void updateUser(Long id, user_full_responseDTO upDTO) {

        User user = user_repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setNomeCliente(upDTO.getNomeCliente());
        user.setProposta(upDTO.getProposta());
        user.setSaldoGreenWallet(upDTO.getSaldoGreenWallet());
        user.setUltimoCredito(upDTO.getUltimoCredito());

        user_repo.save(user);

    }

    @Transactional
    public user_full_responseDTO createUser(user_updateDTO upDTO) {

        User user = new User();
        user.setNomeCliente(upDTO.getNomeCliente());
        user.setProposta(upDTO.getProposta());
        user.setSaldoGreenWallet(upDTO.getSaldoGreenWallet());
        user.setSenhaCliente(upDTO.getSenhaCliente());
        user.setUltimoCredito(upDTO.getUltimoCredito());
        user.setDataNascimento(upDTO.getDataNascimento());
        user.setEmailUsuario(upDTO.getEmailCliente());
        user.setCEP(upDTO.getCEP());
        user_repo.save(user);

        return toResponse(user_repo.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found")));

    }


    public user_summary_responseDTO toSummary(User usr) {
        user_summary_responseDTO upDTO = new user_summary_responseDTO();
        upDTO.setNomeCliente(usr.getNomeCliente());
        upDTO.setProposta(usr.getProposta());
        upDTO.setEmailUsuario(usr.getEmailUsuario());
        return upDTO;
    }

    public user_full_responseDTO toResponse(User user) {

        user_full_responseDTO userDTO = new user_full_responseDTO();

        userDTO.setNomeCliente(user.getNomeCliente());
        userDTO.setDataNascimento(user.getDataNascimento());
        userDTO.setEmailCliente(user.getEmailUsuario());
        userDTO.setCEP(user.getCEP());
        userDTO.setProposta(user.getProposta());
        userDTO.setUltimoCredito(user.getUltimoCredito());
        userDTO.setSaldoGreenWallet(user.getSaldoGreenWallet());

        return userDTO;
    }

}
