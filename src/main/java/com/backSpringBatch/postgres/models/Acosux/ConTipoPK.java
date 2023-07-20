package com.backSpringBatch.postgres.models.Acosux;

import javax.persistence.Column;
import java.io.Serializable;

public class ConTipoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tipEmpresa;
	private String tipCodigo;

	public ConTipoPK() {
	}

	public ConTipoPK(String tipEmpresa, String tipCodigo) {
		this.tipEmpresa = tipEmpresa;
		this.tipCodigo = tipCodigo;
	}

	@Column(name = "tip_empresa")
	public String getTipEmpresa() {
		return tipEmpresa;
	}

	public void setTipEmpresa(String tipEmpresa) {
		this.tipEmpresa = tipEmpresa;
	}

	@Column(name = "tip_codigo")
	public String getTipCodigo() {
		return tipCodigo;
	}

	public void setTipCodigo(String tipCodigo) {
		this.tipCodigo = tipCodigo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (tipEmpresa != null ? tipEmpresa.hashCode() : 0);
		hash += (tipCodigo != null ? tipCodigo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof ConTipoPK)) {
			return false;
		}
		ConTipoPK other = (ConTipoPK) object;
		if ((this.tipEmpresa == null && other.tipEmpresa != null)
				|| (this.tipEmpresa != null && !this.tipEmpresa.equals(other.tipEmpresa))) {
			return false;
		}
		if ((this.tipCodigo == null && other.tipCodigo != null)
				|| (this.tipCodigo != null && !this.tipCodigo.equals(other.tipCodigo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "contabilidad.entity.ConTipoPK[ tipEmpresa=" + tipEmpresa + ", tipCodigo=" + tipCodigo + " ]";
	}

}
