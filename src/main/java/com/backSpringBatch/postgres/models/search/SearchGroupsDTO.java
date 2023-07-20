package com.backSpringBatch.postgres.models.search;

public class SearchGroupsDTO {

    private int page;
    private int reg_por_pag;

    private String nameGroups;



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

    public String getNameGroups() {
        return nameGroups;
    }

    public void setNameGroups(String nameGroups) {
        this.nameGroups = nameGroups;
    }


}
