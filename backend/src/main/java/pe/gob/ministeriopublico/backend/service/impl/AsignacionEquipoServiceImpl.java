package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.AsignacionEquipo;
import pe.gob.ministeriopublico.backend.repository.AsignacionEquipoRepository;
import pe.gob.ministeriopublico.backend.service.AsignacionEquipoService;

@Service
@RequiredArgsConstructor
public class AsignacionEquipoServiceImpl implements AsignacionEquipoService {

    private final AsignacionEquipoRepository asignacionEquipoRepository;

    @Override
    public List<AsignacionEquipo> listar() {
        return asignacionEquipoRepository.findAll();
    }

    @Override
    public Optional<AsignacionEquipo> buscarPorId(Integer id) {
        return asignacionEquipoRepository.findById(id);
    }

    @Override
    public AsignacionEquipo guardar(AsignacionEquipo asignacionEquipo) {
        return asignacionEquipoRepository.save(asignacionEquipo);
    }

    @Override
    public AsignacionEquipo actualizar(Integer id, AsignacionEquipo asignacionEquipo) {
        AsignacionEquipo entidad = asignacionEquipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada con ID: " + id));

        entidad.setEquipo(asignacionEquipo.getEquipo());
        entidad.setDespacho(asignacionEquipo.getDespacho());
        entidad.setPersonal(asignacionEquipo.getPersonal());
        entidad.setFechaInicio(asignacionEquipo.getFechaInicio());
        entidad.setFechaFin(asignacionEquipo.getFechaFin());
        entidad.setObservacion(asignacionEquipo.getObservacion());
        return asignacionEquipoRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!asignacionEquipoRepository.existsById(id)) {
            throw new RuntimeException("Asignación no encontrada con ID: " + id);
        }
        asignacionEquipoRepository.deleteById(id);
    }

    @Override
    public List<AsignacionEquipo> buscarPorEquipo(Integer idEquipo) {
        return asignacionEquipoRepository.findByEquipoIdEquipo(idEquipo);
    }

    @Override
    public List<AsignacionEquipo> buscarPorDespacho(Integer idDespacho) {
        return asignacionEquipoRepository.findByDespachoIdDespacho(idDespacho);
    }

    @Override
    public List<AsignacionEquipo> buscarPorPersonal(Integer idPersonal) {
        return asignacionEquipoRepository.findByPersonalIdPersonal(idPersonal);
    }
}
