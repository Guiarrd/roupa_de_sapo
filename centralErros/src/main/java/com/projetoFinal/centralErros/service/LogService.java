package com.projetoFinal.centralErros.service;


import com.projetoFinal.centralErros.dto.LogDTO;
import com.projetoFinal.centralErros.enums.EnvironmentEnum;
import com.projetoFinal.centralErros.enums.LevelEnum;
import com.projetoFinal.centralErros.mapper.LogMapper;
import com.projetoFinal.centralErros.model.Log;
import com.projetoFinal.centralErros.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LogService {

    private final LogRepository logRepository;

    // Encontra log por id
    public LogDTO findLogById(Long id) {
        return LogMapper.toLogDTO(logRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Nenhum registro encontrado.",Log.class.getName())));
    }

    // Retorna todos os logs
    public List<LogDTO> findAllLogs() {
        return LogMapper.toListLogDTO(logRepository.findAll());
    }

    // Cria log/atualiza log
    public void saveLog(Log log) {
        logRepository.save(log);
    }

    public List<LogDTO> findAllOrderByParam(String param){
        if (param.equalsIgnoreCase("level")) {
            return LogMapper.toListLogDTO(logRepository.findAllByOrderByLevelEnum());
        } else if (param.equalsIgnoreCase("events")) {
            return LogMapper.toListLogDTO(logRepository.findAllByOrderByEvents());
        }
        return new ArrayList<>();
    }

    public List<LogDTO> findAllByEnvironment(String env){
        return LogMapper.toListLogDTO(logRepository.findAllByEnvironment(EnvironmentEnum.valueOf(env)));
    }

    public List<LogDTO> findAllByEnvironmentOrderByParam(String env, String param){
        if (param.equalsIgnoreCase("level")) {
            return LogMapper.toListLogDTO(logRepository.findAllByEnvironmentEnumOrderByLevelEnum(EnvironmentEnum.valueOf(env)));
        } else if (param.equalsIgnoreCase("events")) {
            return LogMapper.toListLogDTO(logRepository.findAllByEnvironmentEnumOrderByEvents(EnvironmentEnum.valueOf(env)));
        }
        return new ArrayList<>();
    }

    // Traz os Logs baseado no level pesquisado pelo usuário
    public List<LogDTO> findAllByLevel(String level){
        // Como não tem LIKE com enum, tive que mapear os valores dos enums e buscar uma delas que contenha o valor do parâmetro da busca
        Optional<LevelEnum> levelEnumOpt = Arrays.stream(LevelEnum.values()).filter((a) -> a.name().toLowerCase().contains(level.toLowerCase())).findFirst();
        LevelEnum levelEnum = null;

        if (levelEnumOpt.isPresent()) {
            levelEnum = levelEnumOpt.get();
        } else {
            throw new ObjectNotFoundException("Nenhum registro encontrado para "+level, Log.class.getName());
        }
        return LogMapper.toListLogDTO(logRepository.findAllByLevelEnumLike(levelEnum));
    }

    // Traz os Logs baseado na description pesquisada pelo usuário
    public List<LogDTO> findAllByDescription(String description){
        return LogMapper.toListLogDTO(logRepository.findAllByDescriptionContaining(description));
    }

    // Traz os Logs baseado na origin pesquisada pelo usuário
    public List<LogDTO> findAllByOrigin(String origin){
        return LogMapper.toListLogDTO(logRepository.findAllByOriginContaining(origin));
    }

    // Traz todos os Logs arquivados (archived == true)
    public List<LogDTO> findAllByArchived(){
        return LogMapper.toListLogDTO(logRepository.findAllByArchivedTrue());
    }

    // Deleta Log por id
    public void deleteUser(Long id) {
        Log log = logRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Nenhum registro encontrado.",Log.class.getName()));
        logRepository.delete(log);
    }
}
