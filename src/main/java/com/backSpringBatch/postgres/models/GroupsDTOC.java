package com.backSpringBatch.postgres.models;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


public class GroupsDTOC implements Serializable {
    private  Long id;
    private  String nameGroups;
    private  Boolean status;
    private  String userCreation;
    private  String userUpdate;
    private  Date dateRegister;
    private  Date dateUpdate;
    private  ScheduleDTOC schedule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGroups() {
        return nameGroups;
    }

    public void setNameGroups(String nameGroups) {
        this.nameGroups = nameGroups;
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

    public ScheduleDTOC getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleDTOC schedule) {
        this.schedule = schedule;
    }
}