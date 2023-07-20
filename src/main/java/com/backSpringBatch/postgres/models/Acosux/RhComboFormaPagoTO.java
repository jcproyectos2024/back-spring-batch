package com.backSpringBatch.postgres.models.Acosux;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RhComboFormaPagoTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fpDetalle;
	private String ctaCodigo;
	private Boolean validar;

	public RhComboFormaPagoTO() {
	}

	public RhComboFormaPagoTO(String fpDetalle, String ctaCodigo, Boolean validar) {
		this.fpDetalle = fpDetalle;
		this.ctaCodigo = ctaCodigo;
		this.validar = validar;
	}

	@Column(name = "cta_codigo")
	public String getCtaCodigo() {
		return ctaCodigo;
	}

	public void setCtaCodigo(String ctaCodigo) {
		this.ctaCodigo = ctaCodigo;
	}

	@Id
	@Column(name = "fp_detalle")
	public String getFpDetalle() {
		return fpDetalle;
	}

	public void setFpDetalle(String fpDetalle) {
		this.fpDetalle = fpDetalle;
	}

	// @Column(name = "validar")
	public Boolean getValidar() {
		return validar;
	}

	public void setValidar(Boolean validar) {
		this.validar = validar;
	}

	@Override
	public String toString() {
		return this.fpDetalle;
	}

}
