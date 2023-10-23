package com.backSpringBatch.sqlserver.models;

import com.backSpringBatch.postgres.entity.AsistNow;

import java.util.List;

public class ResponsesEntradaSalidaMarcacionDias
{


    private List<AsistNow> lsMarcacionesEntrada;
    private List<AsistNow> lsMarcacionesSalida;

    private String mensaje;
    private   boolean  success;


    public ResponsesEntradaSalidaMarcacionDias() {
    }

    public List<AsistNow> getLsMarcacionesEntrada() {
        return lsMarcacionesEntrada;
    }

    public void setLsMarcacionesEntrada(List<AsistNow> lsMarcacionesEntrada) {
        this.lsMarcacionesEntrada = lsMarcacionesEntrada;
    }

    public List<AsistNow> getLsMarcacionesSalida() {
        return lsMarcacionesSalida;
    }

    public void setLsMarcacionesSalida(List<AsistNow> lsMarcacionesSalida) {
        this.lsMarcacionesSalida = lsMarcacionesSalida;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
