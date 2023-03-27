package com.backSpringBatch.sqlserver.models;


import java.util.Date;

public class AsistNowRegistroDTO {


    private String asisId;

    private Date asisIng;

    private String asisZona;

    private Date asisFecha;

    private String asisHora;

    private String asisTipo;

    private String asisRes;


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

    public Date getAsisFecha() {
        return asisFecha;
    }

    public void setAsisFecha(Date asisFecha) {
        this.asisFecha = asisFecha;
    }

    public String getAsisHora() {
        return asisHora;
    }

    public void setAsisHora(String asisHora) {
        this.asisHora = asisHora;
    }

    public String getAsisTipo() {
        return asisTipo;
    }

    public void setAsisTipo(String asisTipo) {
        this.asisTipo = asisTipo;
    }

    public String getAsisRes() {
        return asisRes;
    }

    public void setAsisRes(String asisRes) {
        this.asisRes = asisRes;
    }
}



