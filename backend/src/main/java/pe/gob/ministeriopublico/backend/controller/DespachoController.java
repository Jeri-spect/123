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
import pe.gob.ministeriopublico.backend.entity.Despacho;
import pe.gob.ministeriopublico.backend.service.DespachoService;

@RestController
@RequestMapping("/api/despachos")
@RequiredArgsConstructor
public class DespachoController {

    private final DespachoService despachoService;

    @GetMapping
    public ResponseEntity<List<Despacho>> listar() {
        return ResponseEntity.ok(despachoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despacho> buscarPorId(@PathVariable Integer id) {
        return despachoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-sede")
    public ResponseEntity<List<Despacho>> buscarPorSede(@RequestParam Integer idSede) {
        return ResponseEntity.ok(despachoService.buscarPorSede(idSede));
    }

    @PostMapping
    public ResponseEntity<Despacho> guardar(@RequestBody Despacho despacho) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(despachoService.guardar(despacho));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despacho> actualizar(@PathVariable Integer id, @RequestBody Despacho despacho) {
        return ResponseEntity.ok(despachoService.actualizar(id, despacho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        despachoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
