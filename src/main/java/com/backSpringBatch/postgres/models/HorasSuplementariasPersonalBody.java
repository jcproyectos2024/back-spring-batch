package com.backSpringBatch.postgres.models;

public class HorasSuplementariasPersonalBody
{

    private String periodo;
    private String identificacion;
    private String empresa;


    public HorasSuplementariasPersonalBody() {
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
}
