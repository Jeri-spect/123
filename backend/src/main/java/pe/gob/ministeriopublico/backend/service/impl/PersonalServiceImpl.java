package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.Personal;
import pe.gob.ministeriopublico.backend.repository.PersonalRepository;
import pe.gob.ministeriopublico.backend.service.PersonalService;

@Service
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {

    private final PersonalRepository personalRepository;

    @Override
    public List<Personal> listar() {
        return personalRepository.findAll();
    }

    @Override
    public Optional<Personal> buscarPorId(Integer id) {
        return personalRepository.findById(id);
    }

    @Override
    public Personal guardar(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public Personal actualizar(Integer id, Personal personal) {
        Personal entidad = personalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personal no encontrado con ID: " + id));

        entidad.setTipoPersonal(personal.getTipoPersonal());
        entidad.setDni(personal.getDni());
        entidad.setNombres(personal.getNombres());
        entidad.setApellidoPaterno(personal.getApellidoPaterno());
        entidad.setApellidoMaterno(personal.getApellidoMaterno());
        entidad.setCorreo(personal.getCorreo());
        entidad.setTelefono(personal.getTelefono());
        return personalRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!personalRepository.existsById(id)) {
            throw new RuntimeException("Personal no encontrado con ID: " + id);
        }
        personalRepository.deleteById(id);
    }

    @Override
    public List<Personal> buscarPorTipoPersonal(Integer idTipoPersonal) {
        return personalRepository.findByTipoPersonalIdTipoPersonal(idTipoPersonal);
    }

    @Override
    public Optional<Personal> buscarPorDni(String dni) {
        return personalRepository.findByDni(dni);
    }
}
