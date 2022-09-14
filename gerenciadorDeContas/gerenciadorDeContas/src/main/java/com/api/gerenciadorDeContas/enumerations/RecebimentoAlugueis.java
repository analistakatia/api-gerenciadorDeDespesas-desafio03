package com.api.gerenciadorDeContas.enumerations;

public enum RecebimentoAlugueis {

    EM_ATRASO,
    EM_DIA,
    ADIANTADO;

    public RecebimentoAlugueis getEmAtraso() {
        return EM_ATRASO;
    }

    public RecebimentoAlugueis getEmDia() {
        return EM_DIA;
    }

    public RecebimentoAlugueis getAdiantado() {
        return ADIANTADO;
    }
}
