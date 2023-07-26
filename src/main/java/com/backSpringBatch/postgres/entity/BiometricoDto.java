package com.backSpringBatch.postgres.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Biometrico} entity
 */
@Data
public class BiometricoDto implements Serializable {
    private final Long id;
    private final String ipBiometrico;
    private final String tipoBiometrinco;
    private final String nombreBiometrico;
}