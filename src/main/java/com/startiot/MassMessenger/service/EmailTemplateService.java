package com.startiot.MassMessenger.service;

public interface EmailTemplateService {
    String generateEmailContent(String name, String toAddress, String additionalData);
}
