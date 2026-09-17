package pe.gob.ministeriopublico.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.EstadoEquipo;
import pe.gob.ministeriopublico.backend.service.EstadoEquipoService;

@RestController
@RequestMapping("/api/estados-equipo")
@RequiredArgsConstructor
public class EstadoEquipoController {

    private final EstadoEquipoService estadoEquipoService;

    @GetMapping
    public ResponseEntity<List<EstadoEquipo>> listar() {
        return ResponseEntity.ok(estadoEquipoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoEquipo> buscarPorId(@PathVariable Integer id) {
        return estadoEquipoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadoEquipo> guardar(@RequestBody EstadoEquipo estadoEquipo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estadoEquipoService.guardar(estadoEquipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoEquipo> actualizar(@PathVariable Integer id, @RequestBody EstadoEquipo estadoEquipo) {
        return ResponseEntity.ok(estadoEquipoService.actualizar(id, estadoEquipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        estadoEquipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
