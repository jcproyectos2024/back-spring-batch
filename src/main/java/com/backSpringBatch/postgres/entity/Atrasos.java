package com.backSpringBatch.postgres.entity;


import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name ="atrasos", schema = "marcaciones")
public class Atrasos {


    @EmbeddedId
    private AsistnowPK id;

    @Column (name = "tiempo_atraso")
    private  String tiempoAtraso;


    @Column(name= "identificacion")
    private String identificacion;

    @Column(name= "justificacion")
    private  Boolean justificacion;

    @Column(name = "atraso_fecha")
    private Date fecha;



    public AsistnowPK getId() {
        return id;
    }

    public void setId(AsistnowPK id) {
        this.id = id;
    }

    public String getTiempoAtraso() {
        return tiempoAtraso;
    }

    public void setTiempoAtraso(String tiempoAtraso) {
        this.tiempoAtraso = tiempoAtraso;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Boolean getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(Boolean justificacion) {
        this.justificacion = justificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
