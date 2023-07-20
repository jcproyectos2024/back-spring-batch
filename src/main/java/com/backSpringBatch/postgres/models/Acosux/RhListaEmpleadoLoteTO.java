package com.backSpringBatch.postgres.models.Acosux;

import java.io.Serializable;
import java.math.BigDecimal;

public class RhListaEmpleadoLoteTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String prEmpresa;
    private String prCategoria;
    private String prSector;
    private String prPiscina;
    private String prId;
    private String prNombres;
    private String prCargo;
    private BigDecimal prSueldo;
    private BigDecimal prSaldoAnterior;
    private BigDecimal prSaldoAnticipos;
    private BigDecimal prSaldoBonos;
    private BigDecimal prSaldoPrestamos;
    private BigDecimal prDescuentoPrestamos;
    private BigDecimal prSaldoHorasExtras50;
    private BigDecimal prSaldoHorasExtras100;
    private BigDecimal prSaldoHorasExtrasExtraordinarias100;
    private int prSaldoCuotas;
    private String prFechaIngreso;
    private String prFechaUltimoSueldo;
    private BigDecimal prValor;
    private BigDecimal prBonoFijo;
    private BigDecimal prBonoFijoNd;
    private BigDecimal prOtrosIngresos;
    private BigDecimal prOtrosIngresosNd;
    private Boolean prAfiliado;
    private BigDecimal prPrestamoQuirografario;
    private BigDecimal prPrestamoHipotecario;
    private String prBanco;
    private String prEcCodigo;

    private  BigDecimal ctaRecargoJornadaNocturna;

    public RhListaEmpleadoLoteTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrEmpresa() {
        return prEmpresa;
    }

    public void setPrEmpresa(String prEmpresa) {
        this.prEmpresa = prEmpresa;
    }

    public String getPrCategoria() {
        return prCategoria;
    }

    public void setPrCategoria(String prCategoria) {
        this.prCategoria = prCategoria;
    }

    public String getPrSector() {
        return prSector;
    }

    public void setPrSector(String prSector) {
        this.prSector = prSector;
    }

    public String getPrPiscina() {
        return prPiscina;
    }

    public void setPrPiscina(String prPiscina) {
        this.prPiscina = prPiscina;
    }

    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    public String getPrNombres() {
        return prNombres;
    }

    public void setPrNombres(String prNombres) {
        this.prNombres = prNombres;
    }

    public String getPrCargo() {
        return prCargo;
    }

    public void setPrCargo(String prCargo) {
        this.prCargo = prCargo;
    }

    public BigDecimal getPrSueldo() {
        return prSueldo;
    }

    public void setPrSueldo(BigDecimal prSueldo) {
        this.prSueldo = prSueldo;
    }

    public BigDecimal getPrSaldoAnterior() {
        return prSaldoAnterior;
    }

    public void setPrSaldoAnterior(BigDecimal prSaldoAnterior) {
        this.prSaldoAnterior = prSaldoAnterior;
    }

    public BigDecimal getPrSaldoAnticipos() {
        return prSaldoAnticipos;
    }

    public void setPrSaldoAnticipos(BigDecimal prSaldoAnticipos) {
        this.prSaldoAnticipos = prSaldoAnticipos;
    }

    public BigDecimal getPrSaldoBonos() {
        return prSaldoBonos;
    }

    public void setPrSaldoBonos(BigDecimal prSaldoBonos) {
        this.prSaldoBonos = prSaldoBonos;
    }

    public BigDecimal getPrSaldoPrestamos() {
        return prSaldoPrestamos;
    }

    public void setPrSaldoPrestamos(BigDecimal prSaldoPrestamos) {
        this.prSaldoPrestamos = prSaldoPrestamos;
    }

    public BigDecimal getPrDescuentoPrestamos() {
        return prDescuentoPrestamos;
    }

    public void setPrDescuentoPrestamos(BigDecimal prDescuentoPrestamos) {
        this.prDescuentoPrestamos = prDescuentoPrestamos;
    }

    public BigDecimal getPrSaldoHorasExtras50() {
        return prSaldoHorasExtras50;
    }

    public void setPrSaldoHorasExtras50(BigDecimal prSaldoHorasExtras50) {
        this.prSaldoHorasExtras50 = prSaldoHorasExtras50;
    }

    public BigDecimal getPrSaldoHorasExtras100() {
        return prSaldoHorasExtras100;
    }

    public void setPrSaldoHorasExtras100(BigDecimal prSaldoHorasExtras100) {
        this.prSaldoHorasExtras100 = prSaldoHorasExtras100;
    }

    public BigDecimal getPrSaldoHorasExtrasExtraordinarias100() {
        return prSaldoHorasExtrasExtraordinarias100;
    }

    public void setPrSaldoHorasExtrasExtraordinarias100(BigDecimal prSaldoHorasExtrasExtraordinarias100) {
        this.prSaldoHorasExtrasExtraordinarias100 = prSaldoHorasExtrasExtraordinarias100;
    }

    public int getPrSaldoCuotas() {
        return prSaldoCuotas;
    }

    public void setPrSaldoCuotas(int prSaldoCuotas) {
        this.prSaldoCuotas = prSaldoCuotas;
    }


    public String getPrFechaIngreso() {
        return prFechaIngreso;
    }

    public void setPrFechaIngreso(String prFechaIngreso) {
        this.prFechaIngreso = prFechaIngreso;
    }

    public String getPrFechaUltimoSueldo() {
        return prFechaUltimoSueldo;
    }

    public void setPrFechaUltimoSueldo(String prFechaUltimoSueldo) {
        this.prFechaUltimoSueldo = prFechaUltimoSueldo;
    }

    public BigDecimal getPrValor() {
        return prValor;
    }

    public void setPrValor(BigDecimal prValor) {
        this.prValor = prValor;
    }

    public BigDecimal getPrBonoFijo() {
        return prBonoFijo;
    }

    public void setPrBonoFijo(BigDecimal prBonoFijo) {
        this.prBonoFijo = prBonoFijo;
    }

    public BigDecimal getPrBonoFijoNd() {
        return prBonoFijoNd;
    }

    public void setPrBonoFijoNd(BigDecimal prBonoFijoNd) {
        this.prBonoFijoNd = prBonoFijoNd;
    }

    public BigDecimal getPrOtrosIngresos() {
        return prOtrosIngresos;
    }

    public void setPrOtrosIngresos(BigDecimal prOtrosIngresos) {
        this.prOtrosIngresos = prOtrosIngresos;
    }

    public BigDecimal getPrOtrosIngresosNd() {
        return prOtrosIngresosNd;
    }

    public void setPrOtrosIngresosNd(BigDecimal prOtrosIngresosNd) {
        this.prOtrosIngresosNd = prOtrosIngresosNd;
    }

    public Boolean getPrAfiliado() {
        return prAfiliado;
    }

    public void setPrAfiliado(Boolean prAfiliado) {
        this.prAfiliado = prAfiliado;
    }

    public BigDecimal getPrPrestamoQuirografario() {
        return prPrestamoQuirografario;
    }

    public void setPrPrestamoQuirografario(BigDecimal prPrestamoQuirografario) {
        this.prPrestamoQuirografario = prPrestamoQuirografario;
    }

    public BigDecimal getPrPrestamoHipotecario() {
        return prPrestamoHipotecario;
    }

    public void setPrPrestamoHipotecario(BigDecimal prPrestamoHipotecario) {
        this.prPrestamoHipotecario = prPrestamoHipotecario;
    }

    public String getPrBanco() {
        return prBanco;
    }

    public void setPrBanco(String prBanco) {
        this.prBanco = prBanco;
    }

    public String getPrEcCodigo() {
        return prEcCodigo;
    }

    public void setPrEcCodigo(String prEcCodigo) {
        this.prEcCodigo = prEcCodigo;
    }

    public BigDecimal getCtaRecargoJornadaNocturna() {
        return ctaRecargoJornadaNocturna;
    }

    public void setCtaRecargoJornadaNocturna(BigDecimal ctaRecargoJornadaNocturna) {
        this.ctaRecargoJornadaNocturna = ctaRecargoJornadaNocturna;
    }
}
