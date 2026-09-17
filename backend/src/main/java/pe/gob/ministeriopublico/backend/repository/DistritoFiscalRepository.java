package pe.gob.ministeriopublico.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.gob.ministeriopublico.backend.entity.DistritoFiscal;

@Repository
public interface DistritoFiscalRepository extends JpaRepository<DistritoFiscal, Integer> {
    Optional<DistritoFiscal> findByNombreDistrito(String nombreDistrito);
}
