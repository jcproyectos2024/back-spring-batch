package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.models.VacacionesPersonalDTO;

public class ResponseVacacionesxRegistro {
	
	private boolean success;
	private VacacionesPersonalDTO vacacionesDto;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public VacacionesPersonalDTO getVacacionesDto() {
		return vacacionesDto;
	}
	public void setVacacionesDto(VacacionesPersonalDTO vacacionesDto) {
		this.vacacionesDto = vacacionesDto;
	}

	
	
	

}
