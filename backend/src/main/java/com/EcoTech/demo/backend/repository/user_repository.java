package com.EcoTech.demo.backend.repository;

import com.EcoTech.demo.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface user_repository extends JpaRepository<User, Long> {

    User findByNomeCliente(String nomeCliente);

    User findByEmailUsuario(String emailUsuario);

}
