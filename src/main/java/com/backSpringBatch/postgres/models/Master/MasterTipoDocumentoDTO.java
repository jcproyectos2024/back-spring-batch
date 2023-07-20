package com.backSpringBatch.postgres.models.Master;

public class MasterTipoDocumentoDTO {

    private Long idTipo;

    private String nameTipo;

    private String tipo;

    private Boolean status;

    private Boolean tipoReporte;

    private String fileName;

    private String extension;


    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public String getNameTipo() {
        return nameTipo;
    }

    public void setNameTipo(String nameTipo) {
        this.nameTipo = nameTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(Boolean tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
