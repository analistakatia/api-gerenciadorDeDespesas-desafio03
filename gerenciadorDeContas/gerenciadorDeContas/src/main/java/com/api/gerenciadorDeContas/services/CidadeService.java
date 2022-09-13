package com.api.gerenciadorDeContas.services;

import com.api.gerenciadorDeContas.models.Cidade;
import com.api.gerenciadorDeContas.repositories.ICidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private ICidadeRepository iCidadeRepository;

    public List<Cidade> buscarTodasCidades(){
        return iCidadeRepository.findAll();
    }

    public Optional<Cidade> buscarPorId(Long codigo){
        return iCidadeRepository.findById(codigo);
    }

    public Cidade cadastrarCidade(Cidade cidade){
        return iCidadeRepository.save(cidade);
    }

    public Cidade alterarCidade(Cidade cidade){
        return iCidadeRepository.save(cidade);
    }

    public void deletarCidade(Long codigo){
        iCidadeRepository.deleteById(codigo);
    }


}
