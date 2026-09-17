package pe.gob.ministeriopublico.backend.service;

import java.util.List;
import java.util.Optional;

import pe.gob.ministeriopublico.backend.entity.DistritoFiscal;

public interface DistritoFiscalService {
    List<DistritoFiscal> listar();
    Optional<DistritoFiscal> buscarPorId(Integer id);
    DistritoFiscal guardar(DistritoFiscal distritoFiscal);
    DistritoFiscal actualizar(Integer id, DistritoFiscal distritoFiscal);
    void eliminar(Integer id);
}
