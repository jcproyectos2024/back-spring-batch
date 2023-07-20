package com.backSpringBatch.postgres.models.Acosux;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

public class SisPeriodo implements Serializable {
	private static final long serialVersionUID = 1L;

	protected SisPeriodoPK sisPeriodoPK;
	private String perDetalle;
	private Date perDesde;
	private Date perHasta;
	private boolean perCerrado;
	private String usrCodigo;
	private Date usrFechaInsertaPeriodo;
	private SisEmpresa empCodigo;

	public SisPeriodo() {
	}

	public SisPeriodo(SisPeriodoPK sisPeriodoPK) {
		this.sisPeriodoPK = sisPeriodoPK;
	}

	public SisPeriodo(SisPeriodoPK sisPeriodoPK, String perDetalle, Date perDesde, Date perHasta, boolean perCerrado,
			String usrCodigo, Date usrFechaInsertaPeriodo) {
		this.sisPeriodoPK = sisPeriodoPK;
		this.perDetalle = perDetalle;
		this.perDesde = perDesde;
		this.perHasta = perHasta;
		this.perCerrado = perCerrado;
		this.usrCodigo = usrCodigo;
		this.usrFechaInsertaPeriodo = usrFechaInsertaPeriodo;
	}

	public SisPeriodo(String perEmpresa, String perCodigo) {
		this.sisPeriodoPK = new SisPeriodoPK(perEmpresa, perCodigo);
	}

	@EmbeddedId
	public SisPeriodoPK getSisPeriodoPK() {
		return sisPeriodoPK;
	}

	public void setSisPeriodoPK(SisPeriodoPK sisPeriodoPK) {
		this.sisPeriodoPK = sisPeriodoPK;
	}

	@Column(name = "per_detalle")
	public String getPerDetalle() {
		return perDetalle;
	}

	public void setPerDetalle(String perDetalle) {
		this.perDetalle = perDetalle;
	}

	@Column(name = "per_desde")
	public Date getPerDesde() {
		return perDesde;
	}

	public void setPerDesde(Date perDesde) {
		this.perDesde = perDesde;
	}

	@Column(name = "per_hasta")
	public Date getPerHasta() {
		return perHasta;
	}

	public void setPerHasta(Date perHasta) {
		this.perHasta = perHasta;
	}

	@Column(name = "per_cerrado")
	public boolean getPerCerrado() {
		return perCerrado;
	}

	public void setPerCerrado(boolean perCerrado) {
		this.perCerrado = perCerrado;
	}

	@Column(name = "usr_codigo")
	public String getUsrCodigo() {
		return usrCodigo;
	}

	public void setUsrCodigo(String usrCodigo) {
		this.usrCodigo = usrCodigo;
	}

	@Column(name = "usr_fecha_inserta_periodo")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUsrFechaInsertaPeriodo() {
		return usrFechaInsertaPeriodo;
	}

	public void setUsrFechaInsertaPeriodo(Date usrFechaInsertaPeriodo) {
		this.usrFechaInsertaPeriodo = usrFechaInsertaPeriodo;
	}

	public SisEmpresa getEmpCodigo() {
		return empCodigo;
	}

	public void setEmpCodigo(SisEmpresa empCodigo) {
		this.empCodigo = empCodigo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (sisPeriodoPK != null ? sisPeriodoPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof SisPeriodo)) {
			return false;
		}
		SisPeriodo other = (SisPeriodo) object;
		if ((this.sisPeriodoPK == null && other.sisPeriodoPK != null)
				|| (this.sisPeriodoPK != null && !this.sisPeriodoPK.equals(other.sisPeriodoPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "sistemaWeb.entity.SisPeriodo[ sisPeriodoPK=" + sisPeriodoPK + " ]";
	}

}
