package com.backSpringBatch.postgres.entity;

import lombok.Data;

import java.io.Serializable;

public class AsistNowIdentificacionDto implements Serializable {
    private  String identificacion;
    private  String empresa;
    private  String nombres;
    private  String apellidos;

    public AsistNowIdentificacionDto() {
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
}