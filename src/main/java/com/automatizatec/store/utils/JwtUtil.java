package com.automatizatec.store.utils;

import com.automatizatec.store.dto.UserSingleResponseDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(UserSingleResponseDTO user) {
        Map<String, Object> claims = Map.of(
                "role", user.getUserType(),
                "companyId", user.getCompanyId(),
                "company", user.getCompany(),
                "personalId", user.getPersonalId(),
                "name", user.getName(),
                "fatherLastName", user.getFatherLastName(),
                "motherLastName", user.getMotherLastName(),
                "fullName", user.getFullName(),
                "email", Optional.ofNullable(user.getEmail()).orElse("")
        );

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUserId()) // User
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Extraer username
    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }

    // Extraer roles
    public List<String> extractRoles(String token) {
        Object roles = parseClaims(token).get("roles");
        return roles instanceof List ? ((List<?>) roles).stream()
                .map(Object::toString)
                .collect(Collectors.toList()) : List.of();
    }

    // Validar token
    public boolean validateToken(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private Claims parseClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}