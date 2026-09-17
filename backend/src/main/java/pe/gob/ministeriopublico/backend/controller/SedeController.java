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
import pe.gob.ministeriopublico.backend.entity.Sede;
import pe.gob.ministeriopublico.backend.service.SedeService;

@RestController
@RequestMapping("/api/sedes")
@RequiredArgsConstructor
public class SedeController {

    private final SedeService sedeService;

    @GetMapping
    public ResponseEntity<List<Sede>> listar() {
        return ResponseEntity.ok(sedeService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sede> buscarPorId(@PathVariable Integer id) {
        return sedeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-distrito")
    public ResponseEntity<List<Sede>> buscarPorDistritoFiscal(@RequestParam Integer idDistritoFiscal) {
        return ResponseEntity.ok(sedeService.buscarPorDistritoFiscal(idDistritoFiscal));
    }

    @PostMapping
    public ResponseEntity<Sede> guardar(@RequestBody Sede sede) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(sedeService.guardar(sede));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sede> actualizar(@PathVariable Integer id, @RequestBody Sede sede) {
        return ResponseEntity.ok(sedeService.actualizar(id, sede));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        sedeService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
