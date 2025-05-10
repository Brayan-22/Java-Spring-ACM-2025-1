package com.acm.mvc;

import com.acm.mvc.models.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner (){
//        return args -> {
//            Usuario usuario = Usuario
//                    .builder()
//                    .username("alejandro")
//                    .password("123456")
//                    .build();
//            System.out.println(usuario);
//        };
//    }
}
