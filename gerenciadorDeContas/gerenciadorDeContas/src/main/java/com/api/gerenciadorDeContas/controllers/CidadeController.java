package com.api.gerenciadorDeContas.controllers;

import com.api.gerenciadorDeContas.models.Cidade;
import com.api.gerenciadorDeContas.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(path = "/cidades")
    public List<Cidade> buscarTodasCidades(){
        return cidadeService.buscarTodasCidades();
    }

    @GetMapping(path = "/cidades/{codigo}")
    public Optional<Cidade> buscarPorId(@PathVariable Long codigo){

        return cidadeService.buscarPorId(codigo);
    }

    @PostMapping(path = "/cidades")
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade cadastrarCidade(@RequestBody Cidade cidade){
        return cidadeService.cadastrarCidade(cidade);
    }

    @PutMapping(path = "/cidades/{codigo}")
    public Cidade alterarCidade(@RequestBody Cidade cidade){
        return cidadeService.alterarCidade(cidade);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/cidades/{codigo}")
    public void deletarCidade(@PathVariable Long codigo){
        cidadeService.deletarCidade(codigo);
    }

}
