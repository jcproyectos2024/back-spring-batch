package com.backSpringBatch.postgres.models.Acosux;

import java.io.Serializable;


/**
 *
 * @author Carlos Ajila
 */

public class PrdListaSectorTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String secCodigo;
    private String nomSector;
    private String secLatitud;
    private String secLongitud;
    private Boolean secActivo;
    private String secDireccion;
    private String secTelefono;
    private String secActividad;
    private String secIntegracionCon;
    private String secArea;

    public PrdListaSectorTO() {
    }

    public PrdListaSectorTO(String secCodigo, String nomSector, String secLatitud, String secLongitud,
            Boolean secActivo) {
        this.secCodigo = secCodigo;
        this.nomSector = nomSector;
        this.secLatitud = secLatitud;
        this.secLongitud = secLongitud;
        this.secActivo = secActivo;
    }

    public Boolean getSecActivo() {
        return secActivo;
    }

    public void setSecActivo(Boolean secActivo) {
        this.secActivo = secActivo;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getSecLatitud() {
        return secLatitud;
    }

    public void setSecLatitud(String secLatitud) {
        this.secLatitud = secLatitud;
    }

    public String getSecLongitud() {
        return secLongitud;
    }

    public void setSecLongitud(String secLongitud) {
        this.secLongitud = secLongitud;
    }

    public String getSecNombre() {
        return nomSector;
    }

    public void setSecNombre(String nomSector) {
        this.nomSector = nomSector;
    }

    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    public String getSecDireccion() {
        return secDireccion;
    }

    public void setSecDireccion(String secDireccion) {
        this.secDireccion = secDireccion;
    }

    public String getSecTelefono() {
        return secTelefono;
    }

    public void setSecTelefono(String secTelefono) {
        this.secTelefono = secTelefono;
    }

    public String getSecActividad() {
        return secActividad;
    }

    public void setSecActividad(String secActividad) {
        this.secActividad = secActividad;
    }

    public String getSecIntegracionCon() {
        return secIntegracionCon;
    }

    public void setSecIntegracionCon(String secIntegracionCon) {
        this.secIntegracionCon = secIntegracionCon;
    }

    public String getSecArea() {
        return secArea;
    }

    public void setSecArea(String secArea) {
        this.secArea = secArea;
    }

    @Override
    public String toString() {
        return this.secCodigo + " " + this.nomSector;
    }



}
