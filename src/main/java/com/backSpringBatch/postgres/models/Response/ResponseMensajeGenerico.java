package com.backSpringBatch.postgres.models.Response;

public class ResponseMensajeGenerico {
	
	private Boolean success;
	private String mensaje;
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

	
	
}
