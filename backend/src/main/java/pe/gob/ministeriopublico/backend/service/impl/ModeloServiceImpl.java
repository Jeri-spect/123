package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.Modelo;
import pe.gob.ministeriopublico.backend.repository.ModeloRepository;
import pe.gob.ministeriopublico.backend.service.ModeloService;

@Service
@RequiredArgsConstructor
public class ModeloServiceImpl implements ModeloService {

    private final ModeloRepository modeloRepository;

    @Override
    public List<Modelo> listar() {
        return modeloRepository.findAll();
    }

    @Override
    public Optional<Modelo> buscarPorId(Integer id) {
        return modeloRepository.findById(id);
    }

    @Override
    public Modelo guardar(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    @Override
    public Modelo actualizar(Integer id, Modelo modelo) {
        Modelo entidad = modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modelo no encontrado con ID: " + id));

        entidad.setMarca(modelo.getMarca());
        entidad.setNombreModelo(modelo.getNombreModelo());
        entidad.setDescripcion(modelo.getDescripcion());
        return modeloRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!modeloRepository.existsById(id)) {
            throw new RuntimeException("Modelo no encontrado con ID: " + id);
        }
        modeloRepository.deleteById(id);
    }

    @Override
    public List<Modelo> buscarPorMarca(Integer idMarca) {
        return modeloRepository.findByMarcaIdMarca(idMarca);
    }
}
