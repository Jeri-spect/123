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
import pe.gob.ministeriopublico.backend.entity.TipoPersonal;
import pe.gob.ministeriopublico.backend.service.TipoPersonalService;

@RestController
@RequestMapping("/api/tipos-personal")
@RequiredArgsConstructor
public class TipoPersonalController {

    private final TipoPersonalService tipoPersonalService;

    @GetMapping
    public ResponseEntity<List<TipoPersonal>> listar() {
        return ResponseEntity.ok(tipoPersonalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPersonal> buscarPorId(@PathVariable Integer id) {
        return tipoPersonalService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoPersonal> guardar(@RequestBody TipoPersonal tipoPersonal) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tipoPersonalService.guardar(tipoPersonal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonal> actualizar(@PathVariable Integer id, @RequestBody TipoPersonal tipoPersonal) {
        return ResponseEntity.ok(tipoPersonalService.actualizar(id, tipoPersonal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        tipoPersonalService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
