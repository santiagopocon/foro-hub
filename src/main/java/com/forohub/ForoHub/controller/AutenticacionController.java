package com.forohub.ForoHub.controller;

import com.forohub.ForoHub.infra.security.DTOJwtToken;
import com.forohub.ForoHub.infra.security.TokenService;
import com.forohub.ForoHub.usuario.DTOAutenticacionUsuario;
import com.forohub.ForoHub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DTOAutenticacionUsuario dtoAutenticacionUsuario){
        Authentication authToken = new UsernamePasswordAuthenticationToken(dtoAutenticacionUsuario.email(), dtoAutenticacionUsuario.contrasenia());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generarTocken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DTOJwtToken(jwtToken));
    }
}
