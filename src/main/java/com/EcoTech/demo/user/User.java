package com.EcoTech.demo.user;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Data
@Entity
@Table(name = "clientes_greenpath")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String apelidoCliente;
    private boolean sexo;
    private Date dataNascimento;
    private int idade;
    private String emailUsuario;
    private String CEP;
    private String proposta;
    private double saldoGreenWallet;
    private double ultimoCredito;
    private String senhaCliente;

}
