package com.api.gerenciadorDeContas.services;

import com.api.gerenciadorDeContas.models.Estado;
import com.api.gerenciadorDeContas.repositories.IEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private IEstadoRepository iEstadoRepository;

    public List<Estado> buscarTodosEstados(){
        return iEstadoRepository.findAll();
    }

    public Optional<Estado> buscarPorId(Long codigo){
        return iEstadoRepository.findById(codigo);
    }

    public Estado cadastrarEstado(Estado estado){
        return iEstadoRepository.save(estado);
    }

    public Estado alterarEstado(Estado estado){
        return iEstadoRepository.save(estado);
    }

    public void deletarEstado(Long codigo){
        iEstadoRepository.deleteById(codigo);
    }

}
