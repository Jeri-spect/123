package pe.gob.ministeriopublico.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.Despacho;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho, Integer> {
    List<Despacho> findBySedeIdSede(Integer idSede);
}
