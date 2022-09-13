package com.api.gerenciadorDeContas.controllers;

import com.api.gerenciadorDeContas.models.Endereco;
import com.api.gerenciadorDeContas.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(path = "/enderecos")
    public List<Endereco> buscarTodosEnderecos(){
        return enderecoService.buscarTodosEnderecos();
    }

    @GetMapping(path = "/enderecos/{codigo}")
    public Optional<Endereco> buscarPorId(@PathVariable Long codigo){

        return enderecoService.buscarPorId(codigo);
    }

    @PostMapping(path = "/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco cadastrarEndereco(@RequestBody Endereco endereco){
        return enderecoService.cadastrarEndereco(endereco);
    }

    @PutMapping(path = "/enderecos/{codigo}")
    public Endereco alterarEndereco(@RequestBody Endereco endereco){
        return enderecoService.alterarEndereco(endereco);
    }

    @DeleteMapping(path = "/enderecos/{codigo}")
    public void deletarEndereco(@PathVariable Long codigo){
        enderecoService.deletarEndereco(codigo);
    }


}
