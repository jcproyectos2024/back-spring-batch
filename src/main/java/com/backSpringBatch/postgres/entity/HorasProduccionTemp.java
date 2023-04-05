package com.backSpringBatch.postgres.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="hora_produccion_temp", schema = "public")
public class HorasProduccionTemp {

    @EmbeddedId
    private AsistnowPK id;

    @Column(name = "identificacion")
    private  String identificacion;

    @Column(name="prod_tipo")
    private  String tipo;

    @Column(name = "status")
    private  Boolean status;


    public AsistnowPK getId() {
        return id;
    }

    public void setId(AsistnowPK id) {
        this.id = id;
    }


    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
