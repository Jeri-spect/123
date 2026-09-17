package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.Mantenimiento;

public interface MantenimientoService {
    List<Mantenimiento> listar();
    Optional<Mantenimiento> buscarPorId(Integer id);
    Mantenimiento guardar(Mantenimiento mantenimiento);
    Mantenimiento actualizar(Integer id, Mantenimiento mantenimiento);
    void eliminar(Integer id);
    List<Mantenimiento> buscarPorEquipo(Integer idEquipo);
    List<Mantenimiento> buscarPorTipoMantenimiento(Integer idTipoMantenimiento);
}
