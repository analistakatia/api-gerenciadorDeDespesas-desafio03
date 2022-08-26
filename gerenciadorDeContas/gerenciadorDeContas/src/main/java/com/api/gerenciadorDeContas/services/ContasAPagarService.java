package com.api.gerenciadorDeContas.services;

import com.api.gerenciadorDeContas.Tipo;
import com.api.gerenciadorDeContas.models.ContasAPagarModel;
import com.api.gerenciadorDeContas.Status;
import com.api.gerenciadorDeContas.repositories.IContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {

    @Autowired
    private IContasAPagarRepository iContasAPagarRepository;


    public List<ContasAPagarModel> buscarTodasAsContasAPagar(){
        return iContasAPagarRepository.findAll();
    }

    public Optional<ContasAPagarModel> buscarIdContasAPagar(Long codigo){
        return iContasAPagarRepository.findById(codigo);
    }

    public Status validaData(LocalDate data){
        LocalDate dataAtual = LocalDate.now();
        if (data.isAfter(dataAtual)){
            return Status.AGUARDANDO;
        }else {
            return Status.VENCIDA;
        }
    }
    public ContasAPagarModel cadastrarContasAPagar(ContasAPagarModel contasAPagarModel){
        contasAPagarModel.setStatus(validaData(contasAPagarModel.getDataDeVencimento()));
        return iContasAPagarRepository.save(contasAPagarModel);
    }

    public ContasAPagarModel alterarContasAPagar(ContasAPagarModel contasAPagarModel, Long codigo){
        Optional<ContasAPagarModel> optionalContasAPagarModel = iContasAPagarRepository.findById(codigo);
        if (optionalContasAPagarModel.isEmpty()){
            throw new RuntimeException("CONTA INEXISTENTE NO SISTEMA");
        }else {
            ContasAPagarModel contaAtualizada = optionalContasAPagarModel.get();
            Status statusAtualizado = contasAPagarModel.getStatus();
            contaAtualizada.setStatus(statusAtualizado);
            contaAtualizada.setDataDePagamento(LocalDateTime.now());

            return iContasAPagarRepository.save(contaAtualizada);
        }
    }

    public void deletarConta(Long codigo){
        iContasAPagarRepository.deleteById(codigo);
    }

    public List<ContasAPagarModel> findByStatus(Status status){
        return iContasAPagarRepository.findByStatus(status);
    }

    public List<ContasAPagarModel> findByTipo(Tipo tipo){
        return iContasAPagarRepository.findByTipo(tipo);
    }
}
