package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.Marca;
import pe.gob.ministeriopublico.backend.repository.MarcaRepository;
import pe.gob.ministeriopublico.backend.service.MarcaService;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;

    @Override
    public List<Marca> listar() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<Marca> buscarPorId(Integer id) {
        return marcaRepository.findById(id);
    }

    @Override
    public Marca guardar(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca actualizar(Integer id, Marca marca) {
        Marca entidad = marcaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con ID: " + id));

        entidad.setNombreMarca(marca.getNombreMarca());
        return marcaRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!marcaRepository.existsById(id)) {
            throw new RuntimeException("Marca no encontrada con ID: " + id);
        }
        marcaRepository.deleteById(id);
    }
}
