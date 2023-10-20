package com.backSpringBatch.postgres.models;

import java.util.List;

public class PersonResponseS
{

    private  TipoBiometricoCalculoDto  tipoBiometricoCalculoDto;
    private List<ScheduleDTO> scheduleDTOList;

    private String mensaje;

    private   boolean  success;

    public PersonResponseS() {
    }

    public TipoBiometricoCalculoDto getTipoBiometricoCalculoDto() {
        return tipoBiometricoCalculoDto;
    }

    public void setTipoBiometricoCalculoDto(TipoBiometricoCalculoDto tipoBiometricoCalculoDto) {
        this.tipoBiometricoCalculoDto = tipoBiometricoCalculoDto;
    }

    public List<ScheduleDTO> getScheduleDTOList() {
        return scheduleDTOList;
    }

    public void setScheduleDTOList(List<ScheduleDTO> scheduleDTOList) {
        this.scheduleDTOList = scheduleDTOList;
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
