package com.startiot.MassMessenger.service.impl;

import com.startiot.MassMessenger.service.EmailTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class EmailTemplateServiceImpl implements EmailTemplateService {
    private final TemplateEngine templateEngine;

    /**
     * Genera el contenido del correo electrónico utilizando una plantilla Thymeleaf.
     *
     * @param name           Nombre del destinatario.
     * @param toAddress      Dirección de correo electrónico del destinatario.
     * @param additionalData Información adicional opcional.
     * @return Contenido HTML del correo electrónico.
     */
    @Override
    public String generateEmailContent(String name, String toAddress, String additionalData) {
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("toAddress", toAddress);
        context.setVariable("additionalData", additionalData);

        return templateEngine.process("email-template", context);
    }
}
