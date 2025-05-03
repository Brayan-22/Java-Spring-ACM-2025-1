package com.acm.clase1.presentation;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/hola")
public class HelloWorldController{


    @GetMapping
    public ResponseEntity<Object> getHelloWorld(){
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/bye")
    public ResponseEntity<Object> getByeWorld(){
        return ResponseEntity.ok("Bye World");
    }

}
