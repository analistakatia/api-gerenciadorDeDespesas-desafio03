package com.api.gerenciadorDeContas.repositories;

//import com.api.gerenciadorDeContas.RecebimentoAlugueis;
//import com.api.gerenciadorDeContas.Status;
//import com.api.gerenciadorDeContas.TipoRecebido;
import com.api.gerenciadorDeContas.models.ContasAReceber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContasAReceber extends JpaRepository<ContasAReceber, Long> {

//    public List<ContasAReceber> findByStatus(Status status);
//
//    public List<ContasAReceber> findByTipoRecebimento(TipoRecebido tipoRecebido);
//
//    public List<ContasAReceber> findByRecebimentoAlugueis(RecebimentoAlugueis recebimentoAlugueis);


}
