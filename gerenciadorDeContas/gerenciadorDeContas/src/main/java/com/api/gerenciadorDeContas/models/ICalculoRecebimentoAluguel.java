package com.api.gerenciadorDeContas.models;

import com.api.gerenciadorDeContas.RecebimentoAlugueis;

import java.math.BigDecimal;

public interface ICalculoRecebimentoAluguel {
    public BigDecimal iCalculoRecebimentoAluguel(RecebimentoAlugueis recebimentoAlugueis);
}
