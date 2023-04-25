package com.example.demo.model.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;
public class JwtUtils {
    private JwtUtils(){}
    private static String key = "ferji34fesfreew";
    private static Long expire = 36000L*1000L;
    public static String getJwt(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,key)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();
        return jwt;
    }
    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
