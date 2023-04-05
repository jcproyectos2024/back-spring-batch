package com.backSpringBatch.postgres.mapper;


import com.backSpringBatch.postgres.entity.Atrasos;
import com.backSpringBatch.postgres.models.AsistNowDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AtrasosMapper {

    List<AsistNowDTO> toAsistNowDTOToAtrasos(List<Atrasos> all);


}
