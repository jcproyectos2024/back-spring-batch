package com.backSpringBatch.sqlserver.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Embeddable
public class AsistnowRegistroPK implements Serializable {


    private static final long serialVersionUID = -9182955378232476367L;
    @Column(name = "asis_id", nullable = false, updatable = false)
    private String asisId;

    @Column(name = "asis_ing")
    private LocalDateTime asisIng;

    @Column(name = "asis_zona")
    private String asisZona;

    public String getAsisId() {
        return asisId;
    }

    public void setAsisId(String asisId) {
        this.asisId = asisId;
    }

    public LocalDateTime getAsisIng() {
        return asisIng;
    }

    public void setAsisIng(LocalDateTime asisIng) {
        this.asisIng = asisIng;
    }

    public String getAsisZona() {
        return asisZona;
    }

    public void setAsisZona(String asisZona) {
        this.asisZona = asisZona;
    }
}
