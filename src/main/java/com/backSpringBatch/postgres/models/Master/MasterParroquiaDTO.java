package com.backSpringBatch.postgres.models.Master;

public class MasterParroquiaDTO {

    private Long id;

    private String parroquia;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }
}
