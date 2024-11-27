package com.himanshu.academicerp.util;

import  io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        return isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expirationTime = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expirationTime.before(new Date());
    }

    public boolean validateAuthHeader(String authHeader) throws BadRequestException {
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new BadRequestException("Invalid Authorization header");
        }
        String token = authHeader.substring(7);
        return validateToken(token);
    }
}
