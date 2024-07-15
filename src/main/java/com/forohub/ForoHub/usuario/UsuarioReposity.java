package com.forohub.ForoHub.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioReposity extends JpaRepository<Usuario, Long> {
    UserDetails findByEmail(String username);
}
