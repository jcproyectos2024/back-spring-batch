/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.backSpringBatch.postgres.models.Acosux;

public class ListaBanCuentaTO implements java.io.Serializable {
	/**
	 * 
	 */
	// private Integer cuenSecuencia;
	// private String banCodigo;
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String banBanco;
	private String ctaNumero;
	private String ctaTitular;
	private String ctaOficial;
	private String ctaFormatoCheque;
	private String ctaCuentaContable;
	private String ctaCodigoBancario;
	private String ctaPrefijoBancario;
   	private String ctaNumeracion;

	public ListaBanCuentaTO() {
	}

	public ListaBanCuentaTO(String banBanco, String ctaNumero, String ctaTitular, String ctaOficial,
			String ctaFormatoCheque, String ctaCuentaContable, String ctaCodigoBancario, String ctaPrefijoBancario) {
		this.banBanco = banBanco;
		this.ctaNumero = ctaNumero;
		this.ctaTitular = ctaTitular;
		this.ctaOficial = ctaOficial;
		this.ctaFormatoCheque = ctaFormatoCheque;
		this.ctaCuentaContable = ctaCuentaContable;
		this.ctaCodigoBancario = ctaCodigoBancario;
		this.ctaPrefijoBancario = ctaPrefijoBancario;
	}
	
	public ListaBanCuentaTO(String banBanco, String ctaNumero, String ctaTitular, String ctaOficial,
			String ctaFormatoCheque, String ctaCuentaContable, String ctaCodigoBancario, String ctaPrefijoBancario, Integer id) {
		this.banBanco = banBanco;
		this.ctaNumero = ctaNumero;
		this.ctaTitular = ctaTitular;
		this.ctaOficial = ctaOficial;
		this.ctaFormatoCheque = ctaFormatoCheque;
		this.ctaCuentaContable = ctaCuentaContable;
		this.ctaCodigoBancario = ctaCodigoBancario;
		this.ctaPrefijoBancario = ctaPrefijoBancario;
		this.id = id;
	}
	
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBanBanco() {
		return banBanco;
	}

	public void setBanBanco(String banBanco) {
		this.banBanco = banBanco;
	}

	public String getCtaCodigoBancario() {
		return ctaCodigoBancario;
	}

	public void setCtaCodigoBancario(String ctaCodigoBancario) {
		this.ctaCodigoBancario = ctaCodigoBancario;
	}

	public String getCtaCuentaContable() {
		return ctaCuentaContable;
	}

	public void setCtaCuentaContable(String ctaCuentaContable) {
		this.ctaCuentaContable = ctaCuentaContable;
	}

	public String getCtaFormatoCheque() {
		return ctaFormatoCheque;
	}

	public void setCtaFormatoCheque(String ctaFormatoCheque) {
		this.ctaFormatoCheque = ctaFormatoCheque;
	}

	public String getCtaNumero() {
		return ctaNumero;
	}

	public void setCtaNumero(String ctaNumero) {
		this.ctaNumero = ctaNumero;
	}

	public String getCtaOficial() {
		return ctaOficial;
	}

	public void setCtaOficial(String ctaOficial) {
		this.ctaOficial = ctaOficial;
	}

	public String getCtaPrefijoBancario() {
		return ctaPrefijoBancario;
	}

	public void setCtaPrefijoBancario(String ctaPrefijoBancario) {
		this.ctaPrefijoBancario = ctaPrefijoBancario;
	}

	public String getCtaTitular() {
		return ctaTitular;
	}

	public void setCtaTitular(String ctaTitular) {
		this.ctaTitular = ctaTitular;
	}

        public String getCtaNumeracion() {
            return ctaNumeracion;
        }

        public void setCtaNumeracion(String ctaNumeracion) {
            this.ctaNumeracion = ctaNumeracion;
        }

	@Override
	public String toString() {
		return this.banBanco + " " + this.ctaNumero + " " + this.ctaTitular + " " + this.ctaOficial + " "
				+ this.ctaFormatoCheque + " " + this.ctaCuentaContable + " " + this.ctaCodigoBancario + " "
				+ this.ctaPrefijoBancario;
	}
}
