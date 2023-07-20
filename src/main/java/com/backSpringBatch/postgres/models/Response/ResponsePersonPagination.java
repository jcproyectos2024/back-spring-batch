package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.Util.PersonObject;

import java.util.List;

public class ResponsePersonPagination {

    private List<PersonObject> person;
    private String message;
    private int totalRegister;


    public List<PersonObject> getPerson() {
        return person;
    }

    public void setPerson(List<PersonObject> person) {
        this.person = person;
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
