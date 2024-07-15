package com.forohub.ForoHub.topico;

import jakarta.validation.constraints.NotNull;

public record DTOActualizarTopico(@NotNull Long idTopico, String titulo, String mensaje, String nombreCurso) {
}
