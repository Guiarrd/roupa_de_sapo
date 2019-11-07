package com.projetoFinal.centralErros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findAllByEnvironmentOrderLevel(Environment env, Level level);

    List<Log> findAllBySearch(String search);

    List<Log> findAllByArchieved();

    Optional<Log> findById(Long id);

}
