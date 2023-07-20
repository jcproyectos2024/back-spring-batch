package com.backSpringBatch.postgres.models;
public class PersonResponseS
{

    PersonCabeceraDTOC  personCabeceraDTOC;
    private PersonalCorpDTOS  personalCorpDTOS;

    private String mensaje;

    private   boolean  success;

    public PersonResponseS() {
    }

    public PersonCabeceraDTOC getPersonCabeceraDTOC() {
        return personCabeceraDTOC;
    }

    public void setPersonCabeceraDTOC(PersonCabeceraDTOC personCabeceraDTOC) {
        this.personCabeceraDTOC = personCabeceraDTOC;
    }

    public PersonalCorpDTOS getPersonalCorpDTOS() {
        return personalCorpDTOS;
    }

    public void setPersonalCorpDTOS(PersonalCorpDTOS personalCorpDTOS) {
        this.personalCorpDTOS = personalCorpDTOS;
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
