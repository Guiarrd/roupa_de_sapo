package com.projetoFinal.centralErros.controller;


import com.projetoFinal.centralErros.model.Log;
import com.projetoFinal.centralErros.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/log")
public class LogController {

    private final LogService logService;

    @PostMapping // acessar /log via POST para cadastrar um log
    public ResponseEntity<?> saveLog(@Valid @RequestBody Log log) {
        logService.saveLog(log);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping() // acessar /log via GET para listar todos os logs
    public ResponseEntity<?> findAllLogs() {
        return new ResponseEntity <>(logService.findAllLogs(), HttpStatus.OK);
    }

    @GetMapping("/{logId}") // acessar /log/id via GET para listar um log
    public ResponseEntity<?> findLogById(@PathVariable Long logId) {
        return new ResponseEntity<>(logService.findLogById(logId), HttpStatus.OK);
    }

    @PutMapping("/{id}") // acessar /log/id via PUT para atualizar um log
    public ResponseEntity<?> updateLog(@Valid @RequestBody Log log, @PathVariable Long id) {
        log.setId(id);
        logService.saveLog(log);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{logId}") // acessar /log/delete/id via DELETE para deletar um log
    public ResponseEntity<?> deleteUser(@PathVariable Long logId) {
        logService.deleteUser(logId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/filter", method = RequestMethod.GET, params = "env") // acessar /log/filter?env=ENVIRONMENT via GET para listar os logs que pertencem ao ambiente especificado
    public ResponseEntity<?> findAllByEnvironment(@RequestParam(value = "env", required = false) String env) {
        return new ResponseEntity <>(logService.findAllByEnvironment(env), HttpStatus.OK);
    }

    @RequestMapping(value="/filter", method = RequestMethod.GET, params = "level") // acessar /log/filter?level=LEVEL via GET para listar os logs ordenados pelo nível especificado
    public ResponseEntity<?> findAllOrderByLevel(@RequestParam(value = "level", required = false) String level) {
        return new ResponseEntity <>(logService.findAllOrderByLevel(level), HttpStatus.OK);
    }

    @RequestMapping(value="/filter", method = RequestMethod.GET, params = {"env","level"}) // acessar /log/filter?env=ENVIRONMENT&level=LEVEL via GET para listar os logs que pertencem ao ambiente especificado, ordenados pelo nível especificado
    public ResponseEntity<?> findAllByEnvironmentOrderLevel(@RequestParam(value = "env", required = false) String env, @RequestParam(value = "level", required = false) String level) {
        return new ResponseEntity <>(logService.findAllByEnvironmentOrderLevel(env, level), HttpStatus.OK);
    }

    @GetMapping("/archived") // acessar /log/archived via GET para listar todos os logs arquivados
    public ResponseEntity<?> findAllByArchived() {
        return new ResponseEntity <>(logService.findAllByArchived(), HttpStatus.OK);
    }
}
