package com.backSpringBatch.postgres.models.Acosux;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SisUsuarioDetallePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "det_empresa")
	private String detEmpresa;
	@Column(name = "det_usuario")
	private String detUsuario;

	public SisUsuarioDetallePK() {
	}

	public SisUsuarioDetallePK(String detEmpresa, String detUsuario) {
		this.detEmpresa = detEmpresa;
		this.detUsuario = detUsuario;
	}

	public String getDetEmpresa() {
		return detEmpresa;
	}

	public void setDetEmpresa(String detEmpresa) {
		this.detEmpresa = detEmpresa;
	}

	public String getDetUsuario() {
		return detUsuario;
	}

	public void setDetUsuario(String detUsuario) {
		this.detUsuario = detUsuario;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (detEmpresa != null ? detEmpresa.hashCode() : 0);
		hash += (detUsuario != null ? detUsuario.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof SisUsuarioDetallePK)) {
			return false;
		}
		SisUsuarioDetallePK other = (SisUsuarioDetallePK) object;
		if ((this.detEmpresa == null && other.detEmpresa != null)
				|| (this.detEmpresa != null && !this.detEmpresa.equals(other.detEmpresa))) {
			return false;
		}
		if ((this.detUsuario == null && other.detUsuario != null)
				|| (this.detUsuario != null && !this.detUsuario.equals(other.detUsuario))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "sistemaWeb.entity.SisUsuarioDetallePK[ detEmpresa=" + detEmpresa + ", detUsuario=" + detUsuario + " ]";
	}

}
