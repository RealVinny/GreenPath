package com.EcoTech.demo.backend.controller;

import com.EcoTech.demo.backend.DTO.user_full_responseDTO;
import com.EcoTech.demo.backend.DTO.user_summary_responseDTO;
import com.EcoTech.demo.backend.DTO.user_updateDTO;
import com.EcoTech.demo.backend.entity.User;
import com.EcoTech.demo.backend.repository.user_repository;
import com.EcoTech.demo.backend.service.User_service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class user_controller {

    private final User_service user_service;
    private final user_repository user_repository;

    public user_controller(User_service userService, user_repository user_repository) {
        this.user_service = userService;
        this.user_repository = user_repository;
    }

    @GetMapping("/full/{id}")
    public user_full_responseDTO findFullId(@PathVariable long id) {
        return user_service.getUser(id);
    }

    @GetMapping("/minimal/id={id}")
    public user_summary_responseDTO findMinimalId(@PathVariable long id) {
        return user_service.getUserSummary(id);
    }

    @PutMapping("update/{id}")
    public user_full_responseDTO updateUser(@PathVariable Long id, @RequestBody user_full_responseDTO repDTO) {

        User usr = user_repository.getById(id);
        user_service.updateUser(id, repDTO);

        return user_service.toResponse(usr);

    }

    @PutMapping("create")
    public user_full_responseDTO createUser(@RequestBody user_updateDTO repDTO) {
        User usr = new User();
        return user_service.createUser(repDTO);
    }


    @GetMapping("/error")
    public String error() {
        return "erro";
    }
}
