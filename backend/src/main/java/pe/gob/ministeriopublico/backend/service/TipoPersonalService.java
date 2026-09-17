package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.TipoPersonal;

public interface TipoPersonalService {
    List<TipoPersonal> listar();
    Optional<TipoPersonal> buscarPorId(Integer id);
    TipoPersonal guardar(TipoPersonal tipoPersonal);
    TipoPersonal actualizar(Integer id, TipoPersonal tipoPersonal);
    void eliminar(Integer id);
}
