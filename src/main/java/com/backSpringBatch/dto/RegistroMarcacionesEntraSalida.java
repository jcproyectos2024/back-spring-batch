package com.backSpringBatch.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RegistroMarcacionesEntraSalida
{
    private  String asisId;
    private Date asisFecha;
    private  String identificacion;
    private String nombres;
    private String apellidos;
    private  String asisTipo;
    private String  zona;
    private String asisHora;
    private Date asisIng;
    private  String empresa;

    public RegistroMarcacionesEntraSalida() {
    }

    public String getAsisId() {
        return asisId;
    }

    public void setAsisId(String asisId) {
        this.asisId = asisId;
    }

    public Date getAsisFecha() {
        return asisFecha;
    }

    public void setAsisFecha(Date asisFecha) {
        this.asisFecha = asisFecha;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAsisTipo() {
        return asisTipo;
    }

    public void setAsisTipo(String asisTipo) {
        this.asisTipo = asisTipo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getAsisHora() {
        return asisHora;
    }

    public void setAsisHora(String asisHora) {
        this.asisHora = asisHora;
    }

    public Date getAsisIng() {
        return asisIng;
    }

    public void setAsisIng(Date asisIng) {
        this.asisIng = asisIng;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
