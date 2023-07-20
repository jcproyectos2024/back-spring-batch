package com.backSpringBatch.postgres.models.Master;

public class MasterFormaDePagoDTO {

    private Long id;

    private String FormaDePago;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormaDePago() {
        return FormaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        FormaDePago = formaDePago;
    }
}
