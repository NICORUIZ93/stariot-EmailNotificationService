package com.startiot.MassMessenger.controllers;

import com.startiot.MassMessenger.domain.dto.SendEmailRequest;
import com.startiot.MassMessenger.domain.dto.SendMassEmailRequest;
import com.startiot.MassMessenger.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
@Tag(name = "Email API", description = "API para enviar correos electrónicos individuales y masivos")
public class EmailController {

    private final EmailService emailService;

    @Operation(summary = "Enviar un correo electrónico individual", description = "Envía un correo electrónico a una dirección específica.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Correo enviado exitosamente"), @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"), @ApiResponse(responseCode = "500", description = "Error interno del servidor")})
    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@Valid @RequestBody SendEmailRequest request) {
        emailService.sendEmail(request);
        return ResponseEntity.ok("Email sent successfully to " + request.getToAddress());
    }

    @Operation(summary = "Enviar correos electrónicos masivos", description = "Envía un correo electrónico a una lista de destinatarios.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Correos enviados exitosamente"), @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"), @ApiResponse(responseCode = "500", description = "Error interno del servidor")})
    @PostMapping("/send-mass")
    public ResponseEntity<String> sendMassEmail(@Valid @RequestBody SendMassEmailRequest request) {
        emailService.sendMassEmail(request.getRecipients(), request.getSubject(), request.getBody());
        return ResponseEntity.ok("Mass email sent successfully to " + request.getRecipients().size() + " recipients");
    }
}