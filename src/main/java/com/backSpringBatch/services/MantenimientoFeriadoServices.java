package com.backSpringBatch.services;
import com.backSpringBatch.Util.UtilsJSON;
import com.backSpringBatch.dto.RegistroMarcacionesDTO;
import com.backSpringBatch.postgres.entity.MantenimientoFeriado;
import com.backSpringBatch.postgres.mapper.MantenimientoFeriadoMapper;
import com.backSpringBatch.postgres.models.MantenimientoFeriadoDto;
import com.backSpringBatch.postgres.repository.MantenimientoFeriadoRepository;
import com.diosmar.GenericExceptionUtils;
import com.diosmar.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zalando.problem.Status;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Service
public class MantenimientoFeriadoServices
{
        @Autowired
        MantenimientoFeriadoRepository mantenimientoFeriadoRepository;

        @Autowired
        MantenimientoFeriadoMapper mantenimientoFeriadoMapper;



        public GenericResponse findAllMantenimientoFeriado()
        {
           GenericResponse genericResponse  =new GenericResponse();
                mantenimientoFeriadoRepository.findAllByEstadoTrue().ifPresentOrElse(mantenimientoFeriadoList ->
                {
                    List<MantenimientoFeriadoDto> mantenimientoFeriadoDtoList = mantenimientoFeriadoMapper.toMantenimientoFeriadoDtoList(mantenimientoFeriadoList);
                    genericResponse.data(mantenimientoFeriadoDtoList)
                            .success(true)
                            .message("Consulta Existosa");

                }, () -> {

                    throw new GenericExceptionUtils("No se encotraron Datos", Status.OK);
                });
            return genericResponse;
        }



        public GenericResponse findByIdMantenimientoFeriado(long id)
        {
            GenericResponse genericResponse  =new GenericResponse();
                mantenimientoFeriadoRepository.findByEstadoTrueAndIdMantenimientoFeriado(id).ifPresentOrElse(mantenimientoFeriado ->
                {
                    MantenimientoFeriadoDto mantenimientoFeriadoDto = mantenimientoFeriadoMapper.mantenimientoFeriadoToMantenimientoFeriadoDto(mantenimientoFeriado);
                    genericResponse.data(mantenimientoFeriadoDto)
                            .success(true)
                            .message("Consulta Existosa");

                }, () -> {
                    throw new GenericExceptionUtils("No se encotraron Datos", Status.OK);
                });

            return genericResponse;
        }

        @Transactional(rollbackFor = {RuntimeException.class} )
        public GenericResponse saveUpdateMantenimientoFeriado(List<MantenimientoFeriadoDto> mantenimientoFeriadoDtoList)
        {
            GenericResponse genericResponse  =new GenericResponse();

            for (MantenimientoFeriadoDto mantenimientoFeriadoDto :mantenimientoFeriadoDtoList)
            {
                mantenimientoFeriadoRepository.
                        findByEstadoTrueAndIdMantenimientoFeriado(Objects.requireNonNullElse(mantenimientoFeriadoDto.getIdMantenimientoFeriado(), 0L))
                        .ifPresentOrElse(mantenimientoFeriado ->
                        {

                            MantenimientoFeriado mantenimientoFeriadoMap = mantenimientoFeriadoMapper.mantenimientoFeriadoDtoToMantenimientoFeriado(mantenimientoFeriadoDto);
                            mantenimientoFeriadoMap.setEstado(true);
                            mantenimientoFeriadoMap.setFechaModifica(Instant.now());
                            mantenimientoFeriadoMap.setEstado(Objects.requireNonNullElse(mantenimientoFeriadoDto.getEstado(), mantenimientoFeriado.getEstado()));
                            genericResponse.data(mantenimientoFeriadoMapper.mantenimientoFeriadoToMantenimientoFeriadoDto(mantenimientoFeriadoRepository.save(mantenimientoFeriadoMap)))
                                    .success(true)
                                    .message("Modificación Existosa");

                        }, () ->
                        {
                            mantenimientoFeriadoDto.setEstado(true);
                            mantenimientoFeriadoDto.setFechaCreacion(Instant.now());
                            MantenimientoFeriado mantenimientoFeriadoSave= mantenimientoFeriadoRepository.save(mantenimientoFeriadoMapper.mantenimientoFeriadoDtoToMantenimientoFeriado(mantenimientoFeriadoDto));
                            genericResponse.data(mantenimientoFeriadoMapper.mantenimientoFeriadoToMantenimientoFeriadoDto(mantenimientoFeriadoSave))
                                    .success(true)
                                    .message("Guardado Existosa");
                        });
            }
            return genericResponse;
        }


        public GenericResponse deleteMantenimientoFeriado(Long id)
        {
            GenericResponse genericResponse  =new GenericResponse();

                mantenimientoFeriadoRepository.findByEstadoTrueAndIdMantenimientoFeriado(id).ifPresentOrElse(mantenimientoFeriado ->
                {
                    mantenimientoFeriado.setFechaModifica(Instant.now());
                    mantenimientoFeriado.setEstado(false);
                    MantenimientoFeriado mantenimientoFeriadoSave= mantenimientoFeriadoRepository.save(mantenimientoFeriado);
                    genericResponse.data(mantenimientoFeriadoMapper.mantenimientoFeriadoToMantenimientoFeriadoDto(mantenimientoFeriadoSave))
                            .success(true)
                            .message("Elimino Existosamente");

                }, () ->
                {
                    genericResponse.success(true)
                            .message("No se Elimino");
                });

            return genericResponse;
        }

    public GenericResponse consultarMantenimientoFeriadoPagineo(Map<String, Object> body)
    {
        GenericResponse genericResponse  =new GenericResponse();
        String feriado = UtilsJSON.jsonToObjeto(String.class, body.get("feriado"));
        int numeroPagina = UtilsJSON.jsonToObjeto(Integer.class, body.get("numeroPagina"));
        int numeroRegistros = UtilsJSON.jsonToObjeto(Integer.class, body.get("numeroRegistros"));
        Pageable pageable = PageRequest.of(numeroPagina-1,numeroRegistros);
        String feriadoConsulta=(feriado!=null && !feriado.equals("")?"%"+feriado+"%":null);
        Page<MantenimientoFeriado> pc2= mantenimientoFeriadoRepository.consultarMantenimientoFeriadoPagineo(feriadoConsulta,pageable);
        if (!pc2.getContent().isEmpty())
        {
            List<MantenimientoFeriadoDto> mantenimientoFeriadoDtoList = mantenimientoFeriadoMapper.toMantenimientoFeriadoDtoList(pc2.getContent());
            genericResponse.data(mantenimientoFeriadoDtoList)
                    .success(true)
                    .message("Consulta Existosa");
        }
        else {
            throw new GenericExceptionUtils("No se encotraron Datos", Status.OK);
        }
        return genericResponse;
    }


}


