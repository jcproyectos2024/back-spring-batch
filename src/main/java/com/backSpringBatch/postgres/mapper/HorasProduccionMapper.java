package com.backSpringBatch.postgres.mapper;



import com.backSpringBatch.postgres.entity.HorasProduccion;
import com.backSpringBatch.postgres.models.AsistNowDTO;
import com.backSpringBatch.postgres.models.HorasProduccionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HorasProduccionMapper {

    List<HorasProduccionDTO> toAsistNowDTOToHorasProduccion(List<HorasProduccion> all);


}
