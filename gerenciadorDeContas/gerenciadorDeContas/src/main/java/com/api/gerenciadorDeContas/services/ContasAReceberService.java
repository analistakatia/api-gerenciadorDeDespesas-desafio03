package com.api.gerenciadorDeContas.services;

import com.api.gerenciadorDeContas.enumerations.RecebimentoAlugueis;
import com.api.gerenciadorDeContas.enumerations.Status;
import com.api.gerenciadorDeContas.enumerations.TipoRecebido;
import com.api.gerenciadorDeContas.exceptions.ContaNaoLocalizadaException;
import com.api.gerenciadorDeContas.factory.AlugueisFactory;
import com.api.gerenciadorDeContas.models.ContasAReceber;
import com.api.gerenciadorDeContas.repositories.IContasAReceber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContasAReceberService {

    @Autowired
    private IContasAReceber iContasAReceber;


    public List<ContasAReceber> buscarTodasAsContasAReceber(){
        return iContasAReceber.findAll();
    }

    public Optional<ContasAReceber> buscarPorIdContasAReceber(Long codigo){
        return iContasAReceber.findById(codigo);
    }

    public ContasAReceber cadastrarContasAReceber(ContasAReceber contasAReceber, AlugueisFactory alugueisFactory) {
        if (contasAReceber.getTipoRecebido().equals(TipoRecebido.ALUGUEIS)) {
            LocalDate dataAtual = LocalDate.now();
            if (contasAReceber.getDataDeVencimento().isBefore(dataAtual)) {
                contasAReceber.setRecebimentoAlugueis(RecebimentoAlugueis.EM_ATRASO);
                contasAReceber.setValorRecebido(alugueisFactory.getICalculoAluguel(RecebimentoAlugueis.EM_ATRASO).calcular(contasAReceber.getValorRecebido()));
            } else if (contasAReceber.getDataDeVencimento().isAfter(dataAtual)) {
                contasAReceber.setRecebimentoAlugueis(RecebimentoAlugueis.ADIANTADO);
                contasAReceber.setValorRecebido(alugueisFactory.getICalculoAluguel(RecebimentoAlugueis.ADIANTADO).calcular(contasAReceber.getValorRecebido()));
            } else {
                contasAReceber.setRecebimentoAlugueis(RecebimentoAlugueis.EM_DIA);
                contasAReceber.setValorRecebido(alugueisFactory.getICalculoAluguel(RecebimentoAlugueis.EM_DIA).calcular(contasAReceber.getValorRecebido()));

            }

        }
        return iContasAReceber.save(contasAReceber);
    }

    public ContasAReceber alterarContasAReceber(ContasAReceber contasAReceber, Long codigo){
       return iContasAReceber.save(contasAReceber);
    }

    public void deletarContasAReceber(Long codigo){
        iContasAReceber.deleteById(codigo);
    }

//    public List<ContasAReceber> findByStatus(Status status){
//        return iContasAReceber.findByStatus(status);
//    }
//
//    public List<ContasAReceber> findByTipoRecebimento(TipoRecebido tipoRecebido){
//        return iContasAReceber.findByTipoRecebimento(tipoRecebido);
//    }
//
//    public List<ContasAReceber> findByRecebimentoAlugueis(RecebimentoAlugueis recebimentoAlugueis){
//        return iContasAReceber.findByRecebimentoAlugueis(recebimentoAlugueis);
//    }


}
