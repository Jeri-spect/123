package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.Usuario;

public interface UsuarioService {
    List<Usuario> listar();
    Optional<Usuario> buscarPorId(Integer id);
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Integer id, Usuario usuario);
    void eliminar(Integer id);
    Optional<Usuario> buscarPorUsuario(String usuario);
}
