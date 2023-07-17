package com.cybersoft.baitapkhoa4.configuration.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtUltilities {
    private final SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("DEErkoxMX5mQygsbNGI5HsZbVIy47NZWf5ZX9BwzsOAH5wBCHmzzjuoJsYz/ArCKOjc="));
    private final Long jwtExpiration = 360000000L;
    public String generateToken(String data){
        return Jwts.builder().setSubject(data).setIssuedAt(new Date(System.currentTimeMillis())).
                setExpiration(Date.from(Instant.now().plus(jwtExpiration, ChronoUnit.MILLIS)))
                .signWith(key).compact();
    }
    public String getTokenFromRequestHeader(HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");
        if (StringUtils.hasText(jwt) && jwt.startsWith("Bearer")){
            return jwt.substring(7);
        }
        return null;
    }
    public Boolean validateToken(String token){
        try{
           Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
           return true;
        }catch (Exception e){
            return  false;
        }
    }

    public String getEmailFromToken(String token) {
          return  Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }
}
