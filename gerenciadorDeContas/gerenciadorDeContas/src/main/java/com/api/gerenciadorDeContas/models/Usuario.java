package com.api.gerenciadorDeContas.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nome", length = 50, nullable = false)
    private String nomeUsuario;

    @Column(length = 10, nullable = false)
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private String dataNascimento;

    @Column(length = 30, nullable = false, unique = true)
    private String email;

    @Column(length = 15, nullable = false)
    private String cpf;
}
