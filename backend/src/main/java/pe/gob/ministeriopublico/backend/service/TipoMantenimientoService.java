package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.TipoMantenimiento;

public interface TipoMantenimientoService {
    List<TipoMantenimiento> listar();
    Optional<TipoMantenimiento> buscarPorId(Integer id);
    TipoMantenimiento guardar(TipoMantenimiento tipoMantenimiento);
    TipoMantenimiento actualizar(Integer id, TipoMantenimiento tipoMantenimiento);
    void eliminar(Integer id);
}
