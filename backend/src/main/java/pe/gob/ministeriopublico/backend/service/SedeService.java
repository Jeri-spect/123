package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.Sede;

public interface SedeService {
    List<Sede> listar();
    Optional<Sede> buscarPorId(Integer id);
    Sede guardar(Sede sede);
    Sede actualizar(Integer id, Sede sede);
    void eliminar(Integer id);
    List<Sede> buscarPorDistritoFiscal(Integer idDistritoFiscal);
}
