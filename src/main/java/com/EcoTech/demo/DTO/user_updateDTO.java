package com.EcoTech.demo.DTO;

import com.EcoTech.demo.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.sql.Date;

@Data
public class user_updateDTO {

    private String nomeCliente;
    private String emailCliente;
    @Column(name = "saldo_greenwallet")
    private double saldoGreenWallet;
    private double ultimoCredito;
    private String proposta;
    private Date dataNascimento;
    private String CEP;
    private String senhaCliente;



}
