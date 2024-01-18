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
    @Autowired
    RESTServices restServices;

    public BiometricoResponse findAllByBiometrico()
    {
        BiometricoResponse response = new BiometricoResponse();
        try
        {
            biometricoRepository.findAllBy().ifPresentOrElse(biometricoList ->
            {
                BiometricoDto  biometricoDtoIngreso= new BiometricoDto();
                biometricoDtoIngreso.setId(8L);
                biometricoDtoIngreso.setIpBiometrico(restServices.parametrizacionRecursosHumanos("ipBiometricoFahdi"));
                biometricoDtoIngreso.setTipoBiometrinco("INGRESO");
                biometricoDtoIngreso.setNombreBiometrico("GARITA");
                biometricoDtoIngreso.setEmpresa("GD08");
                biometricoDtoIngreso.setEmpresaNombre("FAHDI SA");

                BiometricoDto  biometricoDtoSalida= new BiometricoDto();
                biometricoDtoSalida.setId(9L);
                biometricoDtoSalida.setIpBiometrico(restServices.parametrizacionRecursosHumanos("ipBiometricoFahdi"));
                biometricoDtoSalida.setTipoBiometrinco("SALIDA");
                biometricoDtoSalida.setNombreBiometrico("GARITA");
                biometricoDtoSalida.setEmpresa("GD08");
                biometricoDtoSalida.setEmpresaNombre("FAHDI SA");
                biometricoList.removeIf(x->x.getId()==8);
                List<BiometricoDto> biometricoDtoList = biometricoMapper.biometricoToBiometricoDto(biometricoList);
                biometricoDtoList.add(biometricoDtoIngreso);
                biometricoDtoList.add(biometricoDtoSalida);
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
