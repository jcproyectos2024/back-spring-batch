package com.backSpringBatch.postgres.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**

 */
@Data
public class ScheduleDTOS implements Serializable {
    private  Long id;
    private  Date desde;
    private  Date hasta;
    private  String nameSchedule;
    private  Boolean status;
    private  String userCreation;
    private  String userUpdate;
    private  Date dateRegister;
    private  Date dateUpdate;
    private  String desdeString;
    private  TurnsDTOS turns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getNameSchedule() {
        return nameSchedule;
    }

    public void setNameSchedule(String nameSchedule) {
        this.nameSchedule = nameSchedule;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public String getDesdeString() {
        return desdeString;
    }

    public void setDesdeString(String desdeString) {
        this.desdeString = desdeString;
    }

    public TurnsDTOS getTurns() {
        return turns;
    }

    public void setTurns(TurnsDTOS turns) {
        this.turns = turns;
    }
}