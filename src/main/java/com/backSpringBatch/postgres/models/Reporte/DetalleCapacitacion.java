package com.backSpringBatch.postgres.models.Reporte;



public class DetalleCapacitacion {
	
	private String curso;
	private String duracion;
	private String lugar;
	private String instituto;
	private String fechaCapacitation;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public String getFechaCapacitation() {
		return fechaCapacitation;
	}

	public void setFechaCapacitation(String fechaCapacitation) {
		this.fechaCapacitation = fechaCapacitation;
	}
}
