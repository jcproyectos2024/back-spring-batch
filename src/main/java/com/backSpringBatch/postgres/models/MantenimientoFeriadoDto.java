package com.backSpringBatch.postgres.models;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;


public class MantenimientoFeriadoDto  {
    private  Long idMantenimientoFeriado;
    private  String feriado;
    private  Instant fechaInicio;
    private  Instant fechaFin;
    private  BigDecimal porcentaje;
    private  Boolean estado;
    private Instant fechaCreacion;
    private String usuarioCreacion;
    private Instant fechaModifica;
    private String usuarioModifica;
    public MantenimientoFeriadoDto() {
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

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Instant getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Instant fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }
}