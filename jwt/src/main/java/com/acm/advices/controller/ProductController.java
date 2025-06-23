package com.acm.advices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController {

    static Map<String,String> products = Map.of(
        "1", "Product 1",
        "2", "Product 2",
        "3", "Product 3"
    );
    @GetMapping
    public ResponseEntity<Object> getAllProducts() {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
