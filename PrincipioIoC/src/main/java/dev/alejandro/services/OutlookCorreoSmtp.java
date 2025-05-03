package dev.alejandro.services;

import org.springframework.stereotype.Component;


public class OutlookCorreoSmtp implements ICorreoSmtp{
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Enviando desde outlook");
        System.out.println("Enviando e-mail a "+ to +" de, "+ subject + " con el cuerpo: "+ body);
    }

    @Override
    public void sendEmailWithCC(String to, String subject, String body, String... cc) {
        System.out.println("Enviando desde outlook");
        System.out.println("Enviando e-mail a "+ to +" de, "+ subject + " con el cuerpo: "+ body + " con copia a: "+ String.join(",", cc));
    }
}
