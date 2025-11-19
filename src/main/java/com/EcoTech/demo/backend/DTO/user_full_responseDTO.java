package com.EcoTech.demo.backend.DTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;

@Data
public class user_full_responseDTO {
    private String CEP;
    private String nomeCliente;
    private String emailCliente;
    @Column(name = "saldo_greenwallet")
    private double saldoGreenWallet;
    private double ultimoCredito;
    private String proposta;
    private Date dataNascimento;

}
