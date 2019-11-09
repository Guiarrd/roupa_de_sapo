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

    @PostMapping
    public ResponseEntity<?> saveLog(@Valid @RequestBody Log log) {
        logService.saveLog(log);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<?> findAllLogs() {
        return new ResponseEntity <>(logService.findAllLogs(), HttpStatus.OK);
    }

    @GetMapping("/list/{logId}")
    public ResponseEntity<?> findLogById(@PathVariable Long logId) {
        return new ResponseEntity<>(logService.findLogById(logId), HttpStatus.OK);
    }

    @PutMapping("/delete/{logId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long logId) {
        logService.deleteUser(logId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/filter")
    public ResponseEntity<?> findAllByEnvironmentOrderLevel(String env, String level) {
        return new ResponseEntity <>(logService.findAllByEnvironmentOrderLevel(env, level), HttpStatus.OK);
    }

    @RequestMapping(name="/filter",method = RequestMethod.GET, params = "env")
    public ResponseEntity<?> findAllByEnvironment(@RequestParam(value="env") String env) {
        return new ResponseEntity <>(logService.findAllByEnvironment(env), HttpStatus.OK);
    }
    @RequestMapping(name="/filter",method = RequestMethod.GET, params = "level")
    public ResponseEntity<?> findAllOrderByLevel(@RequestParam(value="level")String level) {
        return new ResponseEntity <>(logService.findAllOrderByLevel(level), HttpStatus.OK);
    }
}
