package com.backSpringBatch.postgres.mapper;

import com.backSpringBatch.dto.RegistroMarcacionesDTO;
import com.backSpringBatch.postgres.entity.AsistNow;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RegistroMarcacionesMapper {
    AsistNow registroMarcacionesDTOToAsistNow(RegistroMarcacionesDTO registroMarcacionesDTO);

    RegistroMarcacionesDTO asistNowToRegistroMarcacionesDTO(AsistNow asistNow);

    List<RegistroMarcacionesDTO> toRegistroMarcacionesDTOList(List<AsistNow> asistNowtList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AsistNow updateAsistNowFromRegistroMarcacionesDTO(RegistroMarcacionesDTO registroMarcacionesDTO, @MappingTarget AsistNow asistNow);
}
