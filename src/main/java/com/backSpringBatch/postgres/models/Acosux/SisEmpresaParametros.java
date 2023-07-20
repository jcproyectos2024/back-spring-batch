package com.backSpringBatch.postgres.models.Acosux;

import java.io.Serializable;


public class SisEmpresaParametros implements Serializable {

    private static final long serialVersionUID = 1L;

  
    private String parEmpresa;
    private String parGerente;
    private Character parGerenteTipoId;
    private String parGerenteId;
    private String parContador;
    private String parContadorRuc;
    private String parFinanciero;
    private String parFinancieroId;
    private String parActividad;
    private String parEscogerPrecioPor;
    private boolean parObligadoLlevarContabilidad;
    private String parResolucionContribuyenteEspecial;
    private short parColumnasEstadosFinancieros;
    private String parCodigoDinardap;
    private String parWebDocumentosElectronicos;
    private boolean parObligadoEmitirDocumentosElectronicos;
    private boolean parObligadoRegistrarLiquidacionPesca;
    private boolean parObligadoAprobarPagos;
                                      
    private SisEmpresa empCodigo;
    private String parRutaReportes;
    private String parRutaLogo;
    private boolean isExportadora;
    private String parTextoAgrupacion;
    private boolean parContribuyenteRegimenMicroempresa;
    private String parAgenteRetencion;
    private String parRutaImagen;
    private boolean parVentasEnProceso;
    private boolean parDocumentosRecibidosEnProceso;
    private String parTokenWispro;
    private boolean parFacturasEnProceso;
    private String parDominio;
    private boolean parObligadoAprobarAnticipos;
    private boolean parPagosEnProceso;

    public SisEmpresaParametros() {
    }

    public SisEmpresaParametros(String parEmpresa) {
        this.parEmpresa = parEmpresa;
    }

    public SisEmpresaParametros(String parEmpresa, String parActividad, String parEscogerPrecioPor,
            boolean parObligadoLlevarContabilidad, String parResolucionContribuyenteEspecial,
            short parColumnasEstadosFinancieros) {
        this.parEmpresa = parEmpresa;
        this.parActividad = parActividad;
        this.parEscogerPrecioPor = parEscogerPrecioPor;
        this.parObligadoLlevarContabilidad = parObligadoLlevarContabilidad;
        this.parResolucionContribuyenteEspecial = parResolucionContribuyenteEspecial;
        this.parColumnasEstadosFinancieros = parColumnasEstadosFinancieros;
    }

    public String getParEmpresa() {
        return parEmpresa;
    }

    public void setParEmpresa(String parEmpresa) {
        this.parEmpresa = parEmpresa;
    }

    public String getParGerente() {
        return parGerente;
    }

    public void setParGerente(String parGerente) {
        this.parGerente = parGerente;
    }

    public Character getParGerenteTipoId() {
        return parGerenteTipoId;
    }

    public void setParGerenteTipoId(Character parGerenteTipoId) {
        this.parGerenteTipoId = parGerenteTipoId;
    }

    public String getParGerenteId() {
        return parGerenteId;
    }

    public void setParGerenteId(String parGerenteId) {
        this.parGerenteId = parGerenteId;
    }

    public String getParContador() {
        return parContador;
    }

    public void setParContador(String parContador) {
        this.parContador = parContador;
    }

    public String getParContadorRuc() {
        return parContadorRuc;
    }

    public void setParContadorRuc(String parContadorRuc) {
        this.parContadorRuc = parContadorRuc;
    }

    public String getParFinanciero() {
        return parFinanciero;
    }

    public void setParFinanciero(String parFinanciero) {
        this.parFinanciero = parFinanciero;
    }

    public String getParFinancieroId() {
        return parFinancieroId;
    }

    public void setParFinancieroId(String parFinancieroId) {
        this.parFinancieroId = parFinancieroId;
    }

    public String getParActividad() {
        return parActividad;
    }

    public void setParActividad(String parActividad) {
        this.parActividad = parActividad;
    }

    public String getParEscogerPrecioPor() {
        return parEscogerPrecioPor;
    }

    public void setParEscogerPrecioPor(String parEscogerPrecioPor) {
        this.parEscogerPrecioPor = parEscogerPrecioPor;
    }

    public boolean getParObligadoLlevarContabilidad() {
        return parObligadoLlevarContabilidad;
    }

    public void setParObligadoLlevarContabilidad(boolean parObligadoLlevarContabilidad) {
        this.parObligadoLlevarContabilidad = parObligadoLlevarContabilidad;
    }

    public String getParResolucionContribuyenteEspecial() {
        return parResolucionContribuyenteEspecial;
    }

    public void setParResolucionContribuyenteEspecial(String parResolucionContribuyenteEspecial) {
        this.parResolucionContribuyenteEspecial = parResolucionContribuyenteEspecial;
    }

    public short getParColumnasEstadosFinancieros() {
        return parColumnasEstadosFinancieros;
    }

    public void setParColumnasEstadosFinancieros(short parColumnasEstadosFinancieros) {
        this.parColumnasEstadosFinancieros = parColumnasEstadosFinancieros;
    }

