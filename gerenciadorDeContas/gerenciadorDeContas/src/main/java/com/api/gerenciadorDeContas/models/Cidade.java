package com.api.gerenciadorDeContas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cidades")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nomeCidade;

    @JsonIgnore
    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
    private List<Endereco> endereco;

    @ManyToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "codigo")
    private Estado estado;
}
