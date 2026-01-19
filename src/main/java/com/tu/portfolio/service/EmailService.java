package com.tu.portfolio.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    //Indica que esta clase es un servicio de Spring Boot
    private final JavaMailSender mailSender;
    // Inyección de dependencias por constructor

    public EmailService(final JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();

        mensaje.setTo(destinatario); // Configura el destinatario del correo
        mensaje.setSubject(asunto); // Configura el asunto del correo
        mensaje.setText(cuerpo); // Configura el contenido del mensaje
        mensaje.setFrom("sergiocasin5@gmail.com"); // Define quién envía el correo
        mailSender.send(mensaje); // Envía el correo
    }
}
