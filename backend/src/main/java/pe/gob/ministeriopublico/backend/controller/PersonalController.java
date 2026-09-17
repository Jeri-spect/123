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
import pe.gob.ministeriopublico.backend.entity.Personal;
import pe.gob.ministeriopublico.backend.service.PersonalService;

@RestController
@RequestMapping("/api/personales")
@RequiredArgsConstructor
public class PersonalController {

    private final PersonalService personalService;

    @GetMapping
    public ResponseEntity<List<Personal>> listar() {
        return ResponseEntity.ok(personalService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> buscarPorId(@PathVariable Integer id) {
        return personalService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-tipo")
    public ResponseEntity<List<Personal>> buscarPorTipoPersonal(@RequestParam Integer idTipoPersonal) {
        return ResponseEntity.ok(personalService.buscarPorTipoPersonal(idTipoPersonal));
    }

    @GetMapping("/dni")
    public ResponseEntity<Personal> buscarPorDni(@RequestParam String dni) {
        return personalService.buscarPorDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Personal> guardar(@RequestBody Personal personal) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(personalService.guardar(personal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personal> actualizar(@PathVariable Integer id, @RequestBody Personal personal) {
        return ResponseEntity.ok(personalService.actualizar(id, personal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        personalService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
