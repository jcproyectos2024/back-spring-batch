package com.backSpringBatch.postgres.mapper;

import com.backSpringBatch.dto.HorasSuplementariasPersonalDto;
import com.backSpringBatch.postgres.entity.HorasSuplementariasPersonal;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface HorasSuplementariasPersonalMapper {
    HorasSuplementariasPersonal horasSuplementariasPersonalDtoToHorasSuplementariasPersonal(HorasSuplementariasPersonalDto horasSuplementariasPersonalDto);

    HorasSuplementariasPersonalDto horasSuplementariasPersonalToHorasSuplementariasPersonalDto(HorasSuplementariasPersonal horasSuplementariasPersonal);

    List<HorasSuplementariasPersonalDto> toHorasSuplementariasPersonalDtoList(List<HorasSuplementariasPersonal> horasSuplementariasPersonalList);

    List<HorasSuplementariasPersonal> toHorasSuplementariasPersonalList(List<HorasSuplementariasPersonalDto> horasSuplementariasPersonalDtoList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    HorasSuplementariasPersonal updateHorasSuplementariasPersonalFromHorasSuplementariasPersonalDto(HorasSuplementariasPersonalDto horasSuplementariasPersonalDto, @MappingTarget HorasSuplementariasPersonal horasSuplementariasPersonal);
}
