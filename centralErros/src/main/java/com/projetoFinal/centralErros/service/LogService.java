package com.projetoFinal.centralErros.service;


import com.projetoFinal.centralErros.enums.EnvironmentEnum;
import com.projetoFinal.centralErros.enums.LevelEnum;
import com.projetoFinal.centralErros.model.Log;
import com.projetoFinal.centralErros.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LogService {

    private final LogRepository logRepository;

    //Encontra log por id
    public Log findLogById(Long id) {
        return logRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("No log found by id",Log.class.getName()));
    }
    //Retorna todos os logs
    public List<Log> findAllLogs() {
        return logRepository.findAll();
    }
    //Cria log/atualiza log
    public void saveLog(Log log) {
        logRepository.save(log);
    }
    public List<Log> findAllByEnvironmentOrderLevel(EnvironmentEnum env, LevelEnum levelEnum){

        return logRepository.findAllByEnvironmentOrderLevel(env,levelEnum);

    }

    //traz os Logs baseado na pesquisa que o usuário fazer
    public List<Log> findAllBySearch(String search){

        return logRepository.findAllBySearch(search);
    }

    //traz todos os Logs arquivados (archieved == true)
    public List<Log> findAllByArchieved(){

        return logRepository.findAllByArchieved();
    }
    //Deleta log por id
    public void deleteUser(Long id) {
        Log log=logRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Log does not exist",Log.class.getName()));
        logRepository.delete(log);
    }
}
