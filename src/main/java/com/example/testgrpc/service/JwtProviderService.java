package com.example.testgrpc.service;

import com.example.testgrpc.dto.UserDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Component
public class JwtProviderService {

    @Value("${jwt.secret.access}")
    private String jwtAccessSecretString;

    @Value("${jwt.secret.refresh}")
    private String jwtRefreshSecretString;

    private Key jwtAccessSecret;
    private Key jwtRefreshSecret;

    @PostConstruct
    private void init() {
        jwtAccessSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtAccessSecretString));
        jwtRefreshSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtRefreshSecretString));
    }


    public String generateAccessToken(UserDto user) {
        LocalDateTime now = LocalDateTime.now();
        Date accessExpiration = Date.from(now.plusMinutes(5).atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .setSubject(user.getLogin())
                .setExpiration(accessExpiration)
                .signWith(SignatureAlgorithm.HS512, jwtAccessSecret)
                .claim("name", user.getName())
                .claim("roles", user.getRoles())
                .compact();
    }

    public String generateRefreshToken(UserDto user) {
        LocalDateTime now = LocalDateTime.now();
        Date refreshExpiration = Date.from(now.plusDays(30).atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .setSubject(user.getLogin())
                .setExpiration(refreshExpiration)
                .signWith(SignatureAlgorithm.HS512, jwtRefreshSecret)
                .claim("name", user.getName())
                .claim("roles", user.getRoles())
                .compact();
    }

    public boolean validateAccessToken(String accessToken) {
        return validateToken(accessToken, jwtAccessSecret);
    }

    public boolean validateRefreshToken(String refreshToken) {
        return validateToken(refreshToken, jwtRefreshSecret);
    }

    private boolean validateToken(String token, Key secret) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            System.out.println("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            System.out.println("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            System.out.println("Malformed jwt");
        } catch (SignatureException sEx) {
            System.out.println("Invalid signature");
        } catch (Exception e) {
            System.out.println("Invalid token");
        }
        return false;
    }

    public Claims getAccessClaims(String token) {
        return getClaims(token, jwtAccessSecret);
    }

    public Claims getRefreshClaims(String token) {
        return getClaims(token, jwtRefreshSecret);
    }

    private Claims getClaims(String token, Key secret) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
