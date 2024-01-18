package com.backSpringBatch.postgres.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;


@Entity
@Table(name ="horas_suplementarias_personal", schema = "marcaciones")
public class HorasSuplementariasPersonal {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nullable
    private Long id;

    @Column(name = "identificacion")
    private  String identificacion;
    
    @Column(name = "tipo")//anticipo o mensual
    private  String tipo;
    
    @Column(name = "estado")
    private  Boolean estado;

    @Column(name = "horas")
    private  Long horas;
    
    @Column(name = "porcentaje")
    private  BigDecimal porcentaje=ZERO;

	@Column(name = "periodo")
	private  String periodo;
	@Column(name = "saldo_horas")
	private BigDecimal saldoHorasExtras = ZERO;

	@Column(name = "horas_sueldo_anterior")
	private  Long horasSueldoAnterior=0L;

	@Column(name = "saldo_horas_sueldo_anterior")
	private BigDecimal saldoHorasExtrasSueldoAnterior = ZERO;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Long getHoras() {
		return horas;
	}

	public void setHoras(Long horas) {
		this.horas = horas;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	public HorasSuplementariasPersonal() {
		this.horas=0L;
		this.estado=true;
		
		//super();
	}


	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public BigDecimal getSaldoHorasExtras() {
		return saldoHorasExtras;
	}

	public void setSaldoHorasExtras(BigDecimal saldoHorasExtras) {
		this.saldoHorasExtras = saldoHorasExtras;
	}

	public Long getHorasSueldoAnterior() {
		return horasSueldoAnterior;
	}

	public void setHorasSueldoAnterior(Long horasSueldoAnterior) {
		this.horasSueldoAnterior = horasSueldoAnterior;
	}

	public BigDecimal getSaldoHorasExtrasSueldoAnterior() {
		return saldoHorasExtrasSueldoAnterior;
	}

	public void setSaldoHorasExtrasSueldoAnterior(BigDecimal saldoHorasExtrasSueldoAnterior) {
		this.saldoHorasExtrasSueldoAnterior = saldoHorasExtrasSueldoAnterior;
	}
}
