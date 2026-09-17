package pe.gob.ministeriopublico.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer> {
    Optional<Personal> findByDni(String dni);
    List<Personal> findByTipoPersonalIdTipoPersonal(Integer idTipoPersonal);
}
