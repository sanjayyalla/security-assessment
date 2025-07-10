package com.jocata.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    private static final String SECRET_KEY="jocata123";

    public static String generateToken(String username,String role){
        Map<String,Object> claims = new HashMap<>();
        claims.put("role",role);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }

}
