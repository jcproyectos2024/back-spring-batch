package com.backSpringBatch.postgres.models;

import java.util.Date;

public class AsistnowPKDTO {

    private String asisId;

    private Date asisIng;

    private String asisZona;

    public String getAsisId() {
        return asisId;
    }

    public void setAsisId(String asisId) {
        this.asisId = asisId;
    }

    public Date getAsisIng() {
        return asisIng;
    }

    public void setAsisIng(Date asisIng) {
        this.asisIng = asisIng;
    }

    public String getAsisZona() {
        return asisZona;
    }

    public void setAsisZona(String asisZona) {
        this.asisZona = asisZona;
    }
}
