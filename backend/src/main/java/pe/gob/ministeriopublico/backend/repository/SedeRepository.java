package pe.gob.ministeriopublico.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {
    List<Sede> findByDistritoFiscalIdDistritoFiscal(Integer idDistritoFiscal);
}
