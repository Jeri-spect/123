package pe.gob.ministeriopublico.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.AsignacionEquipo;

@Repository
public interface AsignacionEquipoRepository extends JpaRepository<AsignacionEquipo, Integer> {
    List<AsignacionEquipo> findByEquipoIdEquipo(Integer idEquipo);
    List<AsignacionEquipo> findByDespachoIdDespacho(Integer idDespacho);
    List<AsignacionEquipo> findByPersonalIdPersonal(Integer idPersonal);
}
