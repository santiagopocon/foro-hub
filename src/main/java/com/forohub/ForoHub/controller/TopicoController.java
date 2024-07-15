package com.forohub.ForoHub.controller;

import com.forohub.ForoHub.topico.*;
import jakarta.validation.Valid;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoReposity topicoReposity;

    @PostMapping
    public ResponseEntity<DTORespuestaTopico> registrarTopico (@RequestBody @Valid DTORegistrarTopico dtoRegistrarTopico, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoReposity.save(new Topico(dtoRegistrarTopico));
        DTORespuestaTopico dtoRespuestaTopico = new DTORespuestaTopico(topico.getIdTopico(), topico.getTitulo(), topico.getMensaje(), topico.getNombreCurso(), topico.getFechaDeCreacion());
        URI url = uriComponentsBuilder.path("/topicos/{idTopico}").buildAndExpand(topico.getIdTopico()).toUri();
        return ResponseEntity.created(url).body(dtoRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity <Page<DTOListarTopico>> listarTopicos (Pageable paginacion){
        return ResponseEntity.ok(topicoReposity.findAll(paginacion).map(DTOListarTopico::new)) ;
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DTORespuestaTopico> actualizarTopico(@RequestBody @Valid DTOActualizarTopico dtoActualizarTopico){
        Topico topico = topicoReposity.getReferenceById(dtoActualizarTopico.idTopico());
        topico.actualizarTopico(dtoActualizarTopico);
        return ResponseEntity.ok(new DTORespuestaTopico(topico.getIdTopico(), topico.getTitulo(), topico.getMensaje(), topico.getNombreCurso(), topico.getFechaDeCreacion()));
    }

    @DeleteMapping("/{idTopico}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long idTopico){
        Topico topico = topicoReposity.getReferenceById(idTopico);
        topicoReposity.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idTopico}")
    public ResponseEntity<DTORespuestaTopico> detalleTopico(@PathVariable Long idTopico){
        Topico topico = topicoReposity.getReferenceById(idTopico);
        var datosTopico = new DTORespuestaTopico(topico.getIdTopico(), topico.getTitulo(), topico.getMensaje(), topico.getNombreCurso(), topico.getFechaDeCreacion());

        return ResponseEntity.ok(datosTopico);
    }
}
