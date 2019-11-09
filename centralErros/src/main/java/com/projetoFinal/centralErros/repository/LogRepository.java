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

    @Query(value = "Select l from Log l where l.environmentEnum=?1 order by ?2")
    List<Log> findAllByEnvironmentOrderLevel(EnvironmentEnum env, LevelEnum levelEnum);

    @Query(value = "Select l from Log l where l.environmentEnum=?1")
    List<Log> findAllByEnvironment(EnvironmentEnum env);

    //traz os Logs baseado na pesquisa que o usuário fazer
    @Query(value = "SELECT l FROM log l WHERE l.title LIKE '%?1%'",nativeQuery = true)
    List<Log> findAllBySearch(String search);

    @Query(value = "Select l from Log l where l.archived=true")
    List<Log> findAllByArchieved();


    @Query(value = "Select l from Log l order by ?2")
    List<Log> findAllOrderByLevel(LevelEnum levelEnum);


    Optional<Log> findById(Long id);

}
