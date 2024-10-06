package org.serogr.apirestful.tareas2.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacion")
public class AuthController {

    @PostMapping("/autenticacion")
    public String obtenerJwt(){
        return "Obteniendo JWT desde endpoint público";
    }
}
