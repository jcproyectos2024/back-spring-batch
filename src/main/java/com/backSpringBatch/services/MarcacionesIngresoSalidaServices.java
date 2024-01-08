package com.backSpringBatch.services;

import com.backSpringBatch.Util.Utily;
import com.backSpringBatch.postgres.entity.MarcacionesIngresoSalida;
import com.backSpringBatch.postgres.models.ResponsePeriodoActual;
import com.backSpringBatch.postgres.models.ResponsePersonaProduccionFija;
import com.backSpringBatch.postgres.models.ScheduleDTO;
import com.backSpringBatch.postgres.repository.MarcacionesIngresoSalidaRepository;
import com.diosmar.GenericExceptionUtils;
import com.diosmar.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcacionesIngresoSalidaServices
{
    @Autowired
    MarcacionesIngresoSalidaRepository marcacionesIngresoSalidaRepository;
    @Autowired
    Utily utily;
    @Autowired
    RESTServices restServices;
    @Autowired
    DataBaseServices dataBaseServices;
    @Autowired
    CalculoNominaProduccionFijaService calculoNominaProduccionFijaService;

    public void findAllMarcacionesIngresoSalida()
    {
        ResponsePeriodoActual periodoActual =restServices.consultarPeriodoActual();
        try
        {
            ResponsePersonaProduccionFija responsePersonaProduccionFija =restServices.consultarPersonaProduccionFijaCalculo("PRODUCCIÓN FIJA");
           // String[] fechaPeriodo= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
                if (responsePersonaProduccionFija.isSuccess())
                {
                    Utils.console("responsePersonaProduccionFija",Utils.toJson(responsePersonaProduccionFija));
                    responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().forEach(x ->
                    {
                        try
                        {
                            periodoActual.setPeriodoAsistencia("2023-11-26_2024-12-25");
                            dataBaseServices.calculoHorasSuplementariasProduccionXPersona(x.getIdentificacion(), x.getEmpNombre(),periodoActual);
                            calculoNominaProduccionFijaService.calculoNominaProduccionFija(x.getIdentificacion(),x.getSueldo(),periodoActual.getPeriodoAsistencia());
                        } catch (Exception e)
                        {
                            throw new GenericExceptionUtils(e);
                        }
                    });
                    System.out.println("***********************AQUI-----"+utily.convertirDateString(new Date()));
                }

        }catch (Exception ex)
        {
            ex.printStackTrace();
            //  return response;
            throw new GenericExceptionUtils(ex);
        }
    }


    public void findAllMarcacionesIngresoSalidaCalculoHorasSuplementariasPersonal()
    {
        ResponsePeriodoActual periodoActual =restServices.consultarPeriodoActual();
        try
        {
            ResponsePersonaProduccionFija responsePersonaProduccionFija =restServices.consultarPersonaProduccionFijaCalculo("PRODUCCIÓN FIJA");
            String[] fechaPeriodo= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
            marcacionesIngresoSalidaRepository. findAllByIngresoSalida(fechaPeriodo[0],fechaPeriodo[1],false).ifPresentOrElse(  marcacionesIngresoSalidaList ->
            {
               // Utils.console("marcacionesIngresoSalidaList",Utils.toJson(marcacionesIngresoSalidaList));
                if (responsePersonaProduccionFija.isSuccess())
                {
                   responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().forEach(x ->
                 {
                        try
                        {
                            List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilter=marcacionesIngresoSalidaList==null? new ArrayList<>() :marcacionesIngresoSalidaList.stream().filter(p->(p.getId().getIdentificacion().equalsIgnoreCase(/*x.getIdentificacion()*/"1725733529"))).collect(Collectors.toList());
                            if(!marcacionesIngresoSalidaListFilter.isEmpty())
                            {
                               // Utils.console("marcacionesIngresoSalidaListFilter",Utils.toJson(marcacionesIngresoSalidaListFilter));
                                calculoNominaProduccionFijaService.acumularHorasSuplementariasPersonal(periodoActual.getPeriodoAsistencia(),x.getIdentificacion(),marcacionesIngresoSalidaListFilter);
                                calculoNominaProduccionFijaService.calculoNominaProduccionFija(x.getIdentificacion(),x.getSueldo(),periodoActual.getPeriodoAsistencia());
                            }

                        } catch (Exception e)
                        {
                            e.printStackTrace();
                            throw new GenericExceptionUtils(e);
                        }
                   });
                  ///  System.out.println("***********************AQUI-----"+utily.convertirDateString(new Date()));
                }

            }, () -> {
              /*  response.setMensaje("No se encotraron Datos");
                response.setSuccess(false);*/

            });

        }catch (Exception ex)
        {
            ex.printStackTrace();
            //  return response;
            throw new GenericExceptionUtils(ex);
        }
    }



    public void findAllMarcacionesIngresoSalidaCalculoHorasExtras()
    {
        ResponsePeriodoActual periodoActual =restServices.consultarPeriodoActual();
        try
        {
            ResponsePersonaProduccionFija responsePersonaProduccionFija =restServices.findAllByPersonalHorasExtras(true);
          //  Utils.console("responsePersonaProduccionFija",Utils.toJson(responsePersonaProduccionFija));
            String[] fechaPeriodo= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
            marcacionesIngresoSalidaRepository.findAllByIngresoSalidaHorasExtras(fechaPeriodo[0],fechaPeriodo[1],false).ifPresentOrElse(  marcacionesIngresoSalidaList ->
            {
               // Utils.console("marcacionesIngresoSalidaList",Utils.toJson(marcacionesIngresoSalidaList));
                if (responsePersonaProduccionFija.isSuccess())
                {
                   responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().forEach(x ->
                    {
                    try
                    {
                        List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilter=marcacionesIngresoSalidaList==null? new ArrayList<>() :marcacionesIngresoSalidaList.stream().filter(p->(p.getId().getIdentificacion().equalsIgnoreCase(/*x.getIdentificacion()*/"1725733529"))).collect(Collectors.toList());
                        if(!marcacionesIngresoSalidaListFilter.isEmpty())
                        {
                            //tils.console("marcacionesIngresoSalidaListFilter",Utils.toJson(marcacionesIngresoSalidaListFilter));
                            calculoNominaProduccionFijaService.acumularHorasExtrasPersonal(periodoActual.getPeriodoAsistencia(),x.getIdentificacion(),marcacionesIngresoSalidaListFilter);
                            calculoNominaProduccionFijaService.calculoHorasExtrasNominaProduccionFija(x.getIdentificacion(),x.getSueldo(),periodoActual.getPeriodoAsistencia());
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                        throw new GenericExceptionUtils(e);
                    }
                    });
                    //System.out.println("***********************AQUI-----"+utily.convertirDateString(new Date()));
                }

            }, () -> {
              /*  response.setMensaje("No se encotraron Datos");
                response.setSuccess(false);*/

            });

        }catch (Exception ex)
        {
            ex.printStackTrace();
            //  return response;
            throw new GenericExceptionUtils(ex);
        }
    }

    public void calculoHorasExtrasCalculoHorasSuplementarias()
    {
        try
        {
            findAllMarcacionesIngresoSalidaCalculoHorasSuplementariasPersonal();
            findAllMarcacionesIngresoSalidaCalculoHorasExtras();

        }catch (Exception ex)
        {

            ex.printStackTrace();
            //  return response;
            throw new GenericExceptionUtils(ex);
        }
    }

}
