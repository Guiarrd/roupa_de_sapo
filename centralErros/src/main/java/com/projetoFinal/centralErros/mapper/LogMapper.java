package com.projetoFinal.centralErros.mapper;

import com.projetoFinal.centralErros.dto.LogDTO;
import com.projetoFinal.centralErros.model.Log;

import java.util.List;
import java.util.stream.Collectors;

public class LogMapper {

    private LogMapper() {
        super(); //define que esta classe não pode ser instanciada
    }

    public static LogDTO toLogDTO(Log log) {
        LogDTO logDTO = new LogDTO();

        logDTO.setId(log.getId());
        logDTO.setTitle(log.getTitle());
        logDTO.setDescription(log.getDescription());
        logDTO.setArchieved(log.getArchived());
        logDTO.setOrigin(log.getOrigin());
        logDTO.setEnvironmentEnum(log.getEnvironmentEnum());
        logDTO.setLevelEnum(log.getLevelEnum());

        return logDTO;
    }

    public static Log toLog(LogDTO logDTO) {
        Log log = new Log();

        log.setId(logDTO.getId());
        log.setTitle(logDTO.getTitle());
        log.setDescription(logDTO.getDescription());
        log.setArchived(logDTO.getArchieved());
        log.setOrigin(logDTO.getOrigin());
        log.setEnvironmentEnum(logDTO.getEnvironmentEnum());
        log.setLevelEnum(logDTO.getLevelEnum());

        return log;
    }

    public static List<LogDTO> toListLogDTO(List<Log> logs) {
        return logs.stream().map(LogMapper::toLogDTO).collect(Collectors.toList());
    }

    public static List<Log> toListLog(List<LogDTO> logDTOS) {
        return logDTOS.stream().map(LogMapper::toLog).collect(Collectors.toList());
    }

}
