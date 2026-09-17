package pe.gob.ministeriopublico.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.Mantenimiento;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {
    List<Mantenimiento> findByEquipoIdEquipo(Integer idEquipo);
    List<Mantenimiento> findByTipoMantenimientoIdTipoMantenimiento(Integer idTipoMantenimiento);
}
