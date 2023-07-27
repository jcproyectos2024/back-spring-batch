package com.backSpringBatch.dto;

public class RegistroMarcacionesResponses
{

    RegistroMarcacionesDTO registroMarcacionesDTO;

    private String mensaje;
    private   boolean  success;

    public RegistroMarcacionesResponses() {
    }

    public RegistroMarcacionesDTO getRegistroMarcacionesDTO() {
        return registroMarcacionesDTO;
    }

    public void setRegistroMarcacionesDTO(RegistroMarcacionesDTO registroMarcacionesDTO) {
        this.registroMarcacionesDTO = registroMarcacionesDTO;
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
