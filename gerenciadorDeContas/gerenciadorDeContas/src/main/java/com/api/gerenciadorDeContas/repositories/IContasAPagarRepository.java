package com.api.gerenciadorDeContas.repositories;

import com.api.gerenciadorDeContas.Status;
import com.api.gerenciadorDeContas.Tipo;
import com.api.gerenciadorDeContas.models.ContasAPagarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContasAPagarRepository extends JpaRepository<ContasAPagarModel, Long> {

    public List<ContasAPagarModel> findByStatus(Status status);

    public List<ContasAPagarModel> findByTipo(Tipo tipo);

}
