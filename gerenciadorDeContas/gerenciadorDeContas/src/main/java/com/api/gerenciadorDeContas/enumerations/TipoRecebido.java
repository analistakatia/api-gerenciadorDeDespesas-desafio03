package com.api.gerenciadorDeContas.enumerations;

public enum TipoRecebido {

    ALUGUEIS,
    EMPREGO_CLT,
    FREELANCER;

    public TipoRecebido getAlugueis() {
        return ALUGUEIS;
    }

    public TipoRecebido getEmpregoClt() {
        return EMPREGO_CLT;
    }

    public TipoRecebido getFreelancer() {
        return FREELANCER;
    }
}
