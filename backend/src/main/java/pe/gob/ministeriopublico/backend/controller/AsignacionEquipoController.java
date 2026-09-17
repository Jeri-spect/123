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
import pe.gob.ministeriopublico.backend.entity.AsignacionEquipo;
import pe.gob.ministeriopublico.backend.service.AsignacionEquipoService;

@RestController
@RequestMapping("/api/asignaciones")
@RequiredArgsConstructor
public class AsignacionEquipoController {

    private final AsignacionEquipoService asignacionEquipoService;

    @GetMapping
    public ResponseEntity<List<AsignacionEquipo>> listar() {
        return ResponseEntity.ok(asignacionEquipoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionEquipo> buscarPorId(@PathVariable Integer id) {
        return asignacionEquipoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-equipo")
    public ResponseEntity<List<AsignacionEquipo>> buscarPorEquipo(@RequestParam Integer idEquipo) {
        return ResponseEntity.ok(asignacionEquipoService.buscarPorEquipo(idEquipo));
    }

    @GetMapping("/por-despacho")
    public ResponseEntity<List<AsignacionEquipo>> buscarPorDespacho(@RequestParam Integer idDespacho) {
        return ResponseEntity.ok(asignacionEquipoService.buscarPorDespacho(idDespacho));
    }

    @GetMapping("/por-personal")
    public ResponseEntity<List<AsignacionEquipo>> buscarPorPersonal(@RequestParam Integer idPersonal) {
        return ResponseEntity.ok(asignacionEquipoService.buscarPorPersonal(idPersonal));
    }

    @PostMapping
    public ResponseEntity<AsignacionEquipo> guardar(@RequestBody AsignacionEquipo asignacionEquipo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(asignacionEquipoService.guardar(asignacionEquipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionEquipo> actualizar(@PathVariable Integer id,
            @RequestBody AsignacionEquipo asignacionEquipo) {
        return ResponseEntity.ok(asignacionEquipoService.actualizar(id, asignacionEquipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        asignacionEquipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
