package com.tu.portfolio.controller;

import com.tu.portfolio.model.Proyecto;
import com.tu.portfolio.service.ProyectoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/proyectos")
public class ProyectosController {

    private ProyectoService proyectoService;

    public ProyectosController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proyecto proyecto) {
        proyectoService.add(proyecto);
        return "redirect:/admin/proyectos"; // Vuelve a la lista limpia
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        proyectoService.delete(id);
        return "redirect:/admin/proyectos";
    }

}