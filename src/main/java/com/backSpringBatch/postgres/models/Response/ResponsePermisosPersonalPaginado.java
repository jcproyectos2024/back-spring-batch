package com.backSpringBatch.postgres.models.Response;

import com.backRRHH.models.PermisosPersonalDTO;

import java.util.List;
public class ResponsePermisosPersonalPaginado {
	
	private List<PermisosPersonalDTO> lsRegistros;
	private boolean success;
	private int totalRegistros;
	public List<PermisosPersonalDTO> getLsRegistros() {
		return lsRegistros;
	}
	public void setLsRegistros(List<PermisosPersonalDTO> lsRegistros) {
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
