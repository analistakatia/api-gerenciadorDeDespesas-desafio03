package com.api.gerenciadorDeContas.controllers;

import com.api.gerenciadorDeContas.models.Estado;
import com.api.gerenciadorDeContas.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping(path = "/estados")
    public List<Estado> buscarTodosEstados(){
        return estadoService.buscarTodosEstados();
    }

    @GetMapping(path = "/estados/{codigo}")
    public Optional<Estado> buscarPorId(@PathVariable Long codigo){

        return estadoService.buscarPorId(codigo);
    }

    @PostMapping(path = "/estados")
    @ResponseStatus(HttpStatus.CREATED)
    public Estado cadastrarEstado(@RequestBody Estado estado){
        return estadoService.cadastrarEstado(estado);
    }

    @PutMapping(path = "/estados/{codigo}")
    public Estado alterarEstado(@RequestBody Estado estado){
        return estadoService.alterarEstado(estado);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/estados/{codigo}")
    public void deletarEstados(@PathVariable Long codigo){
        estadoService.deletarEstado(codigo);
    }

}
