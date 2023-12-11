package com.backSpringBatch.dto;

import com.backSpringBatch.postgres.entity.Biometrico;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Biometrico} entity
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BiometricoDto implements Serializable {
    private  Long id;
    private  String ipBiometrico;
    private  String tipoBiometrinco;
    private  String nombreBiometrico;

    public BiometricoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpBiometrico() {
        return ipBiometrico;
    }

    public void setIpBiometrico(String ipBiometrico) {
        this.ipBiometrico = ipBiometrico;
    }

    public String getTipoBiometrinco() {
        return tipoBiometrinco;
    }

    public void setTipoBiometrinco(String tipoBiometrinco) {
        this.tipoBiometrinco = tipoBiometrinco;
    }

    public String getNombreBiometrico() {
        return nombreBiometrico;
    }

    public void setNombreBiometrico(String nombreBiometrico) {
        this.nombreBiometrico = nombreBiometrico;
    }


}