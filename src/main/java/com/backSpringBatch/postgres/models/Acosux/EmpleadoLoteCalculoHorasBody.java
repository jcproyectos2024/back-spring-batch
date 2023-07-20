package com.backSpringBatch.postgres.models.Acosux;

public class EmpleadoLoteCalculoHorasBody
{

     private  String empresa;
     private  String  sector;
     private  String  piscina;
     private  String categoria;
     private  boolean rol;
     private  String fechaHasta;
     private  String motivo;
     private AcosuxBodyInfoSys sisInfoTO;

    private  String fechaInicioCalculoHoraSemple;

    private  String fechaFinCalculoHoraSemple;

    public EmpleadoLoteCalculoHorasBody() {
    }


    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getPiscina() {
        return piscina;
    }

    public void setPiscina(String piscina) {
        this.piscina = piscina;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public AcosuxBodyInfoSys getSisInfoTO() {
        return sisInfoTO;
    }

    public void setSisInfoTO(AcosuxBodyInfoSys sisInfoTO) {
        this.sisInfoTO = sisInfoTO;
    }

    public String getFechaInicioCalculoHoraSemple() {
        return fechaInicioCalculoHoraSemple;
    }

    public void setFechaInicioCalculoHoraSemple(String fechaInicioCalculoHoraSemple) {
        this.fechaInicioCalculoHoraSemple = fechaInicioCalculoHoraSemple;
    }

    public String getFechaFinCalculoHoraSemple() {
        return fechaFinCalculoHoraSemple;
    }

    public void setFechaFinCalculoHoraSemple(String fechaFinCalculoHoraSemple) {
        this.fechaFinCalculoHoraSemple = fechaFinCalculoHoraSemple;
    }
}
