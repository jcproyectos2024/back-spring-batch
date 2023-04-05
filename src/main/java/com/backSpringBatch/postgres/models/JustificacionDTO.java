package com.backSpringBatch.postgres.models;

import java.util.Date;

public class JustificacionDTO {



    private Boolean justificacion;

    private String identificacion;

    private Date fechaIng;

    public Boolean getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(Boolean justificacion) {
        this.justificacion = justificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }
}
