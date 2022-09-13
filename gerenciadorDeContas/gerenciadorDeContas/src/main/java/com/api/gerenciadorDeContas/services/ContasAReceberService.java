package com.api.gerenciadorDeContas.services;

import com.api.gerenciadorDeContas.RecebimentoAlugueis;
import com.api.gerenciadorDeContas.Status;
import com.api.gerenciadorDeContas.TipoRecebido;
import com.api.gerenciadorDeContas.exceptions.ContaNaoLocalizadaException;
import com.api.gerenciadorDeContas.models.ContasAReceber;
import com.api.gerenciadorDeContas.repositories.IContasAReceber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Status validaData(LocalDate data){
        LocalDate dataAtual = LocalDate.now();
        if (data.isAfter(dataAtual)){
            return Status.AGUARDANDO;
        }else if (data.isBefore(dataAtual)) {
            return Status.VENCIDA;
        }else {
            return Status.PAGO;
        }

    }

    public ContasAReceber cadastrarContasAReceber(ContasAReceber contasAReceber){
        contasAReceber.setTipoRecebido(contasAReceber.getTipoRecebido());
        return iContasAReceber.save(contasAReceber);
    }

    public ContasAReceber alterarContasAReceber(ContasAReceber contasAReceber, Long codigo){
        Optional<ContasAReceber> optionalContasAReceber = iContasAReceber.findById(codigo);
        if (optionalContasAReceber.isEmpty()){
            throw new ContaNaoLocalizadaException();
        }else {
            ContasAReceber contaAtualizada = optionalContasAReceber.get();
            RecebimentoAlugueis recebimentoAlugueisAtualizado = contasAReceber.getRecebimento();
            contaAtualizada.setRecebimento(recebimentoAlugueisAtualizado);
            contaAtualizada.setDataDeRecebimento(LocalDateTime.now());

            return iContasAReceber.save(contaAtualizada);
        }
    }

    public void deletarContasAReceber(Long codigo){
        iContasAReceber.deleteById(codigo);
    }
//
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
