package com.backSpringBatch.postgres.models;

import com.backSpringBatch.dto.HorasSuplementariasPersonalDto;
import java.util.List;

public class HorasSuplementariasPersonalResponses
{

    List<HorasSuplementariasPersonalDto>  horasSuplementariasPersonalDtoList;


    private String mensaje;


    private Integer totalRegistros;


    private   boolean  success;


    public HorasSuplementariasPersonalResponses() {
    }

    public List<HorasSuplementariasPersonalDto> getHorasSuplementariasPersonalDtoList() {
        return horasSuplementariasPersonalDtoList;
    }

    public void setHorasSuplementariasPersonalDtoList(List<HorasSuplementariasPersonalDto> horasSuplementariasPersonalDtoList) {
        this.horasSuplementariasPersonalDtoList = horasSuplementariasPersonalDtoList;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(Integer totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
