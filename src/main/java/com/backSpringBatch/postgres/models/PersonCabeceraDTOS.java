package com.backSpringBatch.postgres.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**

 */
@Data
public class PersonCabeceraDTOS implements Serializable {
    private  Long id;
    private  String apellidosEmpleado;
    private  String nombresEmpleado;
    private  String identificacion;
    private  String userCreation;
    private  String userUpdate;
    private  Date dateRegister;
    private  Date dateUpdate;
    private  Boolean status;
    private  PersonalCorpDTOS personalCorp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidosEmpleado() {
        return apellidosEmpleado;
    }

    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }

    public String getNombresEmpleado() {
        return nombresEmpleado;
    }

    public void setNombresEmpleado(String nombresEmpleado) {
        this.nombresEmpleado = nombresEmpleado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public String getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public PersonalCorpDTOS getPersonalCorp() {
        return personalCorp;
    }

    public void setPersonalCorp(PersonalCorpDTOS personalCorp) {
        this.personalCorp = personalCorp;
    }
}