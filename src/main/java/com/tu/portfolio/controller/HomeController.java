package com.tu.portfolio.controller;

import com.tu.portfolio.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        //Hacer la petición al servicio
        var info = infoService.getAll().get(0);
        var estudios = estudiosService.getAll();
        var experiencias = experienciaService.getAll();
        var lenguajes = lenguajeService.getAll();
        var proyectos = proyectoService.getAll();

        //añadir al modelo
        model.addAttribute("info", info);
        model.addAttribute("estudios", estudios);
        model.addAttribute("experiencias", experiencias);
        model.addAttribute("lenguajes", lenguajes);
        model.addAttribute("proyectos", proyectos);

        return "index";
    }
}
