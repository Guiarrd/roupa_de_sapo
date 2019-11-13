package com.projetoFinal.centralErros.service;


import com.projetoFinal.centralErros.enums.EnvironmentEnum;
import com.projetoFinal.centralErros.enums.LevelEnum;
import com.projetoFinal.centralErros.model.Log;
import com.projetoFinal.centralErros.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LogService {

    private final LogRepository logRepository;

    // Encontra log por id
    public Log findLogById(Long id) {
        return logRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("No log found by id",Log.class.getName()));
    }

    // Retorna todos os logs
    public List<Log> findAllLogs() {
        return logRepository.findAll();
    }

    // Cria log/atualiza log
    public void saveLog(Log log) {
        logRepository.save(log);
    }

    public List<Log> findAllOrderByLevel(String level){
        return logRepository.findAllOrderByLevel(LevelEnum.valueOf(level));
    }

    public List<Log> findAllByEnvironment(String env){
        return logRepository.findAllByEnvironment(EnvironmentEnum.valueOf(env));
    }

    public List<Log> findAllByEnvironmentOrderLevel(String env, String levelEnum){
        return logRepository.findAllByEnvironmentOrderLevel(EnvironmentEnum.valueOf(env),LevelEnum.valueOf(levelEnum));
    }

    // Traz os Logs baseado no level pesquisado pelo usuário
    public List<Log> findAllByLevel(String level){
        // Como não tem LIKE com enum, tive que mapear os valores dos enums e buscar uma delas que contenha o valor do parâmetro da busca
        Optional<LevelEnum> levelEnumOpt = Arrays.stream(LevelEnum.values()).filter((a) -> a.name().toLowerCase().contains(level.toLowerCase())).findFirst();
        LevelEnum levelEnum = null;

        if (levelEnumOpt.isPresent()) {
            levelEnum = levelEnumOpt.get();
        }

        return logRepository.findAllByLevelEnumLike(levelEnum);
    }

    // Traz os Logs baseado na description pesquisada pelo usuário
    public List<Log> findAllByDescription(String description){
        return logRepository.findAllByDescriptionContaining(description);
    }

    // Traz os Logs baseado na origin pesquisada pelo usuário
    public List<Log> findAllByOrigin(String origin){
        return logRepository.findAllByOriginContaining(origin);
    }

    // Traz todos os Logs arquivados (archived == true)
    public List<Log> findAllByArchived(){
        return logRepository.findAllByArchivedTrue();
    }

    // Deleta Log por id
    public void deleteUser(Long id) {
        Log log = logRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Log does not exist",Log.class.getName()));
        logRepository.delete(log);
    }
}
