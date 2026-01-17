package com.tu.portfolio.controller;

import com.tu.portfolio.model.*;
import com.tu.portfolio.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private InfoService infoService;
    private EstudiosService estudiosService;
    private ExperienciaService experienciaService;
    private LenguajeService lenguajeService;
    private ProyectoService proyectoService;

    public HomeController(InfoService infoService, EstudiosService estudiosService,ExperienciaService experienciaService, LenguajeService lenguajeService, ProyectoService proyectoService) {
        this.infoService = infoService;
        this.estudiosService = estudiosService;
        this.experienciaService = experienciaService;
        this.lenguajeService = lenguajeService;
        this.proyectoService = proyectoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        //añadir al modelo
        model.addAttribute("info", infoService.getAll().get(0));
        model.addAttribute("estudios", estudiosService.getAll());
        model.addAttribute("experiencias", experienciaService.getAll());
        model.addAttribute("lenguajes", lenguajeService.getAll());
        model.addAttribute("proyectos", proyectoService.getAll());

        return "index";
    }
}
