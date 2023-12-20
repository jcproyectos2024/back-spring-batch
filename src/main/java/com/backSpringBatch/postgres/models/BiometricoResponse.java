package com.backSpringBatch.postgres.models;

import com.backSpringBatch.dto.BiometricoDto;

import java.util.List;

public class BiometricoResponse
{
    private List<BiometricoDto>  biometricoDtoList;
    private String message;
    private boolean success;

    public BiometricoResponse() {
    }

    public List<BiometricoDto> getBiometricoDtoList() {
        return biometricoDtoList;
    }

    public void setBiometricoDtoList(List<BiometricoDto> biometricoDtoList) {
        this.biometricoDtoList = biometricoDtoList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
