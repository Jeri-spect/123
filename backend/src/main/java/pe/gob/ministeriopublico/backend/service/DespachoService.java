package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.Despacho;

public interface DespachoService {
    List<Despacho> listar();
    Optional<Despacho> buscarPorId(Integer id);
    Despacho guardar(Despacho despacho);
    Despacho actualizar(Integer id, Despacho despacho);
    void eliminar(Integer id);
    List<Despacho> buscarPorSede(Integer idSede);
}
