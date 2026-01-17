package com.tu.portfolio.controller;
import com.tu.portfolio.model.Lenguaje;
import com.tu.portfolio.service.LenguajeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/lenguajes")
public class LenguajesController {
    private final LenguajeService service;
    public LenguajesController(LenguajeService service) {
        this.service = service;
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Lenguaje obj) {
        service.add(obj);
        return "redirect:/Admin/lenguajes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/Admin/lenguajes";
    }
}