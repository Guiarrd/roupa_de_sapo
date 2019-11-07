package com.projetoFinal.centralErros.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LevelService {

    private final LevelRepository levelRepository;

    //Encontra nível por id
    public Level findLevelById(Long id) {
        return levelRepository.findById(id);
    }
    //Retorna todos os níveis
    public List<Level> findAllLevels() {
        return levelRepository.findAll();
    }
    //Cria nível/atualiza nível
    public void saveLevel(Level level) {
        levelRepository.save(level);
    }
    //Deleta nível por id
    public void deleteLevel(Long id) {
        Level level = findLevelById(id);
        levelRepository.delete(level);
    }
}
