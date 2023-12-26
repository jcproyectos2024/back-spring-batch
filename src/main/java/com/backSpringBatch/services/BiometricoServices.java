package com.backSpringBatch.services;

import com.backSpringBatch.dto.BiometricoDto;
import com.backSpringBatch.postgres.mapper.BiometricoMapper;
import com.backSpringBatch.postgres.models.BiometricoResponse;
import com.backSpringBatch.postgres.repository.BiometricoRepository;
import com.diosmar.GenericExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiometricoServices
{
    @Autowired
    BiometricoRepository biometricoRepository;
    @Autowired
    BiometricoMapper biometricoMapper;

    public BiometricoResponse findAllByBiometrico()
    {
        BiometricoResponse response = new BiometricoResponse();
        try
        {
            biometricoRepository.findAllBy().ifPresentOrElse(biometricoList ->
            {
                List<BiometricoDto> biometricoDtoList = biometricoMapper.biometricoToBiometricoDto(biometricoList);
                response.setBiometricoDtoList(biometricoDtoList);
                response.setMessage("Consulta Existosa");
                response.setSuccess(true);
            }, () -> {
                response.setMessage("No se encotraron Datos");
                response.setSuccess(false);
            });

        }catch (Exception ex)
        {
            ex.printStackTrace();
            response.setMessage("Error de Servidor");
            response.setSuccess(false);
            // return response;
            throw new GenericExceptionUtils(ex);

        }
        return response;
    }

}
