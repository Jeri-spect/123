package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.Marca;

public interface MarcaService {
    List<Marca> listar();
    Optional<Marca> buscarPorId(Integer id);
    Marca guardar(Marca marca);
    Marca actualizar(Integer id, Marca marca);
    void eliminar(Integer id);
}
