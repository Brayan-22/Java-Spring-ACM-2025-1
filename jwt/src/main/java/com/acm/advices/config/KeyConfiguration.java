package com.acm.advices.config;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Slf4j
@Configuration
public class KeyConfiguration {

    @Bean
    public KeyPair rsaPair() throws Exception {
        Resource privateResource = new ClassPathResource("/keys/private_key.pem");
        Resource publicResource = new ClassPathResource("/keys/public_key.pem");
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        if (privateResource.exists() && publicResource.exists()) {
            try {
                // Cargar la clave pública
                String publicKeyString = new String(publicResource.getInputStream().readAllBytes(), Charset.defaultCharset())
                        .replace("-----BEGIN PUBLIC KEY-----", "")
                        .replaceAll("\\R", "")
                        .replace("-----END PUBLIC KEY-----", "");
                byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
                X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
                PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

                // Cargar la clave privada
                String privateKeyString = new String(privateResource.getInputStream().readAllBytes(), Charset.defaultCharset())
                        .replace("-----BEGIN PRIVATE KEY-----", "")
                        .replaceAll("\\R", "")
                        .replace("-----END PRIVATE KEY-----", "");
                byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);
                PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
                PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

                return new KeyPair(publicKey, privateKey);
            } catch (IOException e) {
                throw new RuntimeException("Error reading RSA keys", e);
            }
        } else {
            throw new RuntimeException("Keys not found in classpath");
        }
    }
}
