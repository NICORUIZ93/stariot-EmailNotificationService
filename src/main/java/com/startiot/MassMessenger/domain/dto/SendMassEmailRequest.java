package com.startiot.MassMessenger.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class SendMassEmailRequest {

    @NotEmpty(message = "La lista de destinatarios no puede estar vacía")
    private List<String> recipients;

    @NotEmpty(message = "El asunto no puede estar vacío")
    private String subject;

    @NotEmpty(message = "El cuerpo del correo no puede estar vacío")
    private String body;
}