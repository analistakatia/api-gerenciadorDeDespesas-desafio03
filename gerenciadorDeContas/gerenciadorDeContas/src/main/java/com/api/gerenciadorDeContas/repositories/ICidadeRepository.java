package com.api.gerenciadorDeContas.repositories;

import com.api.gerenciadorDeContas.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICidadeRepository extends JpaRepository<Cidade, Long> {
}
