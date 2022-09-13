package com.api.gerenciadorDeContas.repositories;

import com.api.gerenciadorDeContas.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {
}
