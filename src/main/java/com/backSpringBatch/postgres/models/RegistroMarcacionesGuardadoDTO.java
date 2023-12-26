package com.backSpringBatch.postgres.models;

import com.backSpringBatch.dto.BiometricoDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RegistroMarcacionesGuardadoDTO
{

    private  String asisId;
    private  String empresa;
    private  String identificacion;
    private String nombres;
    private String apellidos;
    @JsonProperty("fecha")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date asisFecha;
    private  String hora;
    private String usuario;
    private String usuarioModificacion;
    private BiometricoDto biometrico;
    private String observacion;
    private String fechaHHmmss;

    public RegistroMarcacionesGuardadoDTO() {
    }

    public String getAsisId() {
        return asisId;
    }

    public void setAsisId(String asisId) {
        this.asisId = asisId;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getAsisFecha() {
        return asisFecha;
    }

    public void setAsisFecha(Date asisFecha) {
        this.asisFecha = asisFecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public BiometricoDto getBiometrico() {
        return biometrico;
    }

    public void setBiometrico(BiometricoDto biometrico) {
        this.biometrico = biometrico;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getFechaHHmmss() {
        return fechaHHmmss;
    }

    public void setFechaHHmmss(String fechaHHmmss) {
        this.fechaHHmmss = fechaHHmmss;
    }
}
