package com.backSpringBatch.postgres.models.Reporte;



public class DetalleAcademico {
	
	private String nomInst;
	private String educacion;
	private String titulo;
	private String fechaTermino;
	private String ciudadFormAca;


	public String getNomInst() {
		return nomInst;
	}

	public void setNomInst(String nomInst) {
		this.nomInst = nomInst;
	}

	public String getEducacion() {
		return educacion;
	}

	public void setEducacion(String educacion) {
		this.educacion = educacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public String getCiudadFormAca() {
		return ciudadFormAca;
	}

	public void setCiudadFormAca(String ciudadFormAca) {
		this.ciudadFormAca = ciudadFormAca;
	}
}
