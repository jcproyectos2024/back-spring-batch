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

    @Column(name = "horas")
    private  Long horas;
    
    @Column(name = "porcentaje")
    private  Double porcentaje;


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

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public HorasSuplementariasPersonal() {
		this.horas=0L;
		this.estado=true;
		
		//super();
	}

	
	

   

}
