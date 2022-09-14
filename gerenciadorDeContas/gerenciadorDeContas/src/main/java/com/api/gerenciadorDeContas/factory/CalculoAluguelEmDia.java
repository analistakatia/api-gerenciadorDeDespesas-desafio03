package com.api.gerenciadorDeContas.factory;

import java.math.BigDecimal;

public class CalculoAluguelEmDia implements ICalculoAlugueis{

    @Override
    public BigDecimal calcular(BigDecimal valorAluguel){
        return valorAluguel;
    }
}
