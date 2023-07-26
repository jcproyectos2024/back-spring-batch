package com.backSpringBatch.dto;

import com.backSpringBatch.postgres.entity.AsistNow;
import org.springframework.data.domain.Sort;

import java.util.List;

public class ConsultarEntradaSalidaMarcacionResponses
{


    List<RegistroMarcacionesDTO> lsMarcacionesEntrada;
    List<RegistroMarcacionesDTO>  lsMarcacionesSalida;


    private String mensaje;


    private Integer totalRegistrosEntrada;

    private Integer totalRegistrosSalidad;


    private   boolean  success;


    public ConsultarEntradaSalidaMarcacionResponses() {
    }

    public List<RegistroMarcacionesDTO> getLsMarcacionesEntrada() {
        return lsMarcacionesEntrada;
    }

    public void setLsMarcacionesEntrada(List<RegistroMarcacionesDTO> lsMarcacionesEntrada) {
        this.lsMarcacionesEntrada = lsMarcacionesEntrada;
    }

    public List<RegistroMarcacionesDTO> getLsMarcacionesSalida() {
        return lsMarcacionesSalida;
    }

    public void setLsMarcacionesSalida(List<RegistroMarcacionesDTO> lsMarcacionesSalida) {
        this.lsMarcacionesSalida = lsMarcacionesSalida;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getTotalRegistrosEntrada() {
        return totalRegistrosEntrada;
    }

    public void setTotalRegistrosEntrada(Integer totalRegistrosEntrada) {
        this.totalRegistrosEntrada = totalRegistrosEntrada;
    }

    public Integer getTotalRegistrosSalidad() {
        return totalRegistrosSalidad;
    }

    public void setTotalRegistrosSalidad(Integer totalRegistrosSalidad) {
        this.totalRegistrosSalidad = totalRegistrosSalidad;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
