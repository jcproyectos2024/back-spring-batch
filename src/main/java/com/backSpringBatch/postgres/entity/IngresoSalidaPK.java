package com.backSpringBatch.postgres.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class IngresoSalidaPK implements Serializable
{
    @Column(name = "asis_id", nullable = false, updatable = false)
    private String asisId;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_entrada")
    private Date fechaEntrada;

    @Column(name = "nomina_cod")
    private String identificacion;

    public IngresoSalidaPK() {
    }

    public String getAsisId() {
        return asisId;
    }

    public void setAsisId(String asisId) {
        this.asisId = asisId;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
