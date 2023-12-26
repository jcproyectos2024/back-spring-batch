package com.backSpringBatch.dto;

import com.backSpringBatch.postgres.entity.Biometrico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistroMarcacionesDTO implements Serializable
{
    private  Integer idRegistroMarcaciones;
    private  String asisId;
    private  String empresa;
    private  String identificacion;
    private String nombres;
    private String apellidos;

    private String  zona;
    @JsonProperty("fecha")
    @JsonFormat(pattern="yyyy-MM-dd")
    private  Date asisFecha;
    private  String horaEntrada;
    private  String horaSalida;
    private String usuario;
    private BiometricoDto biometrico;
    private BiometricoDto biometricoEntrada;
    private BiometricoDto biometricoSalida;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fechaEntradaHHmmss;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fechaSalidaHHmmss;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaEntrada;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaSalida;


    private String editado;

    private String observacion;

    public RegistroMarcacionesDTO() {
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

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
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

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getIdRegistroMarcaciones() {
        return idRegistroMarcaciones;
    }

    public void setIdRegistroMarcaciones(Integer idRegistroMarcaciones) {
        this.idRegistroMarcaciones = idRegistroMarcaciones;
    }

    public String getEditado() {
        return editado;
    }

    public void setEditado(String editado) {
        this.editado = editado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaEntradaHHmmss() {
        return fechaEntradaHHmmss;
    }

    public void setFechaEntradaHHmmss(Date fechaEntradaHHmmss) {
        this.fechaEntradaHHmmss = fechaEntradaHHmmss;
    }

    public Date getFechaSalidaHHmmss() {
        return fechaSalidaHHmmss;
    }

    public void setFechaSalidaHHmmss(Date fechaSalidaHHmmss) {
        this.fechaSalidaHHmmss = fechaSalidaHHmmss;
    }

    public BiometricoDto getBiometricoEntrada() {
        return biometricoEntrada;
    }

    public void setBiometricoEntrada(BiometricoDto biometricoEntrada) {
        this.biometricoEntrada = biometricoEntrada;
    }

    public BiometricoDto getBiometricoSalida() {
        return biometricoSalida;
    }

    public void setBiometricoSalida(BiometricoDto biometricoSalida) {
        this.biometricoSalida = biometricoSalida;
    }

}