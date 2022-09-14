package com.api.gerenciadorDeContas.models;

import com.api.gerenciadorDeContas.enumerations.RecebimentoAlugueis;
import com.api.gerenciadorDeContas.enumerations.Status;
import com.api.gerenciadorDeContas.enumerations.TipoRecebido;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contasreceber")
public class ContasAReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "status", length = 50)
    private RecebimentoAlugueis recebimentoAlugueis;

    @Column(name = "recebimento", length = 20)
    private String recebimento;

    @Column(length = 20, nullable = false)
    private BigDecimal valorRecebido;

    @Column(name = "tiporecebido", length = 10)
    private TipoRecebido tipoRecebido;

    @Column()
    private LocalDate dataDeVencimento;

    @Column()
    private LocalDateTime dataDeRecebimento;

    @ManyToOne
    @JoinColumn(name = "usario_id", referencedColumnName = "codigo")
    private Usuario usuario;
}
