package dev.alejandro.config;

import dev.alejandro.services.GmailCorreoSmtp;
import dev.alejandro.services.ICorreoSmtp;
import dev.alejandro.services.OutlookCorreoSmtp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ICorreoSmtp getCorreoGmail() {
        return new GmailCorreoSmtp();
    }

    @Bean
    public ICorreoSmtp getCorreoOutlook() {
        return new OutlookCorreoSmtp();
    }

}
