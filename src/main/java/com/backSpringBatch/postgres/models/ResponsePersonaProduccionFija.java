package com.backSpringBatch.postgres.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsePersonaProduccionFija
{
    private List<PersonaProduccionFijaDto> personaProduccionFijaDtoList;
    private String message;
    private   boolean  success;

    public ResponsePersonaProduccionFija() {
    }

    public List<PersonaProduccionFijaDto> getPersonaProduccionFijaDtoList() {
        return personaProduccionFijaDtoList;
    }

    public void setPersonaProduccionFijaDtoList(List<PersonaProduccionFijaDto> personaProduccionFijaDtoList) {
        this.personaProduccionFijaDtoList = personaProduccionFijaDtoList;
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
