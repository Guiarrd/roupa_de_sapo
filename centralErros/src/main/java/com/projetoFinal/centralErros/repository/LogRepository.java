package com.projetoFinal.centralErros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LogRepository extends JpaRepository<Log, Long> {

    //traz todos os Logs baseado na opção que o usuário escolher nas caixas de seleção de environment e level
    List<Log> findAllByEnvironmentOrderLevel(Environment env, Level level);

    //traz os Logs baseado na pesquisa que o usuário fazer
    List<Log> findAllBySearch(String search);

    //traz todos os Logs arquivados (archieved == true)
    List<Log> findAllByArchieved();

    Optional<Log> findById(Long id);

}
