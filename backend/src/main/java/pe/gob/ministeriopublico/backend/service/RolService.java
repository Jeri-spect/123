package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.Rol;

public interface RolService {
    List<Rol> listar();
    Optional<Rol> buscarPorId(Integer id);
    Rol guardar(Rol rol);
    Rol actualizar(Integer id, Rol rol);
    void eliminar(Integer id);
}
