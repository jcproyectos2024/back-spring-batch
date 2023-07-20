package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.Util.SubAreaObject;

import java.util.List;

public class ResponseSubAreaPagination {

    private List<SubAreaObject> subArea;
    private String message;
    private int totalRegister;


    public List<SubAreaObject> getSubArea() {
        return subArea;
    }

    public void setSubArea(List<SubAreaObject> subArea) {
        this.subArea = subArea;
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
