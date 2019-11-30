package com.projetoFinal.centralErros.repository;

import com.projetoFinal.centralErros.model.Log;
import com.projetoFinal.centralErros.enums.EnvironmentEnum;
import com.projetoFinal.centralErros.enums.LevelEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    //traz todos os Logs baseado na opção que o usuário escolher nas caixas de seleção de environment e level

    List<Log> findAllByEnvironmentEnumOrderByLevelEnum(EnvironmentEnum env);

    List<Log> findAllByEnvironmentEnumOrderByEvents(EnvironmentEnum env);

    @Query(value = "Select l from Log l where l.environmentEnum=?1")
    List<Log> findAllByEnvironment(EnvironmentEnum env);

    //traz os Logs baseado na pesquisa que o usuário fazer
    List<Log> findAllByLevelEnumLike(LevelEnum levelEnum);

    List<Log> findAllByDescriptionContaining(String description);

    List<Log> findAllByOriginContaining(String origin);

    List<Log> findAllByArchivedTrue();

    List<Log> findAllByOrderByLevelEnum();

    List<Log> findAllByOrderByEvents();

    Optional<Log> findById(Long id);

}
