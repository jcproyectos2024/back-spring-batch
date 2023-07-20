package com.backSpringBatch.postgres.models.Acosux;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class RhListaEmpleadoLoteTOResponse implements Serializable {

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
    private Date prFechaIngreso;
    private Date prFechaUltimoSueldo;
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

    public RhListaEmpleadoLoteTOResponse() {
    }

    public RhListaEmpleadoLoteTOResponse(String prCategoria, String prSector, String prId, String prNombres, String prCargo,
            BigDecimal prSueldo, BigDecimal prValor, Boolean prAfiliado, Integer id) {
        this.prCategoria = prCategoria;
        this.prSector = prSector;
        this.prId = prId;
        this.prNombres = prNombres;
        this.prCargo = prCargo;
        this.prSueldo = prSueldo;
        this.prValor = prValor;
        this.prAfiliado = prAfiliado;
        this.id = id;
    }

    public RhListaEmpleadoLoteTOResponse(Integer id, String prEmpresa, String prCategoria, String prSector, String prId,
            String prNombres, String prCargo, BigDecimal prSueldo, BigDecimal prSaldoAnterior,
            BigDecimal prSaldoAnticipos, BigDecimal prSaldoBonos, BigDecimal prSaldoPrestamos, int prSaldoCuotas,
            Date prFechaIngreso, Date prFechaUltimoSueldo, BigDecimal prValor, Boolean prAfiliado) {
        this.id = id;
        this.prEmpresa = prEmpresa;
        this.prCategoria = prCategoria;
        this.prSector = prSector;
        this.prId = prId;
        this.prNombres = prNombres;
        this.prCargo = prCargo;
        this.prSueldo = prSueldo;
        this.prSaldoAnterior = prSaldoAnterior;
        this.prSaldoAnticipos = prSaldoAnticipos;
        this.prSaldoBonos = prSaldoBonos;
        this.prSaldoPrestamos = prSaldoPrestamos;
        this.prSaldoCuotas = prSaldoCuotas;
        this.prFechaIngreso = prFechaIngreso;
        this.prFechaUltimoSueldo = prFechaUltimoSueldo;
        this.prValor = prValor;
        this.prAfiliado = prAfiliado;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "pr_afiliado")
    public Boolean getPrAfiliado() {
        return prAfiliado;
    }

    public void setPrAfiliado(Boolean prAfiliado) {
        this.prAfiliado = prAfiliado;
    }

    @Column(name = "pr_cargo")
    public String getPrCargo() {
        return prCargo;
    }

    public void setPrCargo(String prCargo) {
        this.prCargo = prCargo;
    }

    @Column(name = "pr_categoria")
    public String getPrCategoria() {
        return prCategoria;
    }

    public void setPrCategoria(String prCategoria) {
        this.prCategoria = prCategoria;
    }

    @Column(name = "pr_id")
    public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId;
    }

    @Column(name = "pr_nombres")
    public String getPrNombres() {
        return prNombres;
    }

    public void setPrNombres(String prNombres) {
        this.prNombres = prNombres;
    }

    @Column(name = "pr_sector")
    public String getPrSector() {
        return prSector;
    }

    public void setPrSector(String prSector) {
        this.prSector = prSector;
    }
    
    @Column(name = "pr_piscina")
    public String getPrPiscina() {
        return prPiscina;
    }

    public void setPrPiscina(String prPiscina) {
        this.prPiscina = prPiscina;
    }

    @Column(name = "pr_sueldo")
    public BigDecimal getPrSueldo() {
        return prSueldo;
    }

    public void setPrSueldo(BigDecimal prSueldo) {
        this.prSueldo = prSueldo;
    }

    @Column(name = "pr_saldo_anticipos")
    public BigDecimal getPrSaldoAnticipos() {
        return prSaldoAnticipos;
    }

    public void setPrSaldoAnticipos(BigDecimal prSaldoAnticipos) {
        this.prSaldoAnticipos = prSaldoAnticipos;
    }

    @Column(name = "pr_saldo_bonos")
    public BigDecimal getPrSaldoBonos() {
        return prSaldoBonos;
    }

    public void setPrSaldoBonos(BigDecimal prSaldoBonos) {
        this.prSaldoBonos = prSaldoBonos;
    }

    @Column(name = "pr_saldo_prestamos")
    public BigDecimal getPrSaldoPrestamos() {
        return prSaldoPrestamos;
    }

    public void setPrSaldoPrestamos(BigDecimal prSaldoPrestamos) {
        this.prSaldoPrestamos = prSaldoPrestamos;
    }

    @Column(name = "pr_saldo_cuotas")
    public int getPrSaldoCuotas() {
        return prSaldoCuotas;
    }

    public void setPrSaldoCuotas(int prSaldoCuotas) {
        this.prSaldoCuotas = prSaldoCuotas;
    }

    @Column(name = "pr_fecha_ultimo_sueldo")
    public Date getPrFechaUltimoSueldo() {
        return prFechaUltimoSueldo;
    }

    public void setPrFechaUltimoSueldo(Date prFechaUltimoSueldo) {
        this.prFechaUltimoSueldo = prFechaUltimoSueldo;
    }

    @Column(name = "pr_valor")
    public BigDecimal getPrValor() {
        return prValor;
    }

    public void setPrValor(BigDecimal prValor) {
        this.prValor = prValor;
    }

    @Column(name = "pr_empresa")
    public String getPrEmpresa() {
        return prEmpresa;
    }

    public void setPrEmpresa(String prEmpresa) {
        this.prEmpresa = prEmpresa;
    }

    @Column(name = "pr_saldo_anterior")
    public BigDecimal getPrSaldoAnterior() {
        return prSaldoAnterior;
    }

    public void setPrSaldoAnterior(BigDecimal prSaldoAnterior) {
        this.prSaldoAnterior = prSaldoAnterior;
    }

    @Column(name = "pr_fecha_ingreso")
    public Date getPrFechaIngreso() {
        return prFechaIngreso;
    }

    public void setPrFechaIngreso(Date prFechaIngreso) {
        this.prFechaIngreso = prFechaIngreso;
    }

    @Column(name = "pr_saldo_horas_extras_50")
    public BigDecimal getPrSaldoHorasExtras50() {
        return prSaldoHorasExtras50;
    }

    public void setPrSaldoHorasExtras50(BigDecimal prSaldoHorasExtras50) {
        this.prSaldoHorasExtras50 = prSaldoHorasExtras50;
    }

    @Column(name = "pr_saldo_horas_extras_100")
    public BigDecimal getPrSaldoHorasExtras100() {
        return prSaldoHorasExtras100;
    }

    public void setPrSaldoHorasExtras100(BigDecimal prSaldoHorasExtras100) {
        this.prSaldoHorasExtras100 = prSaldoHorasExtras100;
    }

    @Column(name = "pr_saldo_horas_extras_extraordinarias_100")
    public BigDecimal getPrSaldoHorasExtrasExtraordinarias100() {
        return prSaldoHorasExtrasExtraordinarias100;
    }

    public void setPrSaldoHorasExtrasExtraordinarias100(BigDecimal prSaldoHorasExtrasExtraordinarias100) {
        this.prSaldoHorasExtrasExtraordinarias100 = prSaldoHorasExtrasExtraordinarias100;
    }

    @Column(name = "pr_bono_fijo")
    public BigDecimal getPrBonoFijo() {
        return prBonoFijo;
    }

    public void setPrBonoFijo(BigDecimal prBonoFijo) {
        this.prBonoFijo = prBonoFijo;
    }

    @Column(name = "pr_bono_fijo_nd")
    public BigDecimal getPrBonoFijoNd() {
        return prBonoFijoNd;
    }

    public void setPrBonoFijoNd(BigDecimal prBonoFijoNd) {
        this.prBonoFijoNd = prBonoFijoNd;
    }

    @Column(name = "pr_otros_ingresos")
    public BigDecimal getPrOtrosIngresos() {
        return prOtrosIngresos;
    }

    public void setPrOtrosIngresos(BigDecimal prOtrosIngresos) {
        this.prOtrosIngresos = prOtrosIngresos;
    }

    @Column(name = "pr_otros_ingresos_nd")
    public BigDecimal getPrOtrosIngresosNd() {
        return prOtrosIngresosNd;
    }

    public void setPrOtrosIngresosNd(BigDecimal prOtrosIngresosNd) {
        this.prOtrosIngresosNd = prOtrosIngresosNd;
    }

    @Column(name = "pr_descuento_prestamos")
    public BigDecimal getPrDescuentoPrestamos() {
        return prDescuentoPrestamos;
    }

    public void setPrDescuentoPrestamos(BigDecimal prDescuentoPrestamos) {
        this.prDescuentoPrestamos = prDescuentoPrestamos;
    }

    @Column(name = "pr_prestamo_quirografario")
    public BigDecimal getPrPrestamoQuirografario() {
        return prPrestamoQuirografario;
    }

    public void setPrPrestamoQuirografario(BigDecimal prPrestamoQuirografario) {
        this.prPrestamoQuirografario = prPrestamoQuirografario;
    }

    @Column(name = "pr_prestamo_hipotecario")
    public BigDecimal getPrPrestamoHipotecario() {
        return prPrestamoHipotecario;
    }

    public void setPrPrestamoHipotecario(BigDecimal prPrestamoHipotecario) {
        this.prPrestamoHipotecario = prPrestamoHipotecario;
    }

    @Column(name = "pr_banco")
    public String getPrBanco() {
        return prBanco;
    }

    public void setPrBanco(String prBanco) {
        this.prBanco = prBanco;
    }

  

     @Column(name = "pr_ec_codigo")
    public String getPrEcCodigo() {
        return prEcCodigo;
    }

    public void setPrEcCodigo(String prEcCodigo) {
        this.prEcCodigo = prEcCodigo;
    }
    
    

}
