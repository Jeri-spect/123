package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.TipoMantenimiento;
import pe.gob.ministeriopublico.backend.repository.TipoMantenimientoRepository;
import pe.gob.ministeriopublico.backend.service.TipoMantenimientoService;

@Service
@RequiredArgsConstructor
public class TipoMantenimientoServiceImpl implements TipoMantenimientoService {

    private final TipoMantenimientoRepository tipoMantenimientoRepository;

    @Override
    public List<TipoMantenimiento> listar() {
        return tipoMantenimientoRepository.findAll();
    }

    @Override
    public Optional<TipoMantenimiento> buscarPorId(Integer id) {
        return tipoMantenimientoRepository.findById(id);
    }

    @Override
    public TipoMantenimiento guardar(TipoMantenimiento tipoMantenimiento) {
        return tipoMantenimientoRepository.save(tipoMantenimiento);
    }

    @Override
    public TipoMantenimiento actualizar(Integer id, TipoMantenimiento tipoMantenimiento) {
        TipoMantenimiento entidad = tipoMantenimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de mantenimiento no encontrado con ID: " + id));

        entidad.setNombreTipo(tipoMantenimiento.getNombreTipo());
        entidad.setDescripcion(tipoMantenimiento.getDescripcion());
        return tipoMantenimientoRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!tipoMantenimientoRepository.existsById(id)) {
            throw new RuntimeException("Tipo de mantenimiento no encontrado con ID: " + id);
        }
        tipoMantenimientoRepository.deleteById(id);
    }
}
