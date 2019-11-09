package com.projetoFinal.centralErros.service;

import com.projetoFinal.centralErros.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LevelService {

    private final LevelRepository levelRepository;

    //Encontra nível por id
    public Level findLevelById(Long id) {
        return levelRepository.findById(id).map(levelRepository.findById(id)::get)
                .orElseThrow("No level found by id");

    }
    //Retorna todos os níveis
    public List<Level> findAllLevels() {
        return levelRepository.findAll();
    }
    public Level findByLog(Log log) {
        return levelRepository.findByLog(log).map(levelRepository.findByLog(log)::get)
                .orElseThrow("No level found by Log");
    }
    //Cria nível/atualiza nível
    public void saveLevel(Level level) {
        levelRepository.save(level);
    }
    //Deleta nível por id
    public void deleteLevel(Long id) {
        levelRepository.delete(findLevelById(id));
    }
}
