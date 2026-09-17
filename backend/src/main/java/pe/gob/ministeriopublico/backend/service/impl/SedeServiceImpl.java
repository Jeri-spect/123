package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.Sede;
import pe.gob.ministeriopublico.backend.repository.SedeRepository;
import pe.gob.ministeriopublico.backend.service.SedeService;

@Service
@RequiredArgsConstructor
public class SedeServiceImpl implements SedeService {

    private final SedeRepository sedeRepository;

    @Override
    public List<Sede> listar() {
        return sedeRepository.findAll();
    }

    @Override
    public Optional<Sede> buscarPorId(Integer id) {
        return sedeRepository.findById(id);
    }

    @Override
    public Sede guardar(Sede sede) {
        return sedeRepository.save(sede);
    }

    @Override
    public Sede actualizar(Integer id, Sede sede) {
        Sede entidad = sedeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sede no encontrada con ID: " + id));

        entidad.setDistritoFiscal(sede.getDistritoFiscal());
        entidad.setNombreSede(sede.getNombreSede());
        entidad.setDireccion(sede.getDireccion());
        return sedeRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!sedeRepository.existsById(id)) {
            throw new RuntimeException("Sede no encontrada con ID: " + id);
        }
        sedeRepository.deleteById(id);
    }

    @Override
    public List<Sede> buscarPorDistritoFiscal(Integer idDistritoFiscal) {
        return sedeRepository.findByDistritoFiscalIdDistritoFiscal(idDistritoFiscal);
    }
}
