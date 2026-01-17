package com.tu.portfolio.controller;
import com.tu.portfolio.model.Experiencia;
import com.tu.portfolio.service.ExperienciaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/experiencia")
public class ExperienciaController {
    private final ExperienciaService service;
    public ExperienciaController(ExperienciaService service) {
        this.service = service;
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Experiencia obj) {
        service.add(obj);
        return "redirect:/admin/experiencia";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/admin/experiencia";
    }
}