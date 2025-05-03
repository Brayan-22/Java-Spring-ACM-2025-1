package com.acm.clase1;

import com.acm.clase1.config.S3AwsConfig;
import com.acm.clase1.services.IS3Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Clase1Application {

    public static void main(String[] args) {
        SpringApplication.run(Clase1Application.class, args);
    }

    @Bean
    CommandLineRunner runner(IS3Service s3Service){
        return args -> {
            s3Service.uploadFile("test.txt", "/path/to/test.txt");
            String fileContent = s3Service.downloadFile("test.txt");
            System.out.println(fileContent);
        };
    }


}
