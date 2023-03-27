package com.backSpringBatch.sqlserver.mapper;

import com.backSpringBatch.postgres.entity.AsistNow;
import com.backSpringBatch.sqlserver.entity.AsistNowRegistro;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AsisRegistroMapper {


    List<AsistNow> toAsistNowToAsistNowRegistro(List<AsistNowRegistro> all);

    AsistNow asistNowRegistroToAsistNow(AsistNowRegistro registro);

}
