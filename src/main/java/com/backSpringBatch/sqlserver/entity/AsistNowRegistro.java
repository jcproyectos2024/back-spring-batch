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

    @Column (name = "nomina_cod")
    private String identificacion;

    @Column (name = "empresa")
    private String empresa;

    @Column (name = "nomina_nom")
    private String nombres;

    @Column (name = "nomina_ape")
    private String apellidos;

    @Column (name = "estado_asistnow_registro")
    private Boolean estadoAsistnowRegistro;

    @Column (name = "asis_horas_suplementaria")
    private Boolean asisHorasSuplementaria;


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

    public Boolean getEstadoAsistnowRegistro() {
        return estadoAsistnowRegistro;
    }

    public void setEstadoAsistnowRegistro(Boolean estadoAsistnowRegistro) {
        this.estadoAsistnowRegistro = estadoAsistnowRegistro;
    }

    public Boolean getAsisHorasSuplementaria() {
        return asisHorasSuplementaria;
    }

    public void setAsisHorasSuplementaria(Boolean asisHorasSuplementaria) {
        this.asisHorasSuplementaria = asisHorasSuplementaria;
    }
}
