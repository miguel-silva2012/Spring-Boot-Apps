package com.example.autentication.Services.Security;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86400000; 

    public static String generateToken(String name) {
        return io.jsonwebtoken.Jwts.builder()
                .setSubject(name)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static String extractName(String token) {
        return io.jsonwebtoken.Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            io.jsonwebtoken.Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.JwtException e) {
            return false;
        }
    }
}