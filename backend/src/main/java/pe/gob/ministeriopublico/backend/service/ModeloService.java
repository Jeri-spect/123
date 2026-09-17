package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.Modelo;

public interface ModeloService {
    List<Modelo> listar();
    Optional<Modelo> buscarPorId(Integer id);
    Modelo guardar(Modelo modelo);
    Modelo actualizar(Integer id, Modelo modelo);
    void eliminar(Integer id);
    List<Modelo> buscarPorMarca(Integer idMarca);
}
