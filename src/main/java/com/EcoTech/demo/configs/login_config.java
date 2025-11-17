package com.EcoTech.demo.configs;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class login_config {

    JSONPObject User;

    public login_config(String userName, String plainPassword) {
    }

    public JSONPObject login_config(String userName, String plainPassword) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgre://localhost:5432/green_path", "vinny", "52827Vinny!");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  WHERE nome_cliente= ?");

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

}
