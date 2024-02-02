package com.backSpringBatch.postgres.models;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link com.backSpringBatch.postgres.entity.MantenimientoFeriado} entity
 */
@Data
public class MantenimientoFeriadoDto implements Serializable {
    private final Long idMantenimientoFeriado;
    private final String feriado;
    private final Instant fechaInicio;
    private final Instant fechaFin;
    private final BigDecimal porcentaje;
    private final Boolean estado;
}