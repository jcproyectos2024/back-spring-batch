package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.models.TurnsDTO;

import java.util.List;

public class ResponseTurnsPagination {

    private List<TurnsDTO> turns;
    private String message;
    private int totalRegister;


    public List<TurnsDTO> getTurns() {
        return turns;
    }

    public void setTurns(List<TurnsDTO> turns) {
        this.turns = turns;
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
