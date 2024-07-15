package com.forohub.ForoHub.topico;

import com.forohub.ForoHub.usuario.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DTOListarTopico(String titulo, String mensaje, Boolean status, String nombreCurso, Long idUsuario, LocalDateTime fechaDeCreacion) {
    public DTOListarTopico (Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getNombreCurso(), topico.getIdUsuario(), topico.getFechaDeCreacion());
    }

}
