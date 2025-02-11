package com.startiot.MassMessenger.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SendEmailRequest {
    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String toAddress;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String body;
}
