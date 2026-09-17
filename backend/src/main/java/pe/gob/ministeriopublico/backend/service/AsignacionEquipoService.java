package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.AsignacionEquipo;

public interface AsignacionEquipoService {
    List<AsignacionEquipo> listar();
    Optional<AsignacionEquipo> buscarPorId(Integer id);
    AsignacionEquipo guardar(AsignacionEquipo asignacionEquipo);
    AsignacionEquipo actualizar(Integer id, AsignacionEquipo asignacionEquipo);
    void eliminar(Integer id);
    List<AsignacionEquipo> buscarPorEquipo(Integer idEquipo);
    List<AsignacionEquipo> buscarPorDespacho(Integer idDespacho);
    List<AsignacionEquipo> buscarPorPersonal(Integer idPersonal);
}
