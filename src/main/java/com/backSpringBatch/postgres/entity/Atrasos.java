package com.backSpringBatch.postgres.entity;


import groovyjarjarantlr4.v4.runtime.misc.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name ="atrasos", schema = "public")
public class Atrasos {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private String id;

    @Column (name = "tiempo_atraso")
    private  String tiempoAtraso;

    @Column (name= "fecha")
    private Date fecha;


    @Column(name= "identificacion")
    private String identificacion;

    @Column(name= "justificacion")
    private  Boolean justificacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
