package com.projetoFinal.centralErros.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LogService {

    private final LogRepository logRepository;

    //Encontra log por id
    public Log findLogById(Long id) {
        return logRepository.findById(id);
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
        Log log = findLogById(id);
        logRepository.delete(log);
    }
}
