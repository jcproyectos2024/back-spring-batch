package com.backSpringBatch.postgres.models.Master;

public class MasterRangTurnsDTO {

    private Long id;

    private String desde;

    private String hasta;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }


}
