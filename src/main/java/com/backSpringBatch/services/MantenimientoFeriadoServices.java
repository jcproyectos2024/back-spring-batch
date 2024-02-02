package com.backSpringBatch.services;
import com.backSpringBatch.postgres.entity.MantenimientoFeriado;
import com.backSpringBatch.postgres.mapper.MantenimientoFeriadoMapper;
import com.backSpringBatch.postgres.models.MantenimientoFeriadoDto;
import com.backSpringBatch.postgres.repository.MantenimientoFeriadoRepository;
import com.diosmar.GenericExceptionUtils;
import com.diosmar.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zalando.problem.Status;
import java.time.Instant;
import java.util.List;
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

/*

        public MantenimientoFeriadoResponse findByIdMantenimientoFeriado(long id)
        {
            GenericResponse genericResponse  =new GenericResponse();

            try
            {

                mantenimientoFeriadoRepository.findByEstadoTrueAndIdMantenimientoFeriado(id).ifPresentOrElse(mantenimientoFeriado ->
                {
                    MantenimientoFeriadoDto mantenimientoFeriadoDto = mantenimientoFeriadoMapper.mantenimientoFeriadoToMantenimientoFeriadoDto(mantenimientoFeriado);
                    response.setMantenimientoFeriadoDto(mantenimientoFeriadoDto);
                    response.setMensaje("Consulta Existosa");
                    response.setSuccess(true);

                }, () -> {
                    response.setMensaje("No se encotraron Datos");
                    response.setSuccess(false);
                });


            }catch (Exception ex)
            {
                ex.printStackTrace();
                response.setMensaje("Error de Servidor");
                response.setSuccess(false);
                //return response;
                throw new GenericExceptionUtils(ex);

            }


            return response;
        }

        @Transactional(rollbackFor = {Exception.class} )
        public MantenimientoFeriadoResponse saveUpdateMantenimientoFeriado(MantenimientoFeriadoDto mantenimientoFeriadoDto)
        {
            MantenimientoFeriadoResponse response = new MantenimientoFeriadoResponse();

            try
            {

                mantenimientoFeriadoRepository.
                        findByEstadoTrueAndIdMantenimientoFeriado(Objects.requireNonNullElse(mantenimientoFeriadoDto.getIdMantenimientoFeriado(), 0L))
                        .ifPresentOrElse(mantenimientoFeriado ->
                        {

                            MantenimientoFeriado mantenimientoFeriadoMap = mantenimientoFeriadoMapper.mantenimientoFeriadoDtoToMantenimientoFeriado(mantenimientoFeriadoDto);
                            mantenimientoFeriadoMap.setFechaModifica(Instant.now());
                            mantenimientoFeriadoMap.setEstado(Objects.requireNonNullElse(mantenimientoFeriadoDto.getEstado(), mantenimientoFeriado.getEstado()));
                            response.setMantenimientoFeriadoDto(mantenimientoFeriadoMapper.mantenimientoFeriadoToMantenimientoFeriadoDto(mantenimientoFeriadoRepository.save(mantenimientoFeriadoMap)));
                            response.setMensaje("Modificación Existosa");
                            response.setSuccess(true);
                        }, () ->
                        {
                            //mantenimientoFeriadoDto.setEstado(true);
                            MantenimientoFeriado mantenimientoFeriadoSave= mantenimientoFeriadoRepository.save(mantenimientoFeriadoMapper.mantenimientoFeriadoDtoToMantenimientoFeriado(mantenimientoFeriadoDto));
                            response.setMantenimientoFeriadoDto(mantenimientoFeriadoMapper.mantenimientoFeriadoToMantenimientoFeriadoDto(mantenimientoFeriadoSave));
                            response.setMensaje("Guardado Existoso");
                            response.setSuccess(true);
                        });


            }catch (Exception ex)
            {
                ex.printStackTrace();
                response.setMensaje("Error de Servidor :"+ex.getMessage());
                response.setSuccess(false);
                //  return response;
                throw new GenericExceptionUtils(ex);

            }
            return response;
        }


        public MantenimientoFeriadoResponse deleteMantenimientoFeriado(Long id)
        {
            MantenimientoFeriadoResponse response = new MantenimientoFeriadoResponse();

            try
            {

                mantenimientoFeriadoRepository.findByEstadoTrueAndIdMantenimientoFeriado(id).ifPresentOrElse(mantenimientoFeriado ->
                {
                    mantenimientoFeriado.setFechaModifica(Instant.now());
                    mantenimientoFeriado.setEstado(false);
                    MantenimientoFeriado mantenimientoFeriadoSave= mantenimientoFeriadoRepository.save(mantenimientoFeriado);
                    response.setMantenimientoFeriadoDto(mantenimientoFeriadoMapper.mantenimientoFeriadoToMantenimientoFeriadoDto(mantenimientoFeriadoSave));
                    response.setMensaje("Elimino Existosamente");
                    response.setSuccess(true);

                }, () ->
                {

                    response.setMensaje("No se Elimino");
                    response.setSuccess(false);
                });

            }catch (Exception ex)
            {
                ex.printStackTrace();
                response.setMensaje("Error de Servidor");
                response.setSuccess(false);
                // return response;
                throw new GenericExceptionUtils(ex);

            }
            return response;
        }
*/

}


