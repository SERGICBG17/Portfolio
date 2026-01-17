package com.tu.portfolio.controller;

import com.tu.portfolio.model.Info;
import com.tu.portfolio.service.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/info")
public class InfoController {

    private InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Info info) {
        // El ID suele ser 1 para tu perfil personal fijo
        info.setId(1L);
        infoService.add(info);
        return "redirect:/admin/info";
    }
}