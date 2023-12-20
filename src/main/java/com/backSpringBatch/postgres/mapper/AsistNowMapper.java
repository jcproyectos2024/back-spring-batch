package com.backSpringBatch.postgres.mapper;

import com.backSpringBatch.postgres.entity.AsistNow;
import com.backSpringBatch.postgres.entity.AsistNowIdentificacionDto;
import com.backSpringBatch.postgres.entity.AsistNowRefactor;
import com.backSpringBatch.postgres.models.AsistNowDTO;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AsistNowMapper {

    List<AsistNowDTO> toAsistNowDTOToAsistNow(List<AsistNow> all);

    
    List<AsistNowDTO> asistNowDtoTOAsistNowRefactor(Page<AsistNowRefactor> all);
    List<AsistNowIdentificacionDto> asistNowIdentificacionDtoToAsistNow(List<AsistNow> all);

}
