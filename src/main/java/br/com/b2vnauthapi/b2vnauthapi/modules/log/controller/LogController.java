package br.com.b2vnauthapi.b2vnauthapi.modules.log.controller;

import br.com.b2vnauthapi.b2vnauthapi.modules.log.model.Log;
import br.com.b2vnauthapi.b2vnauthapi.modules.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/log")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public void saveLog(@RequestBody Log log) {
        logService.processarLogDeUsuario(log);
    }
}
