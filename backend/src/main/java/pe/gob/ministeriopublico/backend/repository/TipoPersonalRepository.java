package pe.gob.ministeriopublico.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.TipoPersonal;

@Repository
public interface TipoPersonalRepository extends JpaRepository<TipoPersonal, Integer> {
    Optional<TipoPersonal> findByNombreTipoPersonal(String nombreTipoPersonal);
}
