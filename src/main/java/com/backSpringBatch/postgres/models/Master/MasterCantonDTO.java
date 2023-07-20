package com.backSpringBatch.postgres.models.Master;

public class MasterCantonDTO {

    private Long id;

    private String canton;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }
}
