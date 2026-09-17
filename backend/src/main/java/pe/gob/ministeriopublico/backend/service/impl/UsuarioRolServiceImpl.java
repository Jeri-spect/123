package pe.gob.ministeriopublico.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.gob.ministeriopublico.backend.entity.UsuarioRol;
import pe.gob.ministeriopublico.backend.repository.UsuarioRolRepository;
import pe.gob.ministeriopublico.backend.service.UsuarioRolService;

@Service
@RequiredArgsConstructor
public class UsuarioRolServiceImpl implements UsuarioRolService {

    private final UsuarioRolRepository usuarioRolRepository;

    @Override
    public List<UsuarioRol> listar() {
        return usuarioRolRepository.findAll();
    }

    @Override
    public Optional<UsuarioRol> buscarPorId(Integer id) {
        return usuarioRolRepository.findById(id);
    }

    @Override
    public UsuarioRol guardar(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }

    @Override
    public UsuarioRol actualizar(Integer id, UsuarioRol usuarioRol) {
        UsuarioRol entidad = usuarioRolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UsuarioRol no encontrado con ID: " + id));

        entidad.setUsuario(usuarioRol.getUsuario());
        entidad.setRol(usuarioRol.getRol());
        return usuarioRolRepository.save(entidad);
    }

    @Override
    public void eliminar(Integer id) {
        if (!usuarioRolRepository.existsById(id)) {
            throw new RuntimeException("UsuarioRol no encontrado con ID: " + id);
        }
        usuarioRolRepository.deleteById(id);
    }

    @Override
    public List<UsuarioRol> buscarPorUsuario(Integer idUsuario) {
        return usuarioRolRepository.findByUsuarioIdUsuario(idUsuario);
    }

    @Override
    public List<UsuarioRol> buscarPorRol(Integer idRol) {
        return usuarioRolRepository.findByRolIdRol(idRol);
    }

    @Override
    public Optional<UsuarioRol> buscarPorUsuarioYRol(Integer idUsuario, Integer idRol) {
        return usuarioRolRepository.findByUsuarioIdUsuarioAndRolIdRol(idUsuario, idRol);
    }
}
