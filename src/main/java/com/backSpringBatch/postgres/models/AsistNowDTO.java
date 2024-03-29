package com.backSpringBatch.postgres.models;

import java.util.Date;

public class AsistNowDTO {


    private String asisId;

    private Date asisIng;

    private String asisZona;

    private String asisFecha;

    private String asisHora;
    
    private String horaIngreso;
    
    private String horaAlmuerzo;
    
    private String horaSalida;

    private String asisTipo;

//    private String asisRes;

    private  Boolean justificacion;

    private String atraso;


    public String getAsisId() {
        return asisId;
    }

    public void setAsisId(String asisId) {
        this.asisId = asisId;
    }


    public String getAsisZona() {
        return asisZona;
    }

    public void setAsisZona(String asisZona) {
        this.asisZona = asisZona;
    }

    public Date getAsisIng() {
        return asisIng;
    }

    public void setAsisIng(Date asisIng) {
        this.asisIng = asisIng;
    }

    public String getAsisFecha() {
        return asisFecha;
    }

    public void setAsisFecha(String asisFecha) {
        this.asisFecha = asisFecha;
    }

    public String getAsisHora() {
        return asisHora;
    }

    public void setAsisHora(String asisHora) {
        this.asisHora = asisHora;
    }

    public String getAsisTipo() {
        return asisTipo;
    }

    public void setAsisTipo(String asisTipo) {
        this.asisTipo = asisTipo;
    }
//
//    public String getAsisRes() {
//        return asisRes;
//    }
//
//    public void setAsisRes(String asisRes) {
//        this.asisRes = asisRes;
//    }
//

    public Boolean getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(Boolean justificacion) {
        this.justificacion = justificacion;
    }

    public String getAtraso() {
        return atraso;
    }

    public void setAtraso(String atraso) {
        this.atraso = atraso;
    }

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public String getHoraAlmuerzo() {
		return horaAlmuerzo;
	}

	public void setHoraAlmuerzo(String horaAlmuerzo) {
		this.horaAlmuerzo = horaAlmuerzo;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	
    
}
