package com.backSpringBatch.postgres.entity;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name ="politicas_horas_suple", schema = "marcaciones")

public class PoliticasHorasSuple {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "rango_hora_inicial")
    private String rangoHoraInicial;
    
    @Column(name = "rango_hora_final")
    private String rangoHoraFinal;

    @Column(name = "porcentaje")
    private Double porcentaje;
    
    @Column(name = "estado")
    private Boolean estado;
    
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    
    @Column(name = "fecha_creacion")
    private Timestamp fechaCreacion;
    
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    
    @Column(name = "fecha_modificacion")
    private Timestamp fechaModificacion;
	@Column(name = "tipo")
	private String tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRangoHoraInicial() {
		return rangoHoraInicial;
	}

	public void setRangoHoraInicial(String rangoHoraInicial) {
		this.rangoHoraInicial = rangoHoraInicial;
	}

	public String getRangoHoraFinal() {
		return rangoHoraFinal;
	}

	public void setRangoHoraFinal(String rangoHoraFinal) {
		this.rangoHoraFinal = rangoHoraFinal;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
