package com.api.gerenciadorDeContas.factory;

import java.math.BigDecimal;

public interface ICalculoAlugueis {
    BigDecimal calcular(BigDecimal valorAluguel);
}
