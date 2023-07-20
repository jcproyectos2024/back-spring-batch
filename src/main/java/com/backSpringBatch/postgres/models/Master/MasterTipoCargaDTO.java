package com.backSpringBatch.postgres.models.Master;

public class MasterTipoCargaDTO {

    private Long id;

    private String tipoDeCarga;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }
}
