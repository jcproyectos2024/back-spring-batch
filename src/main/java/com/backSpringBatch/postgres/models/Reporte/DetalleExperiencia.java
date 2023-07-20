package com.backSpringBatch.postgres.models.Reporte;



public class DetalleExperiencia {
	
	private String nombreEmpresa;
	private String fIngreso;
	private String fSalida;
	private String cargoExLabo;
	private String sueldo;
	private String motivo;

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getfIngreso() {
		return fIngreso;
	}

	public void setfIngreso(String fIngreso) {
		this.fIngreso = fIngreso;
	}

	public String getfSalida() {
		return fSalida;
	}

	public void setfSalida(String fSalida) {
		this.fSalida = fSalida;
	}

	public String getCargoExLabo() {
		return cargoExLabo;
	}

	public void setCargoExLabo(String cargoExLabo) {
		this.cargoExLabo = cargoExLabo;
	}

	public String getSueldo() {
		return sueldo;
	}

	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
