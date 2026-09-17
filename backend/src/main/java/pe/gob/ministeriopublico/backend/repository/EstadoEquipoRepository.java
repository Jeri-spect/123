package pe.gob.ministeriopublico.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.EstadoEquipo;

@Repository
public interface EstadoEquipoRepository extends JpaRepository<EstadoEquipo, Integer> {
    Optional<EstadoEquipo> findByNombreEstado(String nombreEstado);
}
