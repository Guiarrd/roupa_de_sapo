package com.projetoFinal.centralErros.controller;


import com.projetoFinal.centralErros.mapper.LogMapper;
import com.projetoFinal.centralErros.model.Log;
import com.projetoFinal.centralErros.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/log")
public class LogController {

    private final LogService logService;

    @PostMapping // acessar /log via POST para cadastrar um log
    public ResponseEntity<HttpStatus> saveLog(@Valid @RequestBody Log log) {
        logService.saveLog(log);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping() // acessar /log via GET para listar todos os logs
    public ResponseEntity<List<Log>> findAllLogs() {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllLogs()), HttpStatus.OK);
    }

    @GetMapping("/{logId}") // acessar /log/id via GET para listar um log
    public ResponseEntity<Log> findLogById(@PathVariable Long logId) {
        return new ResponseEntity<>(LogMapper.toLog(logService.findLogById(logId)), HttpStatus.OK);
    }

    @PutMapping("/{id}") // acessar /log/id via PUT para atualizar um log
    public ResponseEntity<HttpStatus> updateLog(@Valid @RequestBody Log log, @PathVariable Long id) {
        log.setId(id);
        logService.saveLog(log);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{logId}") // acessar /log/delete/id via DELETE para deletar um log
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long logId) {
        logService.deleteUser(logId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/filter", method = RequestMethod.GET, params = "env") // acessar /log/filter?env=ENVIRONMENT via GET para listar os logs que pertencem ao ambiente especificado
    public ResponseEntity<List<Log>> findAllByEnvironment(@RequestParam(value = "env", required = false) String env) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByEnvironment(env)), HttpStatus.OK);
    }

    @RequestMapping(value="/filter", method = RequestMethod.GET, params = "level") // acessar /log/filter?level=LEVEL via GET para listar os logs ordenados pelo nível especificado
    public ResponseEntity<List<Log>> findAllOrderByLevel(@RequestParam(value = "level", required = false) String level) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllOrderByLevel(level)), HttpStatus.OK);
    }

    @RequestMapping(value="/filter", method = RequestMethod.GET, params = {"env","level"}) // acessar /log/filter?env=ENVIRONMENT&level=LEVEL via GET para listar os logs que pertencem ao ambiente especificado, ordenados pelo nível especificado
    public ResponseEntity<List<Log>> findAllByEnvironmentOrderLevel(@RequestParam(value = "env", required = false) String env, @RequestParam(value = "level", required = false) String level) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByEnvironmentOrderLevel(env, level)), HttpStatus.OK);
    }

    @GetMapping("/archived") // acessar /log/archived via GET para listar todos os logs arquivados
    public ResponseEntity<List<Log>> findAllByArchived() {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByArchived()), HttpStatus.OK);
    }

    @RequestMapping(value="/search", method = RequestMethod.GET, params = {"level"}) // acessar /log/search?level=LEVEL via GET para listar os logs baseados no level que o usuário pesquisar na barra de buscas
    public ResponseEntity<List<Log>> findAllByLevel(@RequestParam(value = "level", required = false) String level) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByLevel(level)), HttpStatus.OK);
    }

    @RequestMapping(value="/search", method = RequestMethod.GET, params = {"description"}) // acessar /log/search?description=DESCRIPTION via GET para listar os logs baseados na description que o usuário pesquisar na barra de buscas
    public ResponseEntity<List<Log>> findAllByDescription(@RequestParam(value = "description", required = false) String description) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByDescription(description)), HttpStatus.OK);
    }

    @RequestMapping(value="/search", method = RequestMethod.GET, params = {"origin"}) // acessar /log/search?origin=ORIGIN via GET para listar os logs baseados na origin que o usuário pesquisar na barra de buscas
    public ResponseEntity<List<Log>> findAllByOrigin(@RequestParam(value = "origin", required = false) String origin) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByOrigin(origin)), HttpStatus.OK);
    }
}
