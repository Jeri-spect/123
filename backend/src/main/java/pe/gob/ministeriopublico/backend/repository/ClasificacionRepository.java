package pe.gob.ministeriopublico.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.Clasificacion;

@Repository
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Integer> {
    Optional<Clasificacion> findByNombreClasificacion(String nombreClasificacion);
}
