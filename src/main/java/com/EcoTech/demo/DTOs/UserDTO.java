package com.EcoTech.demo.DTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDTO {
    private Long id;
    private String nomeCliente;
    private String emailCliente;
    @Column(name = "saldo_greenwallet")
    private double saldoGreenWallet;
    private double ultimoCredito;
    private String proposta;

}
