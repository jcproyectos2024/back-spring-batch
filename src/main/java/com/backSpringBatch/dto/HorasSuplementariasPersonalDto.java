package com.backSpringBatch.dto;

import lombok.Data;

import java.io.Serializable;


public class HorasSuplementariasPersonalDto implements Serializable {
    private  Long id;
    private  String identificacion;
    private  String tipo;
    private  Boolean estado;
    private  Long horas;
    private  Double porcentaje;

    private float saldoHorasExtras;

    public HorasSuplementariasPersonalDto() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Long getHoras() {
        return horas;
    }

    public void setHoras(Long horas) {
        this.horas = horas;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public float getSaldoHorasExtras() {
        return saldoHorasExtras;
    }

    public void setSaldoHorasExtras(float saldoHorasExtras) {
        this.saldoHorasExtras = saldoHorasExtras;
    }
}