package com.backSpringBatch.postgres.models;


import java.util.List;

public class ResponseAsistNowPagination {

    private List<AsistNowDTO> asistNowDTOS;
    private String message;
    private int totalRegister;


    public List<AsistNowDTO> getAsistNowDTOS() {
        return asistNowDTOS;
    }

    public void setAsistNowDTOS(List<AsistNowDTO> asistNowDTOS) {
        this.asistNowDTOS = asistNowDTOS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTotalRegister() {
        return totalRegister;
    }

    public void setTotalRegister(int totalRegister) {
        this.totalRegister = totalRegister;
    }
}
