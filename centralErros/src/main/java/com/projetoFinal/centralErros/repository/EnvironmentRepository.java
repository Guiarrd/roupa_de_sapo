package com.projetoFinal.centralErros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
    Optional<Environment> findById(Long id);

    Optional<Environment> findByLog(Log log);

    List<Environment> findAll();
}
