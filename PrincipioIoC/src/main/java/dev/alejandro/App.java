package dev.alejandro;

import dev.alejandro.config.AppConfig;
import dev.alejandro.services.GmailCorreoSmtp;
import dev.alejandro.services.ICorreoSmtp;
import dev.alejandro.services.OutlookCorreoSmtp;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ICorreoSmtp correoOutlookSmtp = context.getBean(OutlookCorreoSmtp.class);
        correoOutlookSmtp.sendEmail("pepito@correo.com","alejandro@correo.com","Hola pepito");
        System.out.println(correoOutlookSmtp);

        ICorreoSmtp correoGmailSmtp = context.getBean(GmailCorreoSmtp.class);
        correoGmailSmtp.sendEmail("pepito@correo.com","alejandro@correo.com","Hola pepito");
        System.out.println("Id: " + correoGmailSmtp);
        ICorreoSmtp correoSmtp = context.getBean(GmailCorreoSmtp.class);
        System.out.println("Id: "+ correoSmtp);
    }
}
