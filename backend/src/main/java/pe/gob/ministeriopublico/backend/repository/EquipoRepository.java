package pe.gob.ministeriopublico.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    Optional<Equipo> findByCodigoPatrimonial(String codigoPatrimonial);
    Optional<Equipo> findByNumeroSerie(String numeroSerie);
    List<Equipo> findByModeloIdModelo(Integer idModelo);
    List<Equipo> findByClasificacionIdClasificacion(Integer idClasificacion);
    List<Equipo> findByEstadoEquipoIdEstadoEquipo(Integer idEstadoEquipo);
}
