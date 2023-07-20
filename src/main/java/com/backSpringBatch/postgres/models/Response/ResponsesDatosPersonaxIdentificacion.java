package com.backSpringBatch.postgres.models.Response;

import java.util.List;

public class ResponsesDatosPersonaxIdentificacion {
	
	private String mensaje;
	private Boolean success;
	private int totalRegistros;
	private List<ResponseDatosPersonaxIdentificacion> lsDatos;
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<ResponseDatosPersonaxIdentificacion> getLsDatos() {
		return lsDatos;
	}
	public void setLsDatos(List<ResponseDatosPersonaxIdentificacion> lsDatos) {
		this.lsDatos = lsDatos;
	}
	public ResponsesDatosPersonaxIdentificacion(String mensaje, Boolean success,
			List<ResponseDatosPersonaxIdentificacion> lsDatos) {
		super();
		this.mensaje = mensaje;
		this.success = success;
		this.lsDatos = lsDatos;
	}
	public ResponsesDatosPersonaxIdentificacion() {
		super();
	}
	public int getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	
	
	
	
	

}
