package com.projetoFinal.centralErros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
    Optional<Environment> findById(Long id);

    //busca o ambiente que está vinculado ao Log (útil na tela de edição de Log)
    Optional<Environment> findByLog(Log log);
}
