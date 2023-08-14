package com.backSpringBatch.postgres.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name ="hora_produccion", schema = "marcaciones")
public class HorasProduccion {

    @EmbeddedId
    private AsistnowPK id;

    @Column(name = "horas_produccion")
    private  String horasProduccion;

    @Column(name = "cal_horas_prod")
    private  Date calHorasProd;

    @Column(name = "identificacion")
    private  String identificacion;


    @Column(name = "fecha")
    private Date fecha;


    public AsistnowPK getId() {
        return id;
    }

    public void setId(AsistnowPK id) {
        this.id = id;
    }

    public String getHorasProduccion() {
        return horasProduccion;
    }

    public void setHorasProduccion(String horasProduccion) {
        this.horasProduccion = horasProduccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getCalHorasProd() {
        return calHorasProd;
    }

    public void setCalHorasProd(Date calHorasProd) {
        this.calHorasProd = calHorasProd;
    }


}
