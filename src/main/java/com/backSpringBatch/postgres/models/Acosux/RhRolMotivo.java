package com.backSpringBatch.postgres.models.Acosux;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
import java.sql.Timestamp;



public class RhRolMotivo implements Serializable {
	private static final long serialVersionUID = 1L;

	protected RhRolMotivoPK rhRolMotivoPK;
	private boolean motInactivo;
        private boolean motRegistrarHoraExtra;
	private ConTipo conTipo;
	private String usrEmpresa;
	private String usrCodigo;
	private Timestamp usrFechaInserta;

	public RhRolMotivo() {
	}

	public RhRolMotivo(RhRolMotivoPK rhRolMotivoPK) {
		this.rhRolMotivoPK = rhRolMotivoPK;
	}

	public RhRolMotivo(RhRolMotivoPK rhRolMotivoPK, boolean motInactivo, ConTipo conTipo, String usrEmpresa,
			String usrCodigo, Timestamp usrFechaInserta) {
		this.rhRolMotivoPK = rhRolMotivoPK;
		this.motInactivo = motInactivo;
		this.conTipo = conTipo;
		this.usrEmpresa = usrEmpresa;
		this.usrCodigo = usrCodigo;
		this.usrFechaInserta = usrFechaInserta;
	}

	public RhRolMotivo(String motEmpresa, String motDetalle) {
		this.rhRolMotivoPK = new RhRolMotivoPK(motEmpresa, motDetalle);
	}

	@EmbeddedId
	public RhRolMotivoPK getRhRolMotivoPK() {
		return rhRolMotivoPK;
	}

	public void setRhRolMotivoPK(RhRolMotivoPK rhRolMotivoPK) {
		this.rhRolMotivoPK = rhRolMotivoPK;
	}

	@Column(name = "mot_inactivo")
	public boolean getMotInactivo() {
		return motInactivo;
	}

	public void setMotInactivo(boolean motInactivo) {
		this.motInactivo = motInactivo;
	}

	public ConTipo getConTipo() {
		return conTipo;
	}

	public void setConTipo(ConTipo conTipo) {
		this.conTipo = conTipo;
	}

	@Column(name = "usr_empresa")
	public String getUsrEmpresa() {
		return usrEmpresa;
	}

	public void setUsrEmpresa(String usrEmpresa) {
		this.usrEmpresa = usrEmpresa;
	}

	@Column(name = "usr_codigo")
	public String getUsrCodigo() {
		return usrCodigo;
	}

	public void setUsrCodigo(String usrCodigo) {
		this.usrCodigo = usrCodigo;
	}

	@Column(name = "usr_fecha_inserta", insertable = false, updatable = false)
	public Timestamp getUsrFechaInserta() {
		return usrFechaInserta;
	}

	public void setUsrFechaInserta(Timestamp usrFechaInserta) {
		this.usrFechaInserta = usrFechaInserta;
	}

        @Column(name = "mot_registrar_hora_extra")
        public boolean isMotRegistrarHoraExtra() {
            return motRegistrarHoraExtra;
        }

        public void setMotRegistrarHoraExtra(boolean motRegistrarHoraExtra) {
            this.motRegistrarHoraExtra = motRegistrarHoraExtra;
        }

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (rhRolMotivoPK != null ? rhRolMotivoPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof RhRolMotivo)) {
			return false;
		}
		RhRolMotivo other = (RhRolMotivo) object;
		if ((this.rhRolMotivoPK == null && other.rhRolMotivoPK != null)
				|| (this.rhRolMotivoPK != null && !this.rhRolMotivoPK.equals(other.rhRolMotivoPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "rrhh.entity.RhRolMotivo[ rhRolMotivoPK=" + rhRolMotivoPK + " ]";
	}
}
