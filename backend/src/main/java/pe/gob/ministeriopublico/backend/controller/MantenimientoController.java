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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.Mantenimiento;
import pe.gob.ministeriopublico.backend.service.MantenimientoService;

@RestController
@RequestMapping("/api/mantenimientos")
@RequiredArgsConstructor
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;

    @GetMapping
    public ResponseEntity<List<Mantenimiento>> listar() {
        return ResponseEntity.ok(mantenimientoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mantenimiento> buscarPorId(@PathVariable Integer id) {
        return mantenimientoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-equipo")
    public ResponseEntity<List<Mantenimiento>> buscarPorEquipo(@RequestParam Integer idEquipo) {
        return ResponseEntity.ok(mantenimientoService.buscarPorEquipo(idEquipo));
    }

    @GetMapping("/por-tipo")
    public ResponseEntity<List<Mantenimiento>> buscarPorTipoMantenimiento(@RequestParam Integer idTipoMantenimiento) {
        return ResponseEntity.ok(mantenimientoService.buscarPorTipoMantenimiento(idTipoMantenimiento));
    }

    @PostMapping
    public ResponseEntity<Mantenimiento> guardar(@RequestBody Mantenimiento mantenimiento) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mantenimientoService.guardar(mantenimiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mantenimiento> actualizar(@PathVariable Integer id, @RequestBody Mantenimiento mantenimiento) {
        return ResponseEntity.ok(mantenimientoService.actualizar(id, mantenimiento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        mantenimientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
