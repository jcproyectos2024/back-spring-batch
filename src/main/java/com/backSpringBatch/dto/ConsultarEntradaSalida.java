package com.backSpringBatch.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultarEntradaSalida
{
    private  String identificacion;
    private String apellidos;
    private String fechaInicio;
    private String fechaFin;
    private  String biometrico;
    private String empresa;
    private int numeroPagina;
    private int numeroRegistros;
    private  String ipBiometrico;

    public ConsultarEntradaSalida() {
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getNumeroRegistros() {
        return numeroRegistros;
    }

    public void setNumeroRegistros(int numeroRegistros) {
        this.numeroRegistros = numeroRegistros;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIpBiometrico() {
        return ipBiometrico;
    }

    public void setIpBiometrico(String ipBiometrico) {
        this.ipBiometrico = ipBiometrico;
    }
}
