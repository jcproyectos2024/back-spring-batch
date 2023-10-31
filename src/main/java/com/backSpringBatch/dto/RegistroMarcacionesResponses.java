package com.backSpringBatch.dto;

public class RegistroMarcacionesResponses
{

    RegistroMarcacionesDTO registroMarcacionesDTO;

    private String message;
    private   boolean  success;

    public RegistroMarcacionesResponses() {
    }

    public RegistroMarcacionesDTO getRegistroMarcacionesDTO() {
        return registroMarcacionesDTO;
    }

    public void setRegistroMarcacionesDTO(RegistroMarcacionesDTO registroMarcacionesDTO) {
        this.registroMarcacionesDTO = registroMarcacionesDTO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
