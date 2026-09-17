package pe.gob.ministeriopublico.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.UsuarioRol;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Integer> {
    List<UsuarioRol> findByUsuarioIdUsuario(Integer idUsuario);
    List<UsuarioRol> findByRolIdRol(Integer idRol);
    Optional<UsuarioRol> findByUsuarioIdUsuarioAndRolIdRol(Integer idUsuario, Integer idRol);
}
