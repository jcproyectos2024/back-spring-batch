package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.Util.FunctionObject;

import java.util.List;

public class ResponseFunctionPagination {

    private List<FunctionObject> function;
    private String message;
    private int totalRegister;


    public List<FunctionObject> getFunction() {
        return function;
    }

    public void setFunction(List<FunctionObject> function) {
        this.function = function;
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