    public String getParCodigoDinardap() {
        return parCodigoDinardap;
    }

    public void setParCodigoDinardap(String parCodigoDinardap) {
        this.parCodigoDinardap = parCodigoDinardap;
    }

    public String getParWebDocumentosElectronicos() {
        return parWebDocumentosElectronicos;
    }

    public void setParWebDocumentosElectronicos(String parWebDocumentosElectronicos) {
        this.parWebDocumentosElectronicos = parWebDocumentosElectronicos;
    }

    public boolean isParObligadoEmitirDocumentosElectronicos() {
        return parObligadoEmitirDocumentosElectronicos;
    }

    public void setParObligadoEmitirDocumentosElectronicos(boolean parObligadoEmitirDocumentosElectronicos) {
        this.parObligadoEmitirDocumentosElectronicos = parObligadoEmitirDocumentosElectronicos;
    }

    public boolean isParObligadoRegistrarLiquidacionPesca() {
        return parObligadoRegistrarLiquidacionPesca;
    }

    public void setParObligadoRegistrarLiquidacionPesca(boolean parObligadoRegistrarLiquidacionPesca) {
        this.parObligadoRegistrarLiquidacionPesca = parObligadoRegistrarLiquidacionPesca;
    }

    public boolean isParObligadoAprobarPagos() {
        return parObligadoAprobarPagos;
    }

    public void setParObligadoAprobarPagos(boolean parObligadoAprobarPagos) {
        this.parObligadoAprobarPagos = parObligadoAprobarPagos;
    }

    public SisEmpresa getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(SisEmpresa empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getParRutaReportes() {
        return parRutaReportes;
    }

    public void setParRutaReportes(String parRutaReportes) {
        this.parRutaReportes = parRutaReportes;
    }

    public String getParRutaLogo() {
        return parRutaLogo;
    }

    public void setParRutaLogo(String parRutaLogo) {
        this.parRutaLogo = parRutaLogo;
    }

    public boolean isIsExportadora() {
        return isExportadora;
    }

    public void setIsExportadora(boolean isExportadora) {
        this.isExportadora = isExportadora;
    }

    public String getParTextoAgrupacion() {
        return parTextoAgrupacion;
    }

    public void setParTextoAgrupacion(String parTextoAgrupacion) {
        this.parTextoAgrupacion = parTextoAgrupacion;
    }

    public boolean isParContribuyenteRegimenMicroempresa() {
        return parContribuyenteRegimenMicroempresa;
    }

    public void setParContribuyenteRegimenMicroempresa(boolean parContribuyenteRegimenMicroempresa) {
        this.parContribuyenteRegimenMicroempresa = parContribuyenteRegimenMicroempresa;
    }

    public String getParAgenteRetencion() {
        return parAgenteRetencion;
    }

    public void setParAgenteRetencion(String parAgenteRetencion) {
        this.parAgenteRetencion = parAgenteRetencion;
    }

    public String getParRutaImagen() {
        return parRutaImagen;
    }

    public void setParRutaImagen(String parRutaImagen) {
        this.parRutaImagen = parRutaImagen;
    }

    public boolean isParVentasEnProceso() {
        return parVentasEnProceso;
    }

    public void setParVentasEnProceso(boolean parVentasEnProceso) {
        this.parVentasEnProceso = parVentasEnProceso;
    }

    public boolean isParDocumentosRecibidosEnProceso() {
        return parDocumentosRecibidosEnProceso;
    }

    public void setParDocumentosRecibidosEnProceso(boolean parDocumentosRecibidosEnProceso) {
        this.parDocumentosRecibidosEnProceso = parDocumentosRecibidosEnProceso;
    }

    public String getParTokenWispro() {
        return parTokenWispro;
    }

    public void setParTokenWispro(String parTokenWispro) {
        this.parTokenWispro = parTokenWispro;
    }

    public boolean isParFacturasEnProceso() {
        return parFacturasEnProceso;
    }

    public void setParFacturasEnProceso(boolean parFacturasEnProceso) {
        this.parFacturasEnProceso = parFacturasEnProceso;
    }

    public String getParDominio() {
        return parDominio;
    }

    public void setParDominio(String parDominio) {
        this.parDominio = parDominio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parEmpresa != null ? parEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SisEmpresaParametros)) {
            return false;
        }
        SisEmpresaParametros other = (SisEmpresaParametros) object;
        if ((this.parEmpresa == null && other.parEmpresa != null)
                || (this.parEmpresa != null && !this.parEmpresa.equals(other.parEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistemaWeb.entity.SisEmpresaParametros[ parEmpresa=" + parEmpresa + " ]";
    }

    public boolean isParObligadoAprobarAnticipos() {
        return parObligadoAprobarAnticipos;
    }

    public void setParObligadoAprobarAnticipos(boolean parObligadoAprobarAnticipos) {
        this.parObligadoAprobarAnticipos = parObligadoAprobarAnticipos;
    }

    public boolean isParPagosEnProceso() {
        return parPagosEnProceso;
    }

    public void setParPagosEnProceso(boolean parPagosEnProceso) {
        this.parPagosEnProceso = parPagosEnProceso;
    }

}
