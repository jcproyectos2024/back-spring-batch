package com.backSpringBatch.postgres.models.search;


public class SearchPersonProdMaquinaDTO {


    private String apellidosEmpleado;

    private Long idGroupsProd ;

    private Long idMaquina;

    private int page;
    private int reg_por_pag;


    public String getApellidosEmpleado() {
        return apellidosEmpleado;
    }

    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }

    public Long getIdGroupsProd() {
        return idGroupsProd;
    }

    public void setIdGroupsProd(Long idGroupsProd) {
        this.idGroupsProd = idGroupsProd;
    }

    public Long getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Long idMaquina) {
        this.idMaquina = idMaquina;
    }

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
}
