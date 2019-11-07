package com.projetoFinal.centralErros.service;


import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnvironmentService {

    private final EnvironmentRepository environmentRepository;

    //Encontra ambiente por id
    public Environment findEnvironmentById(Long id) {
        return environmentRepository.findById(id);
    }
    //Retorna todos os ambientes
    public List<Environment> findAllEnvironments() {
        return environmentRepository.findAll();
    }
    //Cria ambiente/atualiza ambiente
    public void saveLog(Environment environment) {
        environmentRepository.save(environment);
    }
    //Deleta ambiente por id
    public void deleteEnvironment(Long id) {
        Environment environment = findEnvironmentById(id);
        environmentRepository.delete(environment);
    }
}
