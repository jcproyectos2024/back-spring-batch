package com.backSpringBatch.postgres.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleDTO {

    private Long id;

    private Date desde;

    private Date hasta;

    private String nameSchedule;

    private Long idTurns;

    private String userCreation;

    private String userUpdate;

    private  TurnsDTO turns;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSchedule() {
        return nameSchedule;
    }

    public void setNameSchedule(String nameSchedule) {
        this.nameSchedule = nameSchedule;
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

    public Long getIdTurns() {
        return idTurns;
    }

    public void setIdTurns(Long idTurns) {
        this.idTurns = idTurns;
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

    public TurnsDTO getTurns() {
        return turns;
    }

    public void setTurns(TurnsDTO turns) {
        this.turns = turns;
    }
}
