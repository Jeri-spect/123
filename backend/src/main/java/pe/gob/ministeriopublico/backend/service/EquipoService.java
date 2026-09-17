package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.Equipo;

public interface EquipoService {
    List<Equipo> listar();
    Optional<Equipo> buscarPorId(Integer id);
    Equipo guardar(Equipo equipo);
    Equipo actualizar(Integer id, Equipo equipo);
    void eliminar(Integer id);
    List<Equipo> buscarPorModelo(Integer idModelo);
    List<Equipo> buscarPorClasificacion(Integer idClasificacion);
    List<Equipo> buscarPorEstadoEquipo(Integer idEstadoEquipo);
    Optional<Equipo> buscarPorCodigoPatrimonial(String codigoPatrimonial);
}
