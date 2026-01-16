package com.tu.portfolio.controller;

import com.tu.portfolio.model.*;
import com.tu.portfolio.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    private final InfoService infoService;
    private final EstudiosService estudiosService;
    private final ExperienciaService experienciaService;
    private final LenguajeService lenguajeService;
    private final ProyectoService proyectoService;

    public AdminController(InfoService infoService, EstudiosService estudiosService,
                           ExperienciaService experienciaService, LenguajeService lenguajeService,
                           ProyectoService proyectoService) {
        this.infoService = infoService;
        this.estudiosService = estudiosService;
        this.experienciaService = experienciaService;
        this.lenguajeService = lenguajeService;
        this.proyectoService = proyectoService;
    }

    @GetMapping("")
    public String dashboard() { return "admin/dashboard"; }

    // --- PROYECTOS ---
    @GetMapping("/proyectos")
    public String proyectos(Model model) {
        model.addAttribute("proyectos", proyectoService.getAll());
        if (!model.containsAttribute("proyecto")) model.addAttribute("proyecto", new Proyecto());
        return "admin/proyecto-form";
    }

    @GetMapping("/proyectos/editar/{id}")
    public String editarProyecto(@PathVariable Long id, Model model) {
        model.addAttribute("proyectos", proyectoService.getAll());
        model.addAttribute("proyecto", proyectoService.getById(id));
        return "admin/proyecto-form";
    }

    // --- EXPERIENCIA ---
    @GetMapping("/experiencia")
    public String experiencia(Model model) {
        model.addAttribute("experiencias", experienciaService.getAll());
        if (!model.containsAttribute("experiencia")) model.addAttribute("experiencia", new Experiencia());
        return "admin/experiencia-form";
    }

    @GetMapping("/experiencia/editar/{id}")
    public String editarExperiencia(@PathVariable Long id, Model model) {
        model.addAttribute("experiencias", experienciaService.getAll());
        model.addAttribute("experiencia", experienciaService.getById(id));
        return "admin/experiencia-form";
    }

    // --- ESTUDIOS ---
    @GetMapping("/estudios")
    public String estudios(Model model) {
        model.addAttribute("estudios", estudiosService.getAll());
        if (!model.containsAttribute("estudio")) model.addAttribute("estudio", new Estudio());
        return "admin/estudios-form";
    }

    @GetMapping("/estudios/editar/{id}")
    public String editarEstudio(@PathVariable Long id, Model model) {
        model.addAttribute("estudios", estudiosService.getAll());
        model.addAttribute("estudio", estudiosService.getById(id));
        return "admin/estudios-form";
    }

    // --- LENGUAJES ---
    @GetMapping("/lenguajes")
    public String lenguajes(Model model) {
        model.addAttribute("lenguajes", lenguajeService.getAll());
        if (!model.containsAttribute("lenguaje")) model.addAttribute("lenguaje", new Lenguaje());
        return "admin/lenguaje-form";
    }

    @GetMapping("/lenguajes/editar/{id}")
    public String editarLenguaje(@PathVariable Long id, Model model) {
        model.addAttribute("lenguajes", lenguajeService.getAll());
        model.addAttribute("lenguaje", lenguajeService.getById(id));
        return "admin/lenguaje-form";
    }

    // --- INFO PERSONAL ---
    @GetMapping("/info")
    public String info(Model model) {
        var infoList = infoService.getAll();
        model.addAttribute("info", infoList.isEmpty() ? new Info() : infoList.get(0));
        return "admin/info-form";
    }
}