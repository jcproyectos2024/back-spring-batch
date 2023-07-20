package com.backSpringBatch.postgres.models.Reporte;



public class DetalleCargas {
	
	private String nombreCarga;
	private String cedulaCarga;
	private String fechaNacimiento;
	private String edadCarga;
	private String parentescoCarga;
	private String discapacidadCarga;


	public String getNombreCarga() {
		return nombreCarga;
	}

	public void setNombreCarga(String nombreCarga) {
		this.nombreCarga = nombreCarga;
	}

	public String getCedulaCarga() {
		return cedulaCarga;
	}

	public void setCedulaCarga(String cedulaCarga) {
		this.cedulaCarga = cedulaCarga;
	}

	public String getEdadCarga() {
		return edadCarga;
	}

	public void setEdadCarga(String edadCarga) {
		this.edadCarga = edadCarga;
	}

	public String getParentescoCarga() {
		return parentescoCarga;
	}

	public void setParentescoCarga(String parentescoCarga) {
		this.parentescoCarga = parentescoCarga;
	}

	public String getDiscapacidadCarga() {
		return discapacidadCarga;
	}

	public void setDiscapacidadCarga(String discapacidadCarga) {
		this.discapacidadCarga = discapacidadCarga;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
