package com.api.gerenciadorDeContas.controllers;

import com.api.gerenciadorDeContas.enumerations.RecebimentoAlugueis;
import com.api.gerenciadorDeContas.enumerations.Status;
import com.api.gerenciadorDeContas.enumerations.TipoRecebido;
import com.api.gerenciadorDeContas.factory.AlugueisFactory;
import com.api.gerenciadorDeContas.models.ContasAReceber;
import com.api.gerenciadorDeContas.services.ContasAReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContasAReceberController {

    @Autowired
    private ContasAReceberService contasAReceberService;

    @GetMapping(path = "/contasReceber")
    public List<ContasAReceber> buscarTodasContasReceber(){
        return contasAReceberService.buscarTodasAsContasAReceber();
    }

    @GetMapping(path = "/contasReceber/{codigo}")
    public Optional<ContasAReceber> buscarIdContasReceber(@PathVariable Long codigo){
        return contasAReceberService.buscarPorIdContasAReceber(codigo);
    }

    @PostMapping(path = "/contasReceber")
    @ResponseStatus(HttpStatus.CREATED)
    public ContasAReceber cadastrarContasReceber(@RequestBody ContasAReceber contasAReceber, AlugueisFactory alugueisFactory){
        return contasAReceberService.cadastrarContasAReceber(contasAReceber, alugueisFactory);
    }

    @PutMapping(path = "/contasReceber/{codigo}")
    public ContasAReceber alterarContasReceber(@RequestBody ContasAReceber contasAReceber, @PathVariable Long codigo){
        return contasAReceberService.alterarContasAReceber(contasAReceber, codigo);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/contasReceber/{codigo}")
    public void deletarContasAReceber(@PathVariable Long codigo){
        contasAReceberService.deletarContasAReceber(codigo);
    }

//    @GetMapping(path = "/contasReceber/status/{status}")
//    public List<ContasAReceber> findByStatus(@PathVariable Status status){
//        return contasAReceberService.findByStatus(status);
//    }
//
//    @GetMapping(path = "/contasReceber/tipoRecebimento/{tipoRecebimento}")
//    public List<ContasAReceber> findByTipoRecebimento(@PathVariable TipoRecebido tipoRecebido){
//        return contasAReceberService.findByTipoRecebimento(tipoRecebido);
//    }
//
//    @GetMapping(path = "/contasReceber/recebimentoAlugueis/{recebimentoAlugueis}")
//    public List<ContasAReceber> findByRecebimentoAlugueis(@PathVariable RecebimentoAlugueis recebimentoAlugueis){
//        return contasAReceberService.findByRecebimentoAlugueis(recebimentoAlugueis);
//    }


}
