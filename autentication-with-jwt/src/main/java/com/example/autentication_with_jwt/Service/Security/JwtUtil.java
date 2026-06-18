package com.example.autentication_with_jwt.Service.Security;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
    @SuppressWarnings("deprecation")
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); 
    private static final long EXPIRATION_TIME = 86400000;

    @SuppressWarnings("deprecation")
    public static String generateToken(String Email) {
        return Jwts.builder()
            .setSubject(Email)
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }
}
