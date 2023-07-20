package com.backSpringBatch.postgres.models.Master;

public class MasterNacionalidadDTO {

    private Long id;

    private String nacionalidad;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
