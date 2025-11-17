package com.EcoTech.demo.repositorios;

import com.EcoTech.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface User_repo extends JpaRepository<User, Long> {

}
