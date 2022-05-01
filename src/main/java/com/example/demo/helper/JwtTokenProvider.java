package com.example.demo.helper;

import java.util.Date;
import java.util.HashMap;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.*;


public class JwtTokenProvider {
    private static final String JWT_SECRET = "qwertyuiop123456789_qwertyuiop123456789";
    
//    public static String GenerateToken(HashMap<String, String> claims) {
//        var now = java.time.ZonedDateTime.now();
//		var expiryDate = now.plusMinutes(51);
//
//        return Jwts.builder()
//        		   .setClaims(claims)
//                   .setSubject(claims.get("userid").toString())
//                   .setIssuedAt(Date.from(now.toInstant()))
//                   .setExpiration(Date.from(expiryDate.toInstant()))
//                   .signWith(SignatureAlgorithm.HS256, JWT_SECRET.getBytes())
//                   .compact();
//    }

    public static Claims getClaims(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET.getBytes())
                            .parseClaimsJws(token)
                            .getBody();

        return claims;
    }

    public static boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET.getBytes()).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
        } catch (ExpiredJwtException ex) {
        } catch (UnsupportedJwtException ex) {
        } catch (IllegalArgumentException ex) {
        }
        return false;
    }
}
