package com.forohub.ForoHub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.forohub.ForoHub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

    @Service
    public class TokenService {

        @Value("{api.security.secret}")
        private String apiSecret;

        public String generarTocken(Usuario usuario) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(apiSecret);
                return JWT.create()
                        .withIssuer("foro hub")
                        .withSubject(usuario.getEmail())
                        .withClaim("idTopico", usuario.getIdUsuario())
                        .withExpiresAt(generarFechaExpiracion())
                        .sign(algorithm);
            } catch (JWTCreationException exception) {
                throw new RuntimeException();
            }
        }

        private Instant generarFechaExpiracion() {
            return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-06:00"));
        }

        public String getSubject(String token) {
            if(token == null){
                throw new RuntimeException("Token viene nulo");
            }

            DecodedJWT verifier = null;
            try {
                Algorithm algorithm = Algorithm.HMAC256(apiSecret);
                verifier = JWT.require(algorithm)
                        .withIssuer("foro hub")
                        .build()
                        .verify(token);
                verifier.getSubject(); // Retorna el subject si la verificación es exitosa
            } catch (JWTVerificationException exception) {
                System.out.println(exception);

            }
            if (verifier.getSubject() == null){
                throw new RuntimeException("verifier invalido");
            }
            return verifier.getSubject(); // Retorna el subject si la verificación es exitosa
        }
    }