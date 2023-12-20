package com.backSpringBatch.postgres.models.Master;

import com.backSpringBatch.postgres.entity.AsistNowIdentificacionDto;

import java.util.List;

public class MarcacionIndentificacionResponses
{
    private List<AsistNowIdentificacionDto> asistNowIdentificacionDtoList;
    private String message;
    private boolean success;

    public MarcacionIndentificacionResponses() {
    }

    public List<AsistNowIdentificacionDto> getAsistNowIdentificacionDtoList() {
        return asistNowIdentificacionDtoList;
    }

    public void setAsistNowIdentificacionDtoList(List<AsistNowIdentificacionDto> asistNowIdentificacionDtoList) {
        this.asistNowIdentificacionDtoList = asistNowIdentificacionDtoList;
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
