package com.backSpringBatch.postgres.models.search;

public class SearchContractDTO {

    private int page;
    private int reg_por_pag;

    private Long idContract;
    private String nameContract;



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

    public String getNameContract() {
        return nameContract;
    }

    public void setNameContract(String nameContract) {
        this.nameContract = nameContract;
    }

    public Long getIdContract() {
        return idContract;
    }

    public void setIdContract(Long idContract) {
        this.idContract = idContract;
    }
}
