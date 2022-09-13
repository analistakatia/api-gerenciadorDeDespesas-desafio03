package com.api.gerenciadorDeContas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecebimentoAlugueis {

    private BigDecimal valorRecebido;
    private RecebimentoAlugueis recebimentoAlugueis;

}
