package com.api.gerenciadorDeContas.factory;

import java.math.BigDecimal;

public class CalculoAluguelAdiantado implements ICalculoAlugueis{

    @Override
    public BigDecimal calcular(BigDecimal valorAluguel){
        BigDecimal desconto = valorAluguel.multiply(new BigDecimal(0.05));
        BigDecimal valorAReceber = valorAluguel.subtract(desconto);
        return valorAReceber;
    }
}
