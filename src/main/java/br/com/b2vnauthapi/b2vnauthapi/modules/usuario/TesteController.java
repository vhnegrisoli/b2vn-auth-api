package br.com.b2vnauthapi.b2vnauthapi.modules.usuario;

import br.com.b2vnauthapi.b2vnauthapi.config.ratelimit.RateLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    private static final Integer RATE_LIMIT = 3;

    @GetMapping
    @RateLimit(RATE_LIMIT)
    public String teste() {
        return "teste";
    }
}
