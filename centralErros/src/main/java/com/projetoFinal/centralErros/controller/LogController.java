package com.projetoFinal.centralErros.controller;


import com.projetoFinal.centralErros.dto.LogDTO;
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
@RequestMapping("/v1/log")
public class LogController {

    private final LogService logService;

    @PostMapping
    public ResponseEntity<HttpStatus> saveLog( @RequestBody LogDTO logDTO) {
        logService.saveLog(LogMapper.toLog(logDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Log>> findAllLogs() {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllLogs()), HttpStatus.OK);
    }

    @GetMapping("/{logId}")
    public ResponseEntity<Log> findLogById(@PathVariable Long logId) {
        return new ResponseEntity<>(LogMapper.toLog(logService.findLogById(logId)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateLog(@Valid @RequestBody LogDTO logDTO, @PathVariable Long id) {
        Log log=LogMapper.toLog(logDTO);
        log.setId(id);
        logService.saveLog(log);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{logId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long logId) {
        logService.deleteUser(logId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(value="/filterByEnvironment",params = "env")
    public ResponseEntity<List<Log>> findAllByEnvironment(@RequestParam(value = "env", required = false) String env) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByEnvironment(env)), HttpStatus.OK);
    }

    @GetMapping(value="/filterOrderBy", params = "order")
    public ResponseEntity<List<Log>> findAllOrderByLevel(@RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllOrderByParam(order)), HttpStatus.OK);
    }

    @GetMapping(value="/filterByEnvironmentOrderBy", params = {"env","order"})
    public ResponseEntity<List<Log>> findAllByEnvironmentOrderByParam(@RequestParam(value = "env", required = false) String env, @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByEnvironmentOrderByParam(env, order)), HttpStatus.OK);
    }

    @GetMapping("/archived")
    public ResponseEntity<List<Log>> findAllByArchived() {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByArchived()), HttpStatus.OK);
    }

    @GetMapping(value="/searchByLevel", params = {"level"})
    public ResponseEntity<List<Log>> findAllByLevel(@RequestParam(value = "level", required = false) String level) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByLevel(level)), HttpStatus.OK);
    }

    @GetMapping(value="/searchByDescription",  params = {"description"})
    public ResponseEntity<List<Log>> findAllByDescription(@RequestParam(value = "description", required = false) String description) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByDescription(description)), HttpStatus.OK);
    }

    @GetMapping(value="/searchByOrigin",  params = {"origin"})
    public ResponseEntity<List<Log>> findAllByOrigin(@RequestParam(value = "origin", required = false) String origin) {
        return new ResponseEntity <>(LogMapper.toListLog(logService.findAllByOrigin(origin)), HttpStatus.OK);
    }
}
