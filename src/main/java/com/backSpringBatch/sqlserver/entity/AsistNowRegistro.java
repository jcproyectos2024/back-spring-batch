package com.backSpringBatch.sqlserver.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="asistnow_registro")
public class AsistNowRegistro {

    @EmbeddedId
    private AsistnowRegistroPK id;

    @Column(name = "asis_fecha")
    private Date asisFecha;

    @Column(name = "asis_hora")
    private String asisHora;

    @Column(name = "asis_tipo")
    private String asisTipo;

    @Column(name = "asis_res")
    private String asisRes;

    public AsistnowRegistroPK getId() {
        return id;
    }

    public void setId(AsistnowRegistroPK id) {
        this.id = id;
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
