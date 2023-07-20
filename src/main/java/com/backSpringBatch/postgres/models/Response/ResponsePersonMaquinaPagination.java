package com.backSpringBatch.postgres.models.Response;


import com.backRRHH.Util.PersonMaquinaObject;

import java.util.List;

public class ResponsePersonMaquinaPagination {

    private List<PersonMaquinaObject> personMaquina;
    private String message;
    private int totalRegister;


    public List<PersonMaquinaObject> getPersonMaquina() {
        return personMaquina;
    }

    public void setPersonMaquina(List<PersonMaquinaObject> personMaquina) {
        this.personMaquina = personMaquina;
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
