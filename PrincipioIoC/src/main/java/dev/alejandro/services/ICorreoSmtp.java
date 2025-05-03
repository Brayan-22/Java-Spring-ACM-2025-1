package dev.alejandro.services;

import org.springframework.stereotype.Component;


public interface ICorreoSmtp {
    void sendEmail(String to, String subject, String body);
    void sendEmailWithCC(String to,String subject,String body, String... cc);
}
