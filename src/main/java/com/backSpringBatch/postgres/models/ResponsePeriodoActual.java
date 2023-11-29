package com.backSpringBatch.postgres.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsePeriodoActual
{
    private   String periodoAsistencia;

    public ResponsePeriodoActual() {
    }

    public String getPeriodoAsistencia() {
        return periodoAsistencia;
    }

    public void setPeriodoAsistencia(String periodoAsistencia) {
        this.periodoAsistencia = periodoAsistencia;
    }
}
