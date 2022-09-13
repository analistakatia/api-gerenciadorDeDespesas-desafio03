package com.api.gerenciadorDeContas.services;

import com.api.gerenciadorDeContas.models.Endereco;
import com.api.gerenciadorDeContas.repositories.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.EntityDeclaration;
import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoRepository iEnderecoRepository;

    public List<Endereco> buscarTodosEnderecos(){
        return iEnderecoRepository.findAll();
    }

    public Optional<Endereco> buscarPorId(Long codigo){
        return iEnderecoRepository.findById(codigo);
    }

    public Endereco cadastrarEndereco(Endereco endereco){
       return iEnderecoRepository.save(endereco);
    }

    public Endereco alterarEndereco(Endereco endereco){
        return iEnderecoRepository.save(endereco);
    }

    public void deletarEndereco(Long codigo){
        iEnderecoRepository.deleteById(codigo);
    }
}
