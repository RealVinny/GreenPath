package com.EcoTech.demo.backend.DTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;

@Data
public class user_updateDTO {

    private String nomeCliente;
    private String emailCliente;
    private String apelidoCliente;
    @Column(name = "saldo_greenwallet")
    private double saldoGreenWallet;
    private double ultimoCredito;
    private String proposta;
    private Date dataNascimento;
    private String CEP;
    private String senhaCliente;


}
