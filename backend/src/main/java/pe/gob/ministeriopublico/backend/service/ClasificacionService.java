package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.Clasificacion;

public interface ClasificacionService {
    List<Clasificacion> listar();
    Optional<Clasificacion> buscarPorId(Integer id);
    Clasificacion guardar(Clasificacion clasificacion);
    Clasificacion actualizar(Integer id, Clasificacion clasificacion);
    void eliminar(Integer id);
}
