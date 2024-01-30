package com.backSpringBatch.postgres.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name ="marcaciones_ingreso_salida", schema = "marcaciones")
public class MarcacionesIngresoSalida
{
    @EmbeddedId
    private IngresoSalidaPK id;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_salida")
    private Date fecheSalida;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "asis_fecha_entrada")
    private Date asisFechaEntrada;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "asis_fecha_salida")
    private Date asisFechaSalida;

    @Column(name = "asis_hora_entrada")
    private String asisHoraEntrada;

    @Column(name = "asis_hora_salida")
    private String asisHoraSalida;

    @Column(name = "asis_res")
    private String asisRes;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "nomina_nom")
    private String nombres;

    @Column(name = "nomina_ape")
    private String apellidos;

    @Column(name = "horas_trabajadas")
    private BigDecimal horasTrabajadas;

    @Column(name = "horas_final_normales")
    private String horasFinalNormales;


    @Column(name = "suplementarias_25")
    private Long suplementarias25;

    @Column(name = "suplementarias_100")
    private Long suplementarias100;
/*
    @Column(name = "suplementarias_50")
    private Long suplementarias50;*/


    @Column(name = "horas_extras")
    private Long horasExtras;

    @Column(name = "procesado")
    private  Boolean procesado;
    @Column(name = "horas_extras_procesada")
    private  Boolean horasExtrasProcesada;

    public MarcacionesIngresoSalida() {
    }

    public IngresoSalidaPK getId() {
        return id;
    }

    public void setId(IngresoSalidaPK id) {
        this.id = id;
    }

    public Date getFecheSalida() {
        return fecheSalida;
    }

    public void setFecheSalida(Date fecheSalida) {
        this.fecheSalida = fecheSalida;
    }

    public Date getAsisFechaEntrada() {
        return asisFechaEntrada;
    }

    public void setAsisFechaEntrada(Date asisFechaEntrada) {
        this.asisFechaEntrada = asisFechaEntrada;
    }

    public Date getAsisFechaSalida() {
        return asisFechaSalida;
    }

    public void setAsisFechaSalida(Date asisFechaSalida) {
        this.asisFechaSalida = asisFechaSalida;
    }

    public String getAsisHoraEntrada() {
        return asisHoraEntrada;
    }

    public void setAsisHoraEntrada(String asisHoraEntrada) {
        this.asisHoraEntrada = asisHoraEntrada;
    }

    public String getAsisHoraSalida() {
        return asisHoraSalida;
    }

    public void setAsisHoraSalida(String asisHoraSalida) {
        this.asisHoraSalida = asisHoraSalida;
    }

    public String getAsisRes() {
        return asisRes;
    }

    public void setAsisRes(String asisRes) {
        this.asisRes = asisRes;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public BigDecimal getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(BigDecimal horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getHorasFinalNormales() {
        return horasFinalNormales;
    }

    public void setHorasFinalNormales(String horasFinalNormales) {
        this.horasFinalNormales = horasFinalNormales;
    }

    public Long getSuplementarias25() {
        return suplementarias25;
    }

    public void setSuplementarias25(Long suplementarias25) {
        this.suplementarias25 = suplementarias25;
    }

    public Long getSuplementarias100() {
        return suplementarias100;
    }

    public void setSuplementarias100(Long suplementarias100) {
        this.suplementarias100 = suplementarias100;
    }
/*
    public Long getSuplementarias50() {
        return suplementarias50;
    }

    public void setSuplementarias50(Long suplementarias50) {
        this.suplementarias50 = suplementarias50;
    }*/

    public Long getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(Long horasExtras) {
        this.horasExtras = horasExtras;
    }

    public boolean isProcesado() {
        return procesado;
    }

    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }

    public boolean isHorasExtrasProcesada() {
        return horasExtrasProcesada;
    }

    public void setHorasExtrasProcesada(boolean horasExtrasProcesada) {
        this.horasExtrasProcesada = horasExtrasProcesada;
    }
}
