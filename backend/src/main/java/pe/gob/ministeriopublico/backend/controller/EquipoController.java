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
import pe.gob.ministeriopublico.backend.entity.Equipo;
import pe.gob.ministeriopublico.backend.service.EquipoService;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
public class EquipoController {

    private final EquipoService equipoService;

    @GetMapping
    public ResponseEntity<List<Equipo>> listar() {
        return ResponseEntity.ok(equipoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> buscarPorId(@PathVariable Integer id) {
        return equipoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo")
    public ResponseEntity<Equipo> buscarPorCodigoPatrimonial(@RequestParam String codigoPatrimonial) {
        return equipoService.buscarPorCodigoPatrimonial(codigoPatrimonial)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-modelo")
    public ResponseEntity<List<Equipo>> buscarPorModelo(@RequestParam Integer idModelo) {
        return ResponseEntity.ok(equipoService.buscarPorModelo(idModelo));
    }

    @GetMapping("/por-clasificacion")
    public ResponseEntity<List<Equipo>> buscarPorClasificacion(@RequestParam Integer idClasificacion) {
        return ResponseEntity.ok(equipoService.buscarPorClasificacion(idClasificacion));
    }

    @GetMapping("/por-estado")
    public ResponseEntity<List<Equipo>> buscarPorEstadoEquipo(@RequestParam Integer idEstadoEquipo) {
        return ResponseEntity.ok(equipoService.buscarPorEstadoEquipo(idEstadoEquipo));
    }

    @PostMapping
    public ResponseEntity<Equipo> guardar(@RequestBody Equipo equipo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(equipoService.guardar(equipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizar(@PathVariable Integer id, @RequestBody Equipo equipo) {
        return ResponseEntity.ok(equipoService.actualizar(id, equipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        equipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
