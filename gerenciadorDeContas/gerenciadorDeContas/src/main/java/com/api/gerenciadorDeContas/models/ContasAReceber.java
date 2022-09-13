package com.api.gerenciadorDeContas.models;

import com.api.gerenciadorDeContas.RecebimentoAlugueis;
import com.api.gerenciadorDeContas.Status;
import com.api.gerenciadorDeContas.TipoRecebido;
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
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "recebimento", length = 20)
    @Enumerated(value = EnumType.STRING)
    private RecebimentoAlugueis recebimento;

    @Column(length = 20, nullable = false)
    private BigDecimal valorRecebido;

    @Column(name = "tiporecebido", length = 10)
    @Enumerated(value = EnumType.STRING)
    private TipoRecebido tipoRecebido;

    @Column(name = "dataDeVencimento", length = 10)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataDeVencimento;

    @Column(name = "dataDeRecebimento", length = 10)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDateTime dataDeRecebimento;
}
