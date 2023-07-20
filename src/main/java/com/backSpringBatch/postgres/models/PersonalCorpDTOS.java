package com.backSpringBatch.postgres.models;
import lombok.Data;

import java.io.Serializable;

/**

 */
@Data
public class PersonalCorpDTOS implements Serializable {
    private  Long idCorp;
    private  String emailCorporativo;
    private  ScheduleDTOS schedule;
    private  String ccosto;
    private  String subCcosto;
    private  String nombreCcosto;
    private  String fechaHistoria;
    private  String fechaInicio;
    private  String fechaVencimiento;

    public Long getIdCorp() {
        return idCorp;
    }

    public void setIdCorp(Long idCorp) {
        this.idCorp = idCorp;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public ScheduleDTOS getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleDTOS schedule) {
        this.schedule = schedule;
    }

    public String getCcosto() {
        return ccosto;
    }

    public void setCcosto(String ccosto) {
        this.ccosto = ccosto;
    }

    public String getSubCcosto() {
        return subCcosto;
    }

    public void setSubCcosto(String subCcosto) {
        this.subCcosto = subCcosto;
    }

    public String getNombreCcosto() {
        return nombreCcosto;
    }

    public void setNombreCcosto(String nombreCcosto) {
        this.nombreCcosto = nombreCcosto;
    }

    public String getFechaHistoria() {
        return fechaHistoria;
    }

    public void setFechaHistoria(String fechaHistoria) {
        this.fechaHistoria = fechaHistoria;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}