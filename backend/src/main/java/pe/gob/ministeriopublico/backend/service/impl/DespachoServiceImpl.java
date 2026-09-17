package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.Despacho;
import pe.gob.ministeriopublico.backend.repository.DespachoRepository;
import pe.gob.ministeriopublico.backend.service.DespachoService;

@Service
@RequiredArgsConstructor
public class DespachoServiceImpl implements DespachoService {

    private final DespachoRepository despachoRepository;

    @Override
    public List<Despacho> listar() {
        return despachoRepository.findAll();
    }

    @Override
    public Optional<Despacho> buscarPorId(Integer id) {
        return despachoRepository.findById(id);
    }

    @Override
    public Despacho guardar(Despacho despacho) {
        return despachoRepository.save(despacho);
    }

    @Override
    public Despacho actualizar(Integer id, Despacho despacho) {
        Despacho entidad = despachoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despacho no encontrado con ID: " + id));

        entidad.setSede(despacho.getSede());
        entidad.setNombreDespacho(despacho.getNombreDespacho());
        entidad.setTipoProceso(despacho.getTipoProceso());
        return despachoRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!despachoRepository.existsById(id)) {
            throw new RuntimeException("Despacho no encontrado con ID: " + id);
        }
        despachoRepository.deleteById(id);
    }

    @Override
    public List<Despacho> buscarPorSede(Integer idSede) {
        return despachoRepository.findBySedeIdSede(idSede);
    }
}
