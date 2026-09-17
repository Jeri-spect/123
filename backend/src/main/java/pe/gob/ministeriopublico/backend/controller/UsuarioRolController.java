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
import pe.gob.ministeriopublico.backend.entity.UsuarioRol;
import pe.gob.ministeriopublico.backend.service.UsuarioRolService;

@RestController
@RequestMapping("/api/usuarios-roles")
@RequiredArgsConstructor
public class UsuarioRolController {

    private final UsuarioRolService usuarioRolService;

    @GetMapping
    public ResponseEntity<List<UsuarioRol>> listar() {
        return ResponseEntity.ok(usuarioRolService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRol> buscarPorId(@PathVariable Integer id) {
        return usuarioRolService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-usuario")
    public ResponseEntity<List<UsuarioRol>> buscarPorUsuario(@RequestParam Integer idUsuario) {
        return ResponseEntity.ok(usuarioRolService.buscarPorUsuario(idUsuario));
    }

    @GetMapping("/por-rol")
    public ResponseEntity<List<UsuarioRol>> buscarPorRol(@RequestParam Integer idRol) {
        return ResponseEntity.ok(usuarioRolService.buscarPorRol(idRol));
    }

    @GetMapping("/detalle")
    public ResponseEntity<UsuarioRol> buscarPorUsuarioYRol(
            @RequestParam Integer idUsuario,
            @RequestParam Integer idRol) {
        return usuarioRolService.buscarPorUsuarioYRol(idUsuario, idRol)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioRol> guardar(@RequestBody UsuarioRol usuarioRol) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioRolService.guardar(usuarioRol));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioRol> actualizar(@PathVariable Integer id, @RequestBody UsuarioRol usuarioRol) {
        return ResponseEntity.ok(usuarioRolService.actualizar(id, usuarioRol));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        usuarioRolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
