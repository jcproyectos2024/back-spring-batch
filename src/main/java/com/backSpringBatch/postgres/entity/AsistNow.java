package com.backSpringBatch.postgres.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name ="asistnow", schema = "public")
public class AsistNow implements Serializable  {


    @EmbeddedId
    private AsistnowPK id;

    @Column(name = "asis_fecha")
    private Date asisFecha;

    @Column(name = "asis_hora")
    private String asisHora;

    @Column(name = "asis_tipo")
    private String asisTipo;

    @Column(name = "asis_res")
    private String asisRes;

    @Column (name = "nomina_cod")
    private String identificacion;


    @Column (name = "empresa")
    private String empresa;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asis_zona", referencedColumnName="ip_biometrico",  insertable = false, updatable = false)
    private  Biometrico  biometrico;

    public AsistnowPK getId() {
        return id;
    }

    public void setId(AsistnowPK id) {
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Biometrico getBiometrico() {
        return biometrico;
    }

    public void setBiometrico(Biometrico biometrico) {
        this.biometrico = biometrico;
    }
}



