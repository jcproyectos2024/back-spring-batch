package com.backSpringBatch.postgres.models.search;

public class SearchFunctionDTO {

    private int page;
    private int reg_por_pag;


    private String nameFunction;


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

    public String getNameFunction() {
        return nameFunction;
    }

    public void setNameFunction(String nameFunction) {
        this.nameFunction = nameFunction;
    }


}
