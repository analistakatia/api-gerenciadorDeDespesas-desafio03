package com.api.gerenciadorDeContas.controllers;

import com.api.gerenciadorDeContas.Status;
import com.api.gerenciadorDeContas.Tipo;
import com.api.gerenciadorDeContas.models.ContasAPagarModel;
import com.api.gerenciadorDeContas.services.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ContasAPagarController {

    @Autowired
    private ContasAPagarService contasAPagarService;


    @GetMapping(path = "/contas")
    public ResponseEntity<List<ContasAPagarModel>> buscarTodasAsContas(){
        return ok(contasAPagarService.buscarTodasAsContasAPagar());
    }

    @GetMapping(path = "/contas/{codigo}")
    public ResponseEntity<Optional<ContasAPagarModel>> buscarIdDeContas(@PathVariable Long codigo){
        return ok(contasAPagarService.buscarIdContasAPagar(codigo));
    }

    @PostMapping(path = "/contas")
    public ResponseEntity<ContasAPagarModel> cadastrarContas(@RequestBody ContasAPagarModel contasAPagarModel){
        ContasAPagarModel contasAPagarCadastro = contasAPagarService.cadastrarContasAPagar(contasAPagarModel);
        return new ResponseEntity<>(contasAPagarCadastro, HttpStatus.CREATED);
    }

    @PutMapping(path = "/contas/{id}")
    public ResponseEntity<ContasAPagarModel> atualizarContas(@RequestBody ContasAPagarModel contasAPagarModel, @PathVariable Long id){
        return ResponseEntity.ok(contasAPagarService.alterarContasAPagar(contasAPagarModel, id));
    }

    @DeleteMapping(path = "/contas/{codigo}")
    public void deletarContas(@PathVariable Long codigo){
        contasAPagarService.deletarConta(codigo);
    }

    @GetMapping(path = "/contas/tipo/{tipo}")
    public List<ContasAPagarModel> findByTipo(@PathVariable Tipo tipo){
        return contasAPagarService.findByTipo(tipo);
    }

    @GetMapping(path = "/contas/status/{status}")
    public List<ContasAPagarModel> findByStatus(@PathVariable Status status){
        return contasAPagarService.findByStatus(status);
    }




}
