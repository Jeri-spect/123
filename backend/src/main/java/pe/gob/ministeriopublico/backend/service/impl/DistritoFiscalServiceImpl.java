package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.DistritoFiscal;
import pe.gob.ministeriopublico.backend.repository.DistritoFiscalRepository;
import pe.gob.ministeriopublico.backend.service.DistritoFiscalService;

@Service
@RequiredArgsConstructor
public class DistritoFiscalServiceImpl implements DistritoFiscalService {

    private final DistritoFiscalRepository distritoFiscalRepository;

    @Override
    public List<DistritoFiscal> listar() {
        return distritoFiscalRepository.findAll();
    }

    @Override
    public Optional<DistritoFiscal> buscarPorId(Integer id) {
        return distritoFiscalRepository.findById(id);
    }

    @Override
    public DistritoFiscal guardar(DistritoFiscal distritoFiscal) {
        return distritoFiscalRepository.save(distritoFiscal);
    }

    @Override
    public DistritoFiscal actualizar(Integer id, DistritoFiscal distritoFiscal) {
        DistritoFiscal entidad = distritoFiscalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Distrito fiscal no encontrado con ID: " + id));

        entidad.setNombreDistrito(distritoFiscal.getNombreDistrito());
        return distritoFiscalRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!distritoFiscalRepository.existsById(id)) {
            throw new RuntimeException("Distrito fiscal no encontrado con ID: " + id);
        }
        distritoFiscalRepository.deleteById(id);
    }
}
