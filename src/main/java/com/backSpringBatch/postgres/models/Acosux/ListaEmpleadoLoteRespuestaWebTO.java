package com.backSpringBatch.postgres.models.Acosux;

import java.util.List;

public class ListaEmpleadoLoteRespuestaWebTO
{


    private  String  estadoOperacion;
    private  String operacionMensaje;

    private List<RhListaEmpleadoLoteTO> extraInfo;


    public ListaEmpleadoLoteRespuestaWebTO() {
    }

    public String getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(String estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    public String getOperacionMensaje() {
        return operacionMensaje;
    }

    public void setOperacionMensaje(String operacionMensaje) {
        this.operacionMensaje = operacionMensaje;
    }

    public List<RhListaEmpleadoLoteTO> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(List<RhListaEmpleadoLoteTO> extraInfo) {
        this.extraInfo = extraInfo;
    }
}
