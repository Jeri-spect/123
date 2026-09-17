package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.Clasificacion;
import pe.gob.ministeriopublico.backend.repository.ClasificacionRepository;
import pe.gob.ministeriopublico.backend.service.ClasificacionService;

@Service
@RequiredArgsConstructor
public class ClasificacionServiceImpl implements ClasificacionService {

    private final ClasificacionRepository clasificacionRepository;

    @Override
    public List<Clasificacion> listar() {
        return clasificacionRepository.findAll();
    }

    @Override
    public Optional<Clasificacion> buscarPorId(Integer id) {
        return clasificacionRepository.findById(id);
    }

    @Override
    public Clasificacion guardar(Clasificacion clasificacion) {
        return clasificacionRepository.save(clasificacion);
    }

    @Override
    public Clasificacion actualizar(Integer id, Clasificacion clasificacion) {
        Clasificacion entidad = clasificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clasificación no encontrada con ID: " + id));

        entidad.setNombreClasificacion(clasificacion.getNombreClasificacion());
        entidad.setDescripcion(clasificacion.getDescripcion());
        return clasificacionRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!clasificacionRepository.existsById(id)) {
            throw new RuntimeException("Clasificación no encontrada con ID: " + id);
        }
        clasificacionRepository.deleteById(id);
    }
}
