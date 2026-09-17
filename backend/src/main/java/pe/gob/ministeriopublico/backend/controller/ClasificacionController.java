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
import pe.gob.ministeriopublico.backend.entity.Clasificacion;
import pe.gob.ministeriopublico.backend.service.ClasificacionService;

@RestController
@RequestMapping("/api/clasificaciones")
@RequiredArgsConstructor
public class ClasificacionController {

    private final ClasificacionService clasificacionService;

    @GetMapping
    public ResponseEntity<List<Clasificacion>> listar() {
        return ResponseEntity.ok(clasificacionService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clasificacion> buscarPorId(@PathVariable Integer id) {
        return clasificacionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clasificacion> guardar(@RequestBody Clasificacion clasificacion) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clasificacionService.guardar(clasificacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clasificacion> actualizar(@PathVariable Integer id, @RequestBody Clasificacion clasificacion) {
        return ResponseEntity.ok(clasificacionService.actualizar(id, clasificacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        clasificacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
