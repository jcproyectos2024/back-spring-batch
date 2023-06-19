package com.backSpringBatch.postgres.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;


@Entity
@Table(name ="horas_suplementarias_personal", schema = "public")
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

    @Column(name = "horas_25")
    private  Long horas25;
    
    @Column(name = "horas_50")
    private  Long horas50;
    
    @Column(name = "horas_100")
    private  Long horas_100;

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

	public Long getHoras25() {
		return horas25;
	}

	public void setHoras25(Long horas25) {
		this.horas25 = horas25;
	}

	public Long getHoras50() {
		return horas50;
	}

	public void setHoras50(Long horas50) {
		this.horas50 = horas50;
	}

	public Long getHoras_100() {
		return horas_100;
	}

	public void setHoras_100(Long horas_100) {
		this.horas_100 = horas_100;
	}

   

}
