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

    @Query(value = "Select l from Log l where l.environmentEnum=?1 order by CASE WHEN (l.levelEnum = ?1) THEN 1 END DESC")
    List<Log> findAllByEnvironmentOrderLevel(EnvironmentEnum env, LevelEnum levelEnum);

    @Query(value = "Select l from Log l where l.environmentEnum=?1")
    List<Log> findAllByEnvironment(EnvironmentEnum env);

    //traz os Logs baseado na pesquisa que o usuário fazer
    List<Log> findAllByLevelEnumLike(LevelEnum levelEnum);

    List<Log> findAllByDescriptionContaining(String description);

    List<Log> findAllByOriginContaining(String origin);

    List<Log> findAllByArchivedTrue();

    @Query(value = "Select l from Log l order by CASE WHEN (l.levelEnum = ?1) THEN 1 END DESC")
    List<Log> findAllOrderByLevel(LevelEnum levelEnum);

    Optional<Log> findById(Long id);

}
