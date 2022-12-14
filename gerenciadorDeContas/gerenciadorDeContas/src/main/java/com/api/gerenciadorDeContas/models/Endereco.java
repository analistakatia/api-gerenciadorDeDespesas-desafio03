package com.api.gerenciadorDeContas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String logradouro;
    private String bairro;
    private String cep;
    private String pontoReferencia;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "codigo")
    private Cidade cidade;
}
