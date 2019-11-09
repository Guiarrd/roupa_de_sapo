package com.projetoFinal.centralErros.service;


import com.projetoFinal.centralErros.model.Log;
import com.projetoFinal.centralErros.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LogService {

    private final LogRepository logRepository;

    //Encontra log por id
    public Log findLogById(Long id) {
        return logRepository.findById(id).map(logRepository.findById(id)::get)
                .orElseThrow("No log found by id");
    }
    //Retorna todos os logs
    public List<Log> findAllLogs() {
        return logRepository.findAll();
    }
    //Cria log/atualiza log
    public void saveLog(Log log) {
        logRepository.save(log);
    }
    //Deleta log por id
    public void deleteUser(Long id) {
        Log log = logRepository.findById(id).map(logRepository.findById(id)::get)
                .orElseThrow("Log does not exist");
        logRepository.delete(log);
    }
}
