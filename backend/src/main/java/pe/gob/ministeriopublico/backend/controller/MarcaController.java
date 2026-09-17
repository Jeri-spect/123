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
import pe.gob.ministeriopublico.backend.entity.Marca;
import pe.gob.ministeriopublico.backend.service.MarcaService;

@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<Marca>> listar() {
        return ResponseEntity.ok(marcaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable Integer id) {
        return marcaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Marca> guardar(@RequestBody Marca marca) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(marcaService.guardar(marca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> actualizar(@PathVariable Integer id, @RequestBody Marca marca) {
        return ResponseEntity.ok(marcaService.actualizar(id, marca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        marcaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
