package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.TipoPersonal;
import pe.gob.ministeriopublico.backend.repository.TipoPersonalRepository;
import pe.gob.ministeriopublico.backend.service.TipoPersonalService;

@Service
@RequiredArgsConstructor
public class TipoPersonalServiceImpl implements TipoPersonalService {

    private final TipoPersonalRepository tipoPersonalRepository;

    @Override
    public List<TipoPersonal> listar() {
        return tipoPersonalRepository.findAll();
    }

    @Override
    public Optional<TipoPersonal> buscarPorId(Integer id) {
        return tipoPersonalRepository.findById(id);
    }

    @Override
    public TipoPersonal guardar(TipoPersonal tipoPersonal) {
        return tipoPersonalRepository.save(tipoPersonal);
    }

    @Override
    public TipoPersonal actualizar(Integer id, TipoPersonal tipoPersonal) {
        TipoPersonal entidad = tipoPersonalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo personal no encontrado con ID: " + id));

        entidad.setNombreTipoPersonal(tipoPersonal.getNombreTipoPersonal());
        entidad.setDescripcion(tipoPersonal.getDescripcion());
        return tipoPersonalRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!tipoPersonalRepository.existsById(id)) {
            throw new RuntimeException("Tipo personal no encontrado con ID: " + id);
        }
        tipoPersonalRepository.deleteById(id);
    }
}
