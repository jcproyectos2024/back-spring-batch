package com.backSpringBatch.postgres.mapper;

import com.backSpringBatch.postgres.entity.MantenimientoFeriado;
import com.backSpringBatch.postgres.models.MantenimientoFeriadoDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MantenimientoFeriadoMapper {
    MantenimientoFeriado mantenimientoFeriadoDtoToMantenimientoFeriado(MantenimientoFeriadoDto mantenimientoFeriadoDto);

    MantenimientoFeriadoDto mantenimientoFeriadoToMantenimientoFeriadoDto(MantenimientoFeriado mantenimientoFeriado);

    List<MantenimientoFeriadoDto> toMantenimientoFeriadoDtoList(List<MantenimientoFeriado> masterEtnicaList);

    List<MantenimientoFeriado> toMantenimientoFeriadoList(List<MantenimientoFeriadoDto> masterEtnicaDtoList);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MantenimientoFeriado updateMantenimientoFeriadoFromMantenimientoFeriadoDto(MantenimientoFeriadoDto mantenimientoFeriadoDto, @MappingTarget MantenimientoFeriado mantenimientoFeriado);
}
