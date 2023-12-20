package com.backSpringBatch.postgres.models.Master;

import com.backSpringBatch.postgres.entity.AsistNowIdentificacionDto;
import com.backSpringBatch.postgres.models.MarcacionIdentificacionDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarcacionIndentificacionResponses
{
    private List<MarcacionIdentificacionDto> marcacionIdentificacionDtos;
    private String message;
    private boolean success;

    public MarcacionIndentificacionResponses() {
    }

    public List<MarcacionIdentificacionDto> getMarcacionIdentificacionDtos() {
        return marcacionIdentificacionDtos;
    }

    public void setMarcacionIdentificacionDtos(List<MarcacionIdentificacionDto> marcacionIdentificacionDtos) {
        this.marcacionIdentificacionDtos = marcacionIdentificacionDtos;
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
