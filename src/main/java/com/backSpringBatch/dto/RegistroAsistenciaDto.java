package com.backSpringBatch.dto;

import java.util.Date;

public class RegistroAsistenciaDto
{


    private Date asisFecha;


    private String horaEntrada;

    private String horaSalidad;

    private String tipoBiometrinco;

    private String nombreBiometrico;

    private String identificacion;


    private String empresa;

    public RegistroAsistenciaDto() {
    }


    public Date getAsisFecha() {
        return asisFecha;
    }

    public void setAsisFecha(Date asisFecha) {
        this.asisFecha = asisFecha;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalidad() {
        return horaSalidad;
    }

    public void setHoraSalidad(String horaSalidad) {
        this.horaSalidad = horaSalidad;
    }

    public String getTipoBiometrinco() {
        return tipoBiometrinco;
    }

    public void setTipoBiometrinco(String tipoBiometrinco) {
        this.tipoBiometrinco = tipoBiometrinco;
    }

    public String getNombreBiometrico() {
        return nombreBiometrico;
    }

    public void setNombreBiometrico(String nombreBiometrico) {
        this.nombreBiometrico = nombreBiometrico;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
