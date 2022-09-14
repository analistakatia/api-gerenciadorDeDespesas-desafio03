package com.api.gerenciadorDeContas.factory;

import com.api.gerenciadorDeContas.enumerations.RecebimentoAlugueis;

public class AlugueisFactory {

    public ICalculoAlugueis getICalculoAluguel(RecebimentoAlugueis recebimentoAlugueis){
        if (recebimentoAlugueis.equals(recebimentoAlugueis.getAdiantado())){
            return new CalculoAluguelAdiantado();
        } else if (recebimentoAlugueis.equals(recebimentoAlugueis.getEmDia())) {
            return new CalculoAluguelEmDia();
        } else if (recebimentoAlugueis.equals(recebimentoAlugueis.getEmAtraso())) {
            return new CalculoAluguelAtrasado();
        }else {
            return null;
        }
    }
}
