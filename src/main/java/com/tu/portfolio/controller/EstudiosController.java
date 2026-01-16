package com.tu.portfolio.controller;
import com.tu.portfolio.model.Estudio;
import com.tu.portfolio.service.EstudiosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Admin/estudios")
public class EstudiosController {
    private final EstudiosService service;
    public EstudiosController(EstudiosService service) { this.service = service; }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Estudio obj) {
        service.add(obj);
        return "redirect:/Admin/estudios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/Admin/estudios";
    }
}