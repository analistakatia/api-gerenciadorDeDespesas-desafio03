package com.api.gerenciadorDeContas.models;

import com.api.gerenciadorDeContas.Status;
import com.api.gerenciadorDeContas.Tipo;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "contas")
public class ContasAPagarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 20, nullable = false)
    private Double valor;

    @Column(name = "tipo", length = 10)
    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;

    @Column(name = "dataDeVencimento", length = 10)
    private LocalDate dataDeVencimento;

    @Column(name = "dataDePagamento", length = 10)
    private LocalDateTime dataDePagamento;

    @Column(name = "status", length = 12)
    @Enumerated(value = EnumType.STRING)
    private Status status;

}
