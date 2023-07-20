package com.backSpringBatch.postgres.models.Acosux;

import com.fasterxml.jackson.annotation.JsonInclude;

public class RespuestaWebTO {
    public enum EstadoOperacionEnum {
        EXITO("EXITO"), ERROR("ERROR"), ADVERTENCIA("ADVERTENCIA"), SIN_ACCESO("SIN_ACCESO");
        private final String valor;
        private EstadoOperacionEnum(String valor) {
            this.valor = valor;
        }

        public String getValor() {
            return valor;
        }
        
    };
    private String estadoOperacion;
    private String operacionMensaje;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object extraInfo;   

    public RespuestaWebTO() {
    }

    public String getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(String estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    public String getOperacionMensaje() {
        return operacionMensaje;
    }

    public void setOperacionMensaje(String operacionMensaje) {
        this.operacionMensaje = operacionMensaje;
    }

    public Object getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Object extraInfo) {
        this.extraInfo = extraInfo;
    }
    
    
}
