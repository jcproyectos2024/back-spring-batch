package com.backSpringBatch.postgres.models.Acosux;

import javax.persistence.Column;
import java.io.Serializable;

public class RhRolMotivoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String motEmpresa;
	private String motDetalle;

	public RhRolMotivoPK() {
	}

	public RhRolMotivoPK(String motEmpresa, String motDetalle) {
		this.motEmpresa = motEmpresa;
		this.motDetalle = motDetalle;
	}

	@Column(name = "mot_empresa")
	public String getMotEmpresa() {
		return motEmpresa;
	}

	public void setMotEmpresa(String motEmpresa) {
		this.motEmpresa = motEmpresa;
	}

	@Column(name = "mot_detalle")
	public String getMotDetalle() {
		return motDetalle;
	}

	public void setMotDetalle(String motDetalle) {
		this.motDetalle = motDetalle;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (motEmpresa != null ? motEmpresa.hashCode() : 0);
		hash += (motDetalle != null ? motDetalle.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof RhRolMotivoPK)) {
			return false;
		}
		RhRolMotivoPK other = (RhRolMotivoPK) object;
		if ((this.motEmpresa == null && other.motEmpresa != null)
				|| (this.motEmpresa != null && !this.motEmpresa.equals(other.motEmpresa))) {
			return false;
		}
		if ((this.motDetalle == null && other.motDetalle != null)
				|| (this.motDetalle != null && !this.motDetalle.equals(other.motDetalle))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "rrhh.entity.RhAnticipoMotivoPK[ motEmpresa=" + motEmpresa + ", motDetalle=" + motDetalle + " ]";
	}
}
