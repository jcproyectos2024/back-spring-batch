package com.backSpringBatch.postgres.models.Acosux;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SisPeriodoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String perEmpresa;
	private String perCodigo;

	public SisPeriodoPK() {
	}

	public SisPeriodoPK(String perEmpresa, String perCodigo) {
		this.perEmpresa = perEmpresa;
		this.perCodigo = perCodigo;
	}

	@Column(name = "per_empresa")
	public String getPerEmpresa() {
		return perEmpresa;
	}

	public void setPerEmpresa(String perEmpresa) {
		this.perEmpresa = perEmpresa;
	}

	@Column(name = "per_codigo")
	public String getPerCodigo() {
		return perCodigo;
	}

	public void setPerCodigo(String perCodigo) {
		this.perCodigo = perCodigo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (perEmpresa != null ? perEmpresa.hashCode() : 0);
		hash += (perCodigo != null ? perCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof SisPeriodoPK)) {
			return false;
		}
		SisPeriodoPK other = (SisPeriodoPK) object;
		if ((this.perEmpresa == null && other.perEmpresa != null)
				|| (this.perEmpresa != null && !this.perEmpresa.equals(other.perEmpresa))) {
			return false;
		}
		if ((this.perCodigo == null && other.perCodigo != null)
				|| (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "sistemaWeb.entity.SisPeriodoPK[ perEmpresa=" + perEmpresa + ", perCodigo=" + perCodigo + " ]";
	}

}
