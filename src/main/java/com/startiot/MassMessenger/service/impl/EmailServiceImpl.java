package com.startiot.MassMessenger.service.impl;

import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;
import com.startiot.MassMessenger.domain.dto.SendEmailRequest;
import com.startiot.MassMessenger.service.EmailService;
import com.startiot.MassMessenger.service.EmailTemplateService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Value("${MAILERSEND_API_KEY}")
    private String apiKey;

    @Value("${FROM_EMAIL_ADDRESS}")
    private String fromEmailAddress;

    @Value("${FROM_EMAIL_NAME}")
    private String fromEmailName;

    private final EmailTemplateService emailTemplateService;

    public EmailServiceImpl(EmailTemplateService emailTemplateService) {
        this.emailTemplateService = emailTemplateService;
    }


    @Override
    public void sendEmail(SendEmailRequest request) {
        try {
            Email email = createEmail(request.getName(), request.getToAddress(), request.getSubject(), request.getBody());
            sendEmail(email);
        } catch (MailerSendException e) {
            log.error("Error sending email to {}: {}", request.getToAddress(), e.getMessage(), e);
            throw new RuntimeException("Failed to send email: " + e.getMessage(), e);
        }
    }

    @Override
    @Async("threadPoolTaskExecutor")
    public void sendMassEmail(List<String> recipients, String subject, String body) {
        recipients.forEach(recipient -> {
            try {
                Email email = createEmail(recipient, recipient, subject, body);
                sendEmail(email);
            } catch (MailerSendException e) {
                log.error("Error sending email to {}: {}", recipient, e.getMessage(), e);
            }
        });
    }

    private Email createEmail(String name, String toAddress, String subject, String body) {
        Email email = new Email();
        email.setFrom(fromEmailName, fromEmailAddress);
        email.addRecipient(name, toAddress);
        email.setSubject(subject);
        email.setHtml(emailTemplateService.generateEmailContent(name, toAddress, "Texto adicional"));
        return email;
    }

    private void sendEmail(Email email) throws MailerSendException {
        MailerSend ms = new MailerSend();
        ms.setToken(apiKey);
        ms.emails().send(email);
        log.info("Email sent successfully to {}.", email.toString());
    }
}