package com.backSpringBatch.postgres.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name ="asistnow", schema = "marcaciones")
public class AsistNow implements Serializable {


    @EmbeddedId
    private AsistnowPK id;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "asis_fecha")
    private Date asisFecha;

    @Column(name = "asis_hora")
    private String asisHora;

    @Column(name = "asis_tipo")
    private String asisTipo;

    @Column(name = "asis_res")
    private String asisRes;

    @Column(name = "nomina_cod")
    private String identificacion;


    @Column(name = "empresa")
    private String empresa;

    @Column(name = "nomina_nom")
    private String nombres;

    @Column(name = "nomina_ape")
    private String apellidos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asis_zona", referencedColumnName = "ip_biometrico", insertable = false, updatable = false)
    private Biometrico biometrico;

    @Column (name = "asis_horas_suplementaria")
    private Boolean asisHorasSuplementaria;

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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Boolean getAsisHorasSuplementaria() {
        return asisHorasSuplementaria;
    }

    public void setAsisHorasSuplementaria(Boolean asisHorasSuplementaria) {
        this.asisHorasSuplementaria = asisHorasSuplementaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsistNow t = (AsistNow) o;
        return asisFecha.equals(t.asisFecha);
    }

    @Override
    public int hashCode() {
        return asisFecha.hashCode();
    }
}



