package com.backSpringBatch.postgres.entity;
import com.sun.istack.Nullable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name ="mantenimiento_feriado", schema = "marcaciones")
public class MantenimientoFeriado
{

    @Id
    @Column(name = "id_mantenimiento_feriado", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long idMantenimientoFeriado;


    @Column(name = "feriado")
    private String feriado;

    @Column(name = "fecha_inicio")
    private Instant fechaInicio;

    @Column(name = "fecha_fin")
    private Instant fechaFin;


    @Column(name = "porcentaje")
    private BigDecimal porcentaje;

    @Column(name = "estado" ,nullable = false)
    private  Boolean estado;

    public MantenimientoFeriado() {
    }

    public Long getIdMantenimientoFeriado() {
        return idMantenimientoFeriado;
    }

    public void setIdMantenimientoFeriado(Long idMantenimientoFeriado) {
        this.idMantenimientoFeriado = idMantenimientoFeriado;
    }

    public String getFeriado() {
        return feriado;
    }

    public void setFeriado(String feriado) {
        this.feriado = feriado;
    }

    public Instant getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Instant fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Instant getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Instant fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
