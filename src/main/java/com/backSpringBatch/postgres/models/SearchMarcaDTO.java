package com.backSpringBatch.postgres.models;

public class SearchMarcaDTO {

    private int page;
    private int reg_por_pag;

    private String  idAsistNow;




    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getReg_por_pag() {
        return reg_por_pag;
    }

    public void setReg_por_pag(int reg_por_pag) {
        this.reg_por_pag = reg_por_pag;
    }

    public String getIdAsistNow() {
        return idAsistNow;
    }

    public void setIdAsistNow(String idAsistNow) {
        this.idAsistNow = idAsistNow;
    }
}
