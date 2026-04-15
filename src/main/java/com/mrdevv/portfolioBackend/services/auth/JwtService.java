package com.mrdevv.portfolioBackend.services.auth;

import com.mrdevv.portfolioBackend.models.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${JWT_SECRET_KEY}")
    String secretKey;

    public Map<String, Object> generarExtraClaims(Usuario usuario){
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", usuario.getRol().getDescripcion());
        return extraClaims;
    }

    public String generarToken(UserDetails userDetails){
        Date fechaCreacion = new Date(System.currentTimeMillis());
        Date fechaExpiracion = new Date((4320 * 60 * 1000) + fechaCreacion.getTime());

        Map<String, Object> extraClaims = generarExtraClaims((Usuario) userDetails);

        String jwt = Jwts.builder()
                .header()
                .type("JWT")
                .and()

                .subject(userDetails.getUsername())
                .issuedAt(fechaCreacion)
                .expiration(fechaExpiracion)
                .claims(extraClaims)

                .signWith(generarKey())
                .compact();

        return jwt;
    }

    private SecretKey generarKey() {
        byte[] passwordDecoded = Decoders.BASE64.decode(this.secretKey);
        return Keys.hmacShaKeyFor(passwordDecoded);
    }

    public String extractEmail(String jwt){
        return extractClaims(jwt).getSubject();
    }

    public Claims extractClaims(String jwt){
        return Jwts.parser().verifyWith(generarKey()).build()
                .parseSignedClaims(jwt).getPayload();
    }

}
