package com.backSpringBatch.postgres.models;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**

 */
@Data
public class TipoBiometricoCalculoDto implements Serializable {
    private  Long idTipoBiometricoCalculo;
    private  String horaTrabajada;
    private  Boolean estado;
    private  String nombreBiometrico;
    private  String tipoBiometrico;
    private  Timestamp fechaCreacion;
    private  Timestamp fechaModifica;
    private  String usuarioCreacion;
    private  String usuarioModifica;

    public TipoBiometricoCalculoDto() {
    }


    public Long getIdTipoBiometricoCalculo() {
        return idTipoBiometricoCalculo;
    }

    public void setIdTipoBiometricoCalculo(Long idTipoBiometricoCalculo) {
        this.idTipoBiometricoCalculo = idTipoBiometricoCalculo;
    }

    public String getHoraTrabajada() {
        return horaTrabajada;
    }

    public void setHoraTrabajada(String horaTrabajada) {
        this.horaTrabajada = horaTrabajada;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombreBiometrico() {
        return nombreBiometrico;
    }

    public void setNombreBiometrico(String nombreBiometrico) {
        this.nombreBiometrico = nombreBiometrico;
    }

    public String getTipoBiometrico() {
        return tipoBiometrico;
    }

    public void setTipoBiometrico(String tipoBiometrico) {
        this.tipoBiometrico = tipoBiometrico;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Timestamp fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }
}