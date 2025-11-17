package com.EcoTech.demo.configs;

import com.EcoTech.demo.user.User;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class login_config {

    JSONPObject User;

    public login_config(String userName, String plainPassword) {
        User user = new User();
    }
    }

