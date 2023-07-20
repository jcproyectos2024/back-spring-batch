package com.backSpringBatch.postgres.models.search;

public class SearchTurnsDTO {

    private int page;
    private int reg_por_pag;
    private Long idTurns;
    private String nameTurns;


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

    public Long getIdTurns() {
        return idTurns;
    }

    public void setIdTurns(Long idTurns) {
        this.idTurns = idTurns;
    }

    public String getNameTurns() {
        return nameTurns;
    }

    public void setNameTurns(String nameTurns) {
        this.nameTurns = nameTurns;
    }


}
