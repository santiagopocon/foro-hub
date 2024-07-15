package com.forohub.ForoHub.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

    @Table(name = "topicos")
    @Entity(name = "Topico")
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "idTopico")
    public class Topico {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idTopico;
        private String titulo;
        private String mensaje;
        private String nombreCurso;
        //@Embedded
        private Long idUsuario;
        private Boolean status;
        private LocalDateTime fechaDeCreacion;

        public Topico (DTORegistrarTopico dtoRegistrarTopico){
            this.titulo = dtoRegistrarTopico.titulo();
            this.mensaje =dtoRegistrarTopico.mensaje();
            this.nombreCurso = dtoRegistrarTopico.nombreCurso();
            this.idUsuario = dtoRegistrarTopico.idUsuario();
            this.status = true;
            this.fechaDeCreacion = LocalDateTime.now();
        }

        public void actualizarTopico(DTOActualizarTopico dtoActualizarTopico){
            if(dtoActualizarTopico.titulo() != null){
                this.titulo = dtoActualizarTopico.titulo();
            }
            if(dtoActualizarTopico.mensaje() != null){
                this.mensaje = dtoActualizarTopico.mensaje();
            }
            if(dtoActualizarTopico.nombreCurso() != null){
                this.nombreCurso = dtoActualizarTopico.nombreCurso();
            }
        }
    }
