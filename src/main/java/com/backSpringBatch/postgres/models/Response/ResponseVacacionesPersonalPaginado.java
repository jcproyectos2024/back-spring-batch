package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.models.VacacionesPersonalDTO;

import java.util.List;
public class ResponseVacacionesPersonalPaginado {
	
	private List<VacacionesPersonalDTO> lsRegistros;
	private boolean success;
	private int totalRegistros;
	public List<VacacionesPersonalDTO> getLsRegistros() {
		return lsRegistros;
	}
	public void setLsRegistros(List<VacacionesPersonalDTO> lsRegistros) {
		this.lsRegistros = lsRegistros;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	
	

}
