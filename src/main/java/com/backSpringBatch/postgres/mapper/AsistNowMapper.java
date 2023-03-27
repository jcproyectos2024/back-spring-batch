package com.backSpringBatch.postgres.mapper;

import com.backSpringBatch.postgres.entity.AsistNow;
import com.backSpringBatch.postgres.models.AsistNowDTO;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AsistNowMapper {

    List<AsistNowDTO> toAsistNowDTOToAsistNow(List<AsistNow> all);


}
