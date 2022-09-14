package com.api.gerenciadorDeContas.factory;

import com.api.gerenciadorDeContas.enumerations.RecebimentoAlugueis;

import java.math.BigDecimal;

public interface ICalculoRecebimentoAluguel {
    public BigDecimal iCalculoRecebimentoAluguel(RecebimentoAlugueis recebimentoAlugueis);
}
