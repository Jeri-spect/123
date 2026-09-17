package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.Personal;

public interface PersonalService {
    List<Personal> listar();
    Optional<Personal> buscarPorId(Integer id);
    Personal guardar(Personal personal);
    Personal actualizar(Integer id, Personal personal);
    void eliminar(Integer id);
    List<Personal> buscarPorTipoPersonal(Integer idTipoPersonal);
    Optional<Personal> buscarPorDni(String dni);
}
