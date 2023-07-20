package com.backSpringBatch.postgres.models.Master;

public class MasterTipoDeCtaDTO {

    private Long id;

    private String tipoDeCta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDeCta() {
        return tipoDeCta;
    }

    public void setTipoDeCta(String tipoDeCta) {
        this.tipoDeCta = tipoDeCta;
    }
}
