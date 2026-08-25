package pe.gob.ministeriopublico.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "distrito_fiscal")
public class DistritoFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distrito_fiscal")
    private Integer idDistritoFiscal;

    @Column(name = "nombre_distrito", nullable = false, length = 150)
    private String nombreDistrito;

    public DistritoFiscal() {
    }

    public Integer getIdDistritoFiscal() {
        return idDistritoFiscal;
    }

    public void setIdDistritoFiscal(Integer idDistritoFiscal) {
        this.idDistritoFiscal = idDistritoFiscal;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }
}
