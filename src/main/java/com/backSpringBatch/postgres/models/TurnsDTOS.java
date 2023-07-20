package com.backSpringBatch.postgres.models;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**

 */
@Data
public class TurnsDTOS implements Serializable {
    private  Long id;
    private  String nameTurns;
    private  Boolean status;
    private  String desde;
    private  String hasta;
    private  String userCreate;
    private  String userUpdate;
    private  Date dateRegister;
    private  Date dateUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTurns() {
        return nameTurns;
    }

    public void setNameTurns(String nameTurns) {
        this.nameTurns = nameTurns;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
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
}