package com.backSpringBatch.postgres.models.Reporte;



public class DetalleReferencia {
	
	private String nombrReferenciaP;
	private String direccionReferencia;
	private String telefonoReferencia;


	public String getNombrReferenciaP() {
		return nombrReferenciaP;
	}

	public void setNombrReferenciaP(String nombrReferenciaP) {
		this.nombrReferenciaP = nombrReferenciaP;
	}

	public String getDireccionReferencia() {
		return direccionReferencia;
	}

	public void setDireccionReferencia(String direccionReferencia) {
		this.direccionReferencia = direccionReferencia;
	}

	public String getTelefonoReferencia() {
		return telefonoReferencia;
	}

	public void setTelefonoReferencia(String telefonoReferencia) {
		this.telefonoReferencia = telefonoReferencia;
	}
}
