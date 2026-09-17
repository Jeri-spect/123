package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.EstadoEquipo;
import pe.gob.ministeriopublico.backend.repository.EstadoEquipoRepository;
import pe.gob.ministeriopublico.backend.service.EstadoEquipoService;

@Service
@RequiredArgsConstructor
public class EstadoEquipoServiceImpl implements EstadoEquipoService {

    private final EstadoEquipoRepository estadoEquipoRepository;

    @Override
    public List<EstadoEquipo> listar() {
        return estadoEquipoRepository.findAll();
    }

    @Override
    public Optional<EstadoEquipo> buscarPorId(Integer id) {
        return estadoEquipoRepository.findById(id);
    }

    @Override
    public EstadoEquipo guardar(EstadoEquipo estadoEquipo) {
        return estadoEquipoRepository.save(estadoEquipo);
    }

    @Override
    public EstadoEquipo actualizar(Integer id, EstadoEquipo estadoEquipo) {
        EstadoEquipo entidad = estadoEquipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado de equipo no encontrado con ID: " + id));

        entidad.setNombreEstado(estadoEquipo.getNombreEstado());
        entidad.setDescripcion(estadoEquipo.getDescripcion());
        return estadoEquipoRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!estadoEquipoRepository.existsById(id)) {
            throw new RuntimeException("Estado de equipo no encontrado con ID: " + id);
        }
        estadoEquipoRepository.deleteById(id);
    }
}
