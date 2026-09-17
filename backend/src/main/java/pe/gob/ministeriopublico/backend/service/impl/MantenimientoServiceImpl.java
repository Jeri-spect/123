package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.Mantenimiento;
import pe.gob.ministeriopublico.backend.repository.MantenimientoRepository;
import pe.gob.ministeriopublico.backend.service.MantenimientoService;

@Service
@RequiredArgsConstructor
public class MantenimientoServiceImpl implements MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;

    @Override
    public List<Mantenimiento> listar() {
        return mantenimientoRepository.findAll();
    }

    @Override
    public Optional<Mantenimiento> buscarPorId(Integer id) {
        return mantenimientoRepository.findById(id);
    }

    @Override
    public Mantenimiento guardar(Mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    @Override
    public Mantenimiento actualizar(Integer id, Mantenimiento mantenimiento) {
        Mantenimiento entidad = mantenimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado con ID: " + id));

        entidad.setEquipo(mantenimiento.getEquipo());
        entidad.setTipoMantenimiento(mantenimiento.getTipoMantenimiento());
        entidad.setFechaMantenimiento(mantenimiento.getFechaMantenimiento());
        entidad.setDiagnostico(mantenimiento.getDiagnostico());
        entidad.setTrabajoRealizado(mantenimiento.getTrabajoRealizado());
        entidad.setRepuesto(mantenimiento.getRepuesto());
        entidad.setResponsableMantenimiento(mantenimiento.getResponsableMantenimiento());
        entidad.setObservacion(mantenimiento.getObservacion());
        return mantenimientoRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!mantenimientoRepository.existsById(id)) {
            throw new RuntimeException("Mantenimiento no encontrado con ID: " + id);
        }
        mantenimientoRepository.deleteById(id);
    }

    @Override
    public List<Mantenimiento> buscarPorEquipo(Integer idEquipo) {
        return mantenimientoRepository.findByEquipoIdEquipo(idEquipo);
    }

    @Override
    public List<Mantenimiento> buscarPorTipoMantenimiento(Integer idTipoMantenimiento) {
        return mantenimientoRepository.findByTipoMantenimientoIdTipoMantenimiento(idTipoMantenimiento);
    }
}
