package com.backSpringBatch.dto;

import com.backSpringBatch.postgres.entity.AsistNow;
import org.springframework.data.domain.Sort;

import java.util.List;

public class ConsultarEntradaSalidaMarcacionResponses
{


    List<RegistroMarcacionesDTO> lsMarcacionesEntradaSalida;



    private String mensaje;


    private Integer totalRegistrosEntradaSalidad;




    private   boolean  success;


    public ConsultarEntradaSalidaMarcacionResponses() {
    }

    public List<RegistroMarcacionesDTO> getLsMarcacionesEntradaSalida() {
        return lsMarcacionesEntradaSalida;
    }

    public void setLsMarcacionesEntradaSalida(List<RegistroMarcacionesDTO> lsMarcacionesEntradaSalida) {
        this.lsMarcacionesEntradaSalida = lsMarcacionesEntradaSalida;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getTotalRegistrosEntradaSalidad() {
        return totalRegistrosEntradaSalidad;
    }

    public void setTotalRegistrosEntradaSalidad(Integer totalRegistrosEntradaSalidad) {
        this.totalRegistrosEntradaSalidad = totalRegistrosEntradaSalidad;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
