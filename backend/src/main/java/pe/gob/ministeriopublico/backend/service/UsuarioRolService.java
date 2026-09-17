package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.UsuarioRol;

public interface UsuarioRolService {
    List<UsuarioRol> listar();
    Optional<UsuarioRol> buscarPorId(Integer id);
    UsuarioRol guardar(UsuarioRol usuarioRol);
    UsuarioRol actualizar(Integer id, UsuarioRol usuarioRol);
    void eliminar(Integer id);
    List<UsuarioRol> buscarPorUsuario(Integer idUsuario);
    List<UsuarioRol> buscarPorRol(Integer idRol);
    Optional<UsuarioRol> buscarPorUsuarioYRol(Integer idUsuario, Integer idRol);
}
