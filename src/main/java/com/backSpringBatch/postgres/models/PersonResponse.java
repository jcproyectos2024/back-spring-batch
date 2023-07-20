package com.backSpringBatch.postgres.models;

public class PersonResponse
{

    private PersonCabeceraDTOC personCabeceraDTOC;

    private String mensaje;

    private   boolean  success;


    public PersonResponse() {
    }

    public PersonCabeceraDTOC getPersonCabeceraDTOC() {
        return personCabeceraDTOC;
    }

    public void setPersonCabeceraDTOC(PersonCabeceraDTOC personCabeceraDTOC) {
        this.personCabeceraDTOC = personCabeceraDTOC;
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
