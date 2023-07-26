package com.backSpringBatch.dto;

import com.backSpringBatch.postgres.entity.BiometricoDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.backSpringBatch.postgres.entity.AsistNow} entity
 */
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


}