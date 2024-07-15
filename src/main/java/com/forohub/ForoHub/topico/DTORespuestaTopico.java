package com.forohub.ForoHub.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DTORespuestaTopico(

        Long idTopico,

        String titulo,

        String mensaje,

        String nombreCurso,
        LocalDateTime fechaDeCreacion) {
}
