package com.api.gerenciadorDeContas.factory;

import java.math.BigDecimal;

public class CalculoAluguelAtrasado implements ICalculoAlugueis{

    @Override
    public BigDecimal calcular(BigDecimal valorAluguel){
        BigDecimal multa = valorAluguel.multiply(new BigDecimal(0.035));
        BigDecimal valorAReceber = valorAluguel.add(multa);
        return valorAReceber;
    }
}
