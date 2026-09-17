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
import pe.gob.ministeriopublico.backend.entity.Modelo;
import pe.gob.ministeriopublico.backend.service.ModeloService;

@RestController
@RequestMapping("/api/modelos")
@RequiredArgsConstructor
public class ModeloController {

    private final ModeloService modeloService;

    @GetMapping
    public ResponseEntity<List<Modelo>> listar() {
        return ResponseEntity.ok(modeloService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> buscarPorId(@PathVariable Integer id) {
        return modeloService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-marca")
    public ResponseEntity<List<Modelo>> buscarPorMarca(@RequestParam Integer idMarca) {
        return ResponseEntity.ok(modeloService.buscarPorMarca(idMarca));
    }

    @PostMapping
    public ResponseEntity<Modelo> guardar(@RequestBody Modelo modelo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modeloService.guardar(modelo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> actualizar(@PathVariable Integer id, @RequestBody Modelo modelo) {
        return ResponseEntity.ok(modeloService.actualizar(id, modelo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        modeloService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
