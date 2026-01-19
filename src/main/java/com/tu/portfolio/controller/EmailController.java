package com.tu.portfolio.controller;

import com.tu.portfolio.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String enviarCorreo(@RequestParam String userEmail, // Email de quien te escribe
                               @RequestParam String subject,   // Asunto
                               @RequestParam String body,      // Mensaje
                               RedirectAttributes redirectAttributes) {
        try {
            // Construimos un cuerpo de mensaje que te diga quién te contactó
            String mensajeCompleto = "Has recibido un nuevo mensaje de contacto:\n\n" +
                    "Remitente: " + userEmail + "\n" +
                    "Asunto: " + subject + "\n" +
                    "Mensaje:\n" + body;

            // Tú recibes el correo en tu cuenta personal
            emailService.enviarCorreo("sergiocasin5@gmail.com", "CONTACTO PORTFOLIO: " + subject, mensajeCompleto);

            redirectAttributes.addFlashAttribute("msg", "MENSAJE_ENVIADO_CON_ÉXITO");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "FALLO_EN_EL_SISTEMA_DE_ENVÍO");
        }
        return "redirect:/contacto";
    }

}