package com.backSpringBatch.postgres.models;


import java.util.List;

public class ResponseHorasProduccionPagination {

    private List<HorasProduccionDTO> horasProduccionDTO;
    private String message;
    private int totalRegister;


    public List<HorasProduccionDTO> getHorasProduccionDTO() {
        return horasProduccionDTO;
    }

    public void setHorasProduccionDTO(List<HorasProduccionDTO> horasProduccionDTO) {
        this.horasProduccionDTO = horasProduccionDTO;
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
