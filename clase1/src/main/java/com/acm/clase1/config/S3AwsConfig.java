package com.acm.clase1.config;

import com.acm.clase1.services.IS3Service;
import com.acm.clase1.services.S3ServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3AwsConfig {

    public IS3Service S3AwsConfig() {
        return new S3ServiceImpl();
    }
}
