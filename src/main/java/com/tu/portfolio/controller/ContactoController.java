package com.tu.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String mostrarContacto() {
        return "contacto"; // Busca contacto.html en templates
    }
}