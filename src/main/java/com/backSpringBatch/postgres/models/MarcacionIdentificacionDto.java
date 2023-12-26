package com.backSpringBatch.postgres.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarcacionIdentificacionDto
{
    private  String asisId;
    private  String identificacion;
    private  String apellidos;
    private  String nombres;
    private  String empresa;

    private String identificacionApellidos;

    public MarcacionIdentificacionDto() {
    }

    public String getAsisId() {
        return asisId;
    }

    public void setAsisId(String asisId) {
        this.asisId = asisId;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getIdentificacionApellidos() {
        return identificacionApellidos;
    }

    public void setIdentificacionApellidos(String identificacionApellidos) {
        this.identificacionApellidos = identificacionApellidos;
    }
}
