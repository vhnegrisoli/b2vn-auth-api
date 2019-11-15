package br.com.b2vnauthapi.b2vnauthapi.modules.usuario;

import br.com.b2vnauthapi.b2vnauthapi.config.ratelimit.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    @RateLimit(3)
    public String teste() {
        return "teste";
    }
}
