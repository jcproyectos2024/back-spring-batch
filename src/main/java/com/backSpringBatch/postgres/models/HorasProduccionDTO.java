package com.backSpringBatch.postgres.models;

import java.util.Date;

public class HorasProduccionDTO {


    private String asisId;


    private String asisFecha;

    private String horasProd;

    public String getAsisId() {
        return asisId;
    }

    public void setAsisId(String asisId) {
        this.asisId = asisId;
    }

    public String getAsisFecha() {
        return asisFecha;
    }

    public void setAsisFecha(String asisFecha) {
        this.asisFecha = asisFecha;
    }

    public String getHorasProd() {
        return horasProd;
    }

    public void setHorasProd(String horasProd) {
        this.horasProd = horasProd;
    }
}
