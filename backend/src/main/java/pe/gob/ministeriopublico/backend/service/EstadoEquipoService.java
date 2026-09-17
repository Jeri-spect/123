package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.EstadoEquipo;

public interface EstadoEquipoService {
    List<EstadoEquipo> listar();
    Optional<EstadoEquipo> buscarPorId(Integer id);
    EstadoEquipo guardar(EstadoEquipo estadoEquipo);
    EstadoEquipo actualizar(Integer id, EstadoEquipo estadoEquipo);
    void eliminar(Integer id);
}
