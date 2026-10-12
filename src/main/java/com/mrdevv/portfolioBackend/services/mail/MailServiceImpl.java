package com.mrdevv.portfolioBackend.services.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class MailServiceImpl implements  IMailService {

    @Value("${spring.mail.username}")
    String emailUser;

    @Value("${app.front.url}")
    String ULRFRONT;

    @Value("${app.logo.url}")
    String URLLOGO;

    private final JavaMailSender mailSender;

    @Override
    public void enviarCorreoConfirmacionCuenta(String token, String destinatario) {
        ClassPathResource plantilla = new ClassPathResource("templates/confirmar-cuenta.html");
        String enlaceConfirmacion= ULRFRONT + "/auth/confirmar-cuenta?token=" + token;
        String year = new Date().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate().getYear() + "";

        try (var input = plantilla.getInputStream()) {
            String html = new String(
                    input.readAllBytes(),
                    StandardCharsets.UTF_8
            );

            html = html.replace(
                    "{{enlaceConfirmacion}}",
                    HtmlUtils.htmlEscape(enlaceConfirmacion)
            );
            html = html.replace(
                    "{{LOGO_URL}}",
                    HtmlUtils.htmlEscape(URLLOGO)
            );
            html = html.replace(
                    "{{YEAR}}",
                    HtmlUtils.htmlEscape(year)
            );

            enviarCorreo(
                    destinatario,
                    "Confirma tu cuenta — DevVault",
                    html
            );
        } catch (IOException exception) {
            throw new MailPreparationException(
                    "No se pudo leer la plantilla de confirmación.",
                    exception
            );
        }

    }

    private void enviarCorreo(String destinatario, String asunto, String html) {
        try {
            MimeMessage mailMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage, "UTF-8");
            helper.setFrom(emailUser);
            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(html, true);

            mailSender.send(mailMessage);
        } catch (MessagingException exception) {
            throw new MailPreparationException("No se pudo preparar el correo HTML.", exception);
        }
    }
}
