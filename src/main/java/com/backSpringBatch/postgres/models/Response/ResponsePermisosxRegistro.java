package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.models.PermisosPersonalDTO;

public class ResponsePermisosxRegistro {
	
	private boolean success;
	private PermisosPersonalDTO personalDto;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public PermisosPersonalDTO getPersonalDto() {
		return personalDto;
	}
	public void setPersonalDto(PermisosPersonalDTO personalDto) {
		this.personalDto = personalDto;
	}
	
	

}
