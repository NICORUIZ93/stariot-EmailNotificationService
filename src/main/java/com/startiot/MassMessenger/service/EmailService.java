package com.startiot.MassMessenger.service;

import com.startiot.MassMessenger.domain.dto.SendEmailRequest;

import java.util.List;

public interface EmailService {

    void sendEmail(SendEmailRequest request);

    void sendMassEmail(List<String> recipients, String subject, String body);
}