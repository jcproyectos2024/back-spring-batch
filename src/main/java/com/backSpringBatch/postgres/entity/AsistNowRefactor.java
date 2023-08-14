package com.backSpringBatch.postgres.entity;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="asistnow_refactor", schema = "marcaciones")
public class AsistNowRefactor {


    @EmbeddedId
    private AsistnowPK id;

    @Column(name = "asis_fecha")
    private Date asisFecha;

    @Column(name = "asis_hora")
    private String asisHora;

    @Column(name = "asis_tipo")
    private String asisTipo;

    @Column(name = "asis_res")
    private String asisRes;

    @Column (name = "nomina_cod")
    private String identificacion;

    @Column (name = "hora_ingreso")
    private String horaIngreso;
    
    @Column (name = "hora_almuerzo")
    private String horaAlmuerzo;
    
    @Column (name = "hora_salida")
    private String horaSalida;

    public AsistnowPK getId() {
        return id;
    }

    public void setId(AsistnowPK id) {
        this.id = id;
    }

    public Date getAsisFecha() {
        return asisFecha;
    }

    public void setAsisFecha(Date asisFecha) {
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

    public String getAsisRes() {
        return asisRes;
    }

    public void setAsisRes(String asisRes) {
        this.asisRes = asisRes;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

	public AsistNowRefactor(AsistnowPK id, Date asisFecha, String asisHora, String asisTipo, String asisRes,
			String identificacion, String horaIngreso, String horaAlmuerzo, String horaSalida) {
		super();
		this.id = id;
		this.asisFecha = asisFecha;
		this.asisHora = asisHora;
		this.asisTipo = asisTipo;
		this.asisRes = asisRes;
		this.identificacion = identificacion;
		this.horaIngreso = horaIngreso;
		this.horaAlmuerzo = horaAlmuerzo;
		this.horaSalida = horaSalida;
	}

	public AsistNowRefactor() {
		super();
	}
	
	
}



