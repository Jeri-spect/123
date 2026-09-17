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
import pe.gob.ministeriopublico.backend.entity.DistritoFiscal;
import pe.gob.ministeriopublico.backend.service.DistritoFiscalService;

@RestController
@RequestMapping("/api/distritos-fiscales")
@RequiredArgsConstructor
public class DistritoFiscalController {

    private final DistritoFiscalService distritoFiscalService;

    @GetMapping
    public ResponseEntity<List<DistritoFiscal>> listar() {
        return ResponseEntity.ok(distritoFiscalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistritoFiscal> buscarPorId(@PathVariable Integer id) {
        return distritoFiscalService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DistritoFiscal> guardar(@RequestBody DistritoFiscal distritoFiscal) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(distritoFiscalService.guardar(distritoFiscal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistritoFiscal> actualizar(@PathVariable Integer id, @RequestBody DistritoFiscal distritoFiscal) {
        return ResponseEntity.ok(distritoFiscalService.actualizar(id, distritoFiscal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        distritoFiscalService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
