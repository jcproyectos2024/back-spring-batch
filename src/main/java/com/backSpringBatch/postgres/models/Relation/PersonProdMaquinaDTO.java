package com.backSpringBatch.postgres.models.Relation;


import java.util.Date;

public class PersonProdMaquinaDTO {


    private Long id;

    private Long idPersonCabecera;

    private Long idGroupsProd ;

    private Date fecha;

    private String horaInicio;

    private String horaFin;

    private Long idMaquina;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPersonCabecera() {
        return idPersonCabecera;
    }

    public void setIdPersonCabecera(Long idPersonCabecera) {
        this.idPersonCabecera = idPersonCabecera;
    }

    public Long getIdGroupsProd() {
        return idGroupsProd;
    }

    public void setIdGroupsProd(Long idGroupsProd) {
        this.idGroupsProd = idGroupsProd;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Long getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Long idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
