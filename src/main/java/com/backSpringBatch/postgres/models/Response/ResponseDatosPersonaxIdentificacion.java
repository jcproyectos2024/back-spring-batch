package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.models.PeriodoxPersonalDTO;

import java.util.List;

public class ResponseDatosPersonaxIdentificacion {
	

	private String identificacion;
	private String nombres;
	private String area;
	private String cargo;
	private List<PeriodoxPersonalDTO> lsPeriodosActivos;

	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public ResponseDatosPersonaxIdentificacion(String identificacion, String nombres, String area, String cargo
			, List<PeriodoxPersonalDTO> lsPeriodosActivos) {
		super();
		this.identificacion=identificacion;
		this.nombres = nombres;
		this.area = area;
		this.cargo = cargo;
		this.lsPeriodosActivos=lsPeriodosActivos;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	public List<PeriodoxPersonalDTO> getLsPeriodosActivos() {
		return lsPeriodosActivos;
	}
	public void setLsPeriodosActivos(List<PeriodoxPersonalDTO> lsPeriodosActivos) {
		this.lsPeriodosActivos = lsPeriodosActivos;
	}
	

	

}
