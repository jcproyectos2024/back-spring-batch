package com.backSpringBatch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultarAsistenciasDias
{

    private  String identificacion;
    private String fechaInicio;
    private String fechaFin;
    private  String biometrico;
    private  String tipoBiometrinco;
    private String empresa;

    private String tipoBiometrincoGDSFahdi;

    public ConsultarAsistenciasDias() {
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getBiometrico() {
        return biometrico;
    }

    public void setBiometrico(String biometrico) {
        this.biometrico = biometrico;
    }

    public String getTipoBiometrinco() {
        return tipoBiometrinco;
    }

    public void setTipoBiometrinco(String tipoBiometrinco) {
        this.tipoBiometrinco = tipoBiometrinco;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipoBiometrincoGDSFahdi() {
        return tipoBiometrincoGDSFahdi;
    }

    public void setTipoBiometrincoGDSFahdi(String tipoBiometrincoGDSFahdi) {
        this.tipoBiometrincoGDSFahdi = tipoBiometrincoGDSFahdi;
    }
}
