package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.Equipo;
import pe.gob.ministeriopublico.backend.repository.EquipoRepository;
import pe.gob.ministeriopublico.backend.service.EquipoService;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    @Override
    public List<Equipo> listar() {
        return equipoRepository.findAll();
    }

    @Override
    public Optional<Equipo> buscarPorId(Integer id) {
        return equipoRepository.findById(id);
    }

    @Override
    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public Equipo actualizar(Integer id, Equipo equipo) {
        Equipo entidad = equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));

        entidad.setModelo(equipo.getModelo());
        entidad.setClasificacion(equipo.getClasificacion());
        entidad.setEstadoEquipo(equipo.getEstadoEquipo());
        entidad.setCodigoPatrimonial(equipo.getCodigoPatrimonial());
        entidad.setNumeroSerie(equipo.getNumeroSerie());
        entidad.setObservacion(equipo.getObservacion());
        entidad.setFechaAdquisicion(equipo.getFechaAdquisicion());
        return equipoRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!equipoRepository.existsById(id)) {
            throw new RuntimeException("Equipo no encontrado con ID: " + id);
        }
        equipoRepository.deleteById(id);
    }

    @Override
    public List<Equipo> buscarPorModelo(Integer idModelo) {
        return equipoRepository.findByModeloIdModelo(idModelo);
    }

    @Override
    public List<Equipo> buscarPorClasificacion(Integer idClasificacion) {
        return equipoRepository.findByClasificacionIdClasificacion(idClasificacion);
    }

    @Override
    public List<Equipo> buscarPorEstadoEquipo(Integer idEstadoEquipo) {
        return equipoRepository.findByEstadoEquipoIdEstadoEquipo(idEstadoEquipo);
    }

    @Override
    public Optional<Equipo> buscarPorCodigoPatrimonial(String codigoPatrimonial) {
        return equipoRepository.findByCodigoPatrimonial(codigoPatrimonial);
    }
}
