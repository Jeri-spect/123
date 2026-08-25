package pe.gob.ministeriopublico.backend.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento")
    private Integer idMantenimiento;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_mantenimiento", nullable = false)
    private TipoMantenimiento tipoMantenimiento;
    @Column(name = "fecha_mantenimiento", nullable = false)
    private LocalDate fechaMantenimiento;
    @Column(columnDefinition = "TEXT")
    private String diagnostico;
    @Column(name = "trabajo_realizado", columnDefinition = "TEXT")
    private String trabajoRealizado;
    @Column(columnDefinition = "TEXT")
    private String repuesto;
    @Column(name = "responsable_mantenimiento", length = 150)
    private String responsableMantenimiento;
    @Column(columnDefinition = "TEXT")
    private String observacion;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public Mantenimiento() { }
    public Integer getIdMantenimiento() { return idMantenimiento; }
    public void setIdMantenimiento(Integer idMantenimiento) { this.idMantenimiento = idMantenimiento; }
    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }
    public TipoMantenimiento getTipoMantenimiento() { return tipoMantenimiento; }
    public void setTipoMantenimiento(TipoMantenimiento tipoMantenimiento) { this.tipoMantenimiento = tipoMantenimiento; }
    public LocalDate getFechaMantenimiento() { return fechaMantenimiento; }
    public void setFechaMantenimiento(LocalDate fechaMantenimiento) { this.fechaMantenimiento = fechaMantenimiento; }
    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
    public String getTrabajoRealizado() { return trabajoRealizado; }
    public void setTrabajoRealizado(String trabajoRealizado) { this.trabajoRealizado = trabajoRealizado; }
    public String getRepuesto() { return repuesto; }
    public void setRepuesto(String repuesto) { this.repuesto = repuesto; }
    public String getResponsableMantenimiento() { return responsableMantenimiento; }
    public void setResponsableMantenimiento(String responsableMantenimiento) { this.responsableMantenimiento = responsableMantenimiento; }
    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
