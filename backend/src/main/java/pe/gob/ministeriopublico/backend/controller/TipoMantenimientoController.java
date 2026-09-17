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
import pe.gob.ministeriopublico.backend.entity.TipoMantenimiento;
import pe.gob.ministeriopublico.backend.service.TipoMantenimientoService;

@RestController
@RequestMapping("/api/tipos-mantenimiento")
@RequiredArgsConstructor
public class TipoMantenimientoController {

    private final TipoMantenimientoService tipoMantenimientoService;

    @GetMapping
    public ResponseEntity<List<TipoMantenimiento>> listar() {
        return ResponseEntity.ok(tipoMantenimientoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoMantenimiento> buscarPorId(@PathVariable Integer id) {
        return tipoMantenimientoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoMantenimiento> guardar(@RequestBody TipoMantenimiento tipoMantenimiento) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tipoMantenimientoService.guardar(tipoMantenimiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoMantenimiento> actualizar(@PathVariable Integer id, @RequestBody TipoMantenimiento tipoMantenimiento) {
        return ResponseEntity.ok(tipoMantenimientoService.actualizar(id, tipoMantenimiento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        tipoMantenimientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
