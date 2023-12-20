package com.backSpringBatch.postgres.mapper;

import com.backSpringBatch.dto.BiometricoDto;
import com.backSpringBatch.postgres.entity.Biometrico;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring")
public interface BiometricoMapper
{
        List<BiometricoDto> biometricoToBiometricoDto(List<Biometrico> all);
}
