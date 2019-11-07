package com.projetoFinal.centralErros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level, Long> {

    Optional<Level> findById(Long id);

    Optional<Level> findByLog(Log log);

    List<Level> findAll();
}
