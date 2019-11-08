package com.projetoFinal.centralErros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
    Optional<Environment> findById(Long id);

    //busca o ambiente que está vinculado ao Log (útil na tela de edição de Log)
    Optional<Environment> findByLog(Log log);
}
