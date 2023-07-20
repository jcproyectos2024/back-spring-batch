package com.backSpringBatch.postgres.models.search;

public class SearchScheduleDTO {

    private int page;
    private int reg_por_pag;

    private Long  idScheule;
    private String nameSchedule;



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

    public Long getIdScheule() {
        return idScheule;
    }

    public void setIdScheule(Long idScheule) {
        this.idScheule = idScheule;
    }

    public String getNameSchedule() {
        return nameSchedule;


    }

    public void setNameSchedule(String nameSchedule) {
        this.nameSchedule = nameSchedule;
    }
}
