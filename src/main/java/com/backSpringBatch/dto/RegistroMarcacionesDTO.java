package com.backSpringBatch.dto;

import com.backSpringBatch.postgres.entity.Biometrico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class RegistroMarcacionesDTO implements Serializable
{

    @JsonProperty("fecha")
    @JsonFormat(pattern="yyyy-MM-dd")
    private  Date asisFecha;
    @JsonProperty("hora")
    private  String asisHora;

    private  String identificacion;
    private  String empresa;

    private String nombres;


    private String apellidos;

    private BiometricoDto biometrico;

    public RegistroMarcacionesDTO() {
    }

    public Date getAsisFecha() {
        return asisFecha;
    }

    public void setAsisFecha(Date asisFecha) {
        this.asisFecha = asisFecha;
    }

    public String getAsisHora() {
        return asisHora;
    }

    public void setAsisHora(String asisHora) {
        this.asisHora = asisHora;
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

    public BiometricoDto getBiometrico() {
        return biometrico;
    }

    public void setBiometrico(BiometricoDto biometrico) {
        this.biometrico = biometrico;
    }


}