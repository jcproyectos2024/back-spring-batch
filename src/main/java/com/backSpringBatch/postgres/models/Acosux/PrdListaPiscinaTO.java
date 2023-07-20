package com.backSpringBatch.postgres.models.Acosux;

import java.io.Serializable;
import java.math.BigDecimal;


public class PrdListaPiscinaTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal id;
    private String pisNumero;
    private String pisNombre;
    private BigDecimal pisHectareaje;
    private String ctaCostoDirecto;
    private String ctaCostoIndirecto;
    private String ctaCostoTransferencia;
    private String ctaCostoProductoTerminado;
    private Boolean pisActiva;
    private String pisSector;
    private String tipoEmpresa;
    private String tipoCodigo;
    private String grupoEmpresa;
    private String grupoCodigo;
    private String ctaCostoVenta;

    public PrdListaPiscinaTO() {
    }

    public PrdListaPiscinaTO(String pisNumero, String pisNombre, BigDecimal pisHectareaje, Boolean pisActiva,
            String pisSector) {

        this.pisNumero = pisNumero;
        this.pisNombre = pisNombre;
        this.pisHectareaje = pisHectareaje;
        this.pisActiva = pisActiva;
        this.pisSector = pisSector;
    }

    public PrdListaPiscinaTO(String grupoEmpresa , String pisSector ,String pisNumero) {
        this.pisNumero = pisNumero;
        this.pisSector = pisSector;
        this.grupoEmpresa = grupoEmpresa;
    }

    
    public PrdListaPiscinaTO(String pisNumero, String pisNombre, BigDecimal pisHectareaje, String ctaCostoDirecto,
            String ctaCostoIndirecto, String ctaCostoTransferencia, String ctaCostoProductoTerminado, Boolean pisActiva,
            String pisSector) {
        this.pisNumero = pisNumero;
        this.pisNombre = pisNombre;
        this.pisHectareaje = pisHectareaje;
        this.ctaCostoDirecto = ctaCostoDirecto;
        this.ctaCostoIndirecto = ctaCostoIndirecto;
        this.ctaCostoTransferencia = ctaCostoTransferencia;
        this.ctaCostoProductoTerminado = ctaCostoProductoTerminado;
        this.pisActiva = pisActiva;
        this.pisSector = pisSector;
    }

    public String getCtaCostoVenta() {
        return ctaCostoVenta;
    }

    public void setCtaCostoVenta(String ctaCostoVenta) {
        this.ctaCostoVenta = ctaCostoVenta;
    }

    public Boolean getPisActiva() {
        return pisActiva;
    }

    public void setPisActiva(Boolean pisActiva) {
        this.pisActiva = pisActiva;
    }

    public BigDecimal getPisHectareaje() {
        return pisHectareaje;
    }

    public void setPisHectareaje(BigDecimal pisHectareaje) {
        this.pisHectareaje = pisHectareaje;
    }

    public String getPisNombre() {
        return pisNombre;
    }

    public void setPisNombre(String pisNombre) {
        this.pisNombre = pisNombre;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
    }

    public String getPisSector() {
        return pisSector;
    }

    public void setPisSector(String pisSector) {
        this.pisSector = pisSector;
    }

    public String getCtaCostoDirecto() {
        return ctaCostoDirecto;
    }

    public void setCtaCostoDirecto(String ctaCostoDirecto) {
        this.ctaCostoDirecto = ctaCostoDirecto;
    }

    public String getCtaCostoIndirecto() {
        return ctaCostoIndirecto;
    }

    public void setCtaCostoIndirecto(String ctaCostoIndirecto) {
        this.ctaCostoIndirecto = ctaCostoIndirecto;
    }

    public String getCtaCostoTransferencia() {
        return ctaCostoTransferencia;
    }

    public void setCtaCostoTransferencia(String ctaCostoTransferencia) {
        this.ctaCostoTransferencia = ctaCostoTransferencia;
    }

    public String getCtaCostoProductoTerminado() {
        return ctaCostoProductoTerminado;
    }

    public void setCtaCostoProductoTerminado(String ctaCostoProductoTerminado) {
        this.ctaCostoProductoTerminado = ctaCostoProductoTerminado;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getTipoCodigo() {
        return tipoCodigo;
    }

    public void setTipoCodigo(String tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    @Override
    public String toString() {
        return this.pisNumero + " " + this.pisNombre;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getGrupoEmpresa() {
        return grupoEmpresa;
    }

    public void setGrupoEmpresa(String grupoEmpresa) {
        this.grupoEmpresa = grupoEmpresa;
    }

    public String getGrupoCodigo() {
        return grupoCodigo;
    }

    public void setGrupoCodigo(String grupoCodigo) {
        this.grupoCodigo = grupoCodigo;
    }

}
