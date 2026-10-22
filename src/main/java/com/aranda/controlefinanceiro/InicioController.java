
package com.aranda.controlefinanceiro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    @GetMapping("/")
    public String inicio() {
        return "API de Controle Financeiro funcionando!";
    }
}
