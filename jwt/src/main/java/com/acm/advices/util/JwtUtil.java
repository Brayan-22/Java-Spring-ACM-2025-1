package com.acm.advices.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtUtil {
    private final KeyPair keyPair;
    private PrivateKey privateKey;
    private PublicKey publicKey;


    @Value("${app.security.jwt.timeInMinutes}")
    private Long expirationTime;

    @PostConstruct
    public void initKeys(){
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + Duration.ofMinutes(expirationTime).toMillis()))
                .signWith(privateKey, Jwts.SIG.RS256)
                .compact();
    }



    public boolean validateToken(String token){
        try{
            Claims claims = getClaimsFromToken(token);
            log.info("Claims: {}", claims);
            return claims.getExpiration().after(new Date(System.currentTimeMillis())) && claims.getSubject() !=null;
        }catch (JwtException | IllegalArgumentException e){
            log.error("Token no valido");
            return false;
        }
    }

    public Claims getClaimsFromToken(String token){
        return Jwts.parser()
                .verifyWith(publicKey)
                .build().parseSignedClaims(token).getPayload();
    }


    public <T> T getClaim(String token, Function<Claims,T> claimsTFunction){
        Claims claims = getClaimsFromToken(token);
        return claimsTFunction.apply(claims);
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }
}
