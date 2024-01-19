package com.backSpringBatch.services;

import com.backSpringBatch.Util.Utily;
import com.backSpringBatch.postgres.entity.MarcacionesIngresoSalida;
import com.backSpringBatch.postgres.models.PersonaProduccionFijaDto;
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
            ResponsePersonaProduccionFija responsePersonaProduccionFija =restServices.consultarPersonaProduccionFijaCalculo(restServices.parametrizacionRecursosHumanos("produccionFija"));
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
                            calculoNominaProduccionFijaService.calculoNominaProduccionFija(false,x.getIdentificacion(),x.getSueldo(),periodoActual.getPeriodoAsistencia());
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
        String periodoOriginal=periodoActual.getPeriodoAsistencia();
        try
        {
            ResponsePersonaProduccionFija responsePersonaProduccionFija =restServices.consultarPersonaProduccionFijaCalculo(restServices.parametrizacionRecursosHumanos("produccionFija"));
            String[] fechaPeriodo= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
            marcacionesIngresoSalidaRepository. findAllByIngresoSalida(fechaPeriodo[0],fechaPeriodo[1],false).ifPresentOrElse(  marcacionesIngresoSalidaList ->
            {
                if (responsePersonaProduccionFija.isSuccess())
                {
                   //List<PersonaProduccionFijaDto> personaProduccionFijaDtoListListFilter=responsePersonaProduccionFija.getPersonaProduccionFijaDtoList()==null? new ArrayList<>() :responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().stream().filter(s->(s.getIdentificacion().equalsIgnoreCase( /*x.getIdentificacion()*/"0923988315" ))).collect(Collectors.toList());
                    //personaProduccionFijaDtoListListFilter.forEach(x ->
                   responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().forEach(x ->
                {
                        try
                        {
                            List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilter=marcacionesIngresoSalidaList==null? new ArrayList<>() :marcacionesIngresoSalidaList.stream().filter(p->(p.getId().getIdentificacion().equalsIgnoreCase(x.getIdentificacion()))).collect(Collectors.toList());
                            if(!marcacionesIngresoSalidaListFilter.isEmpty())
                            {
                              if (x.getSueldoAntiguo()!=null)
                                {
                                    //Filtro del 26 Diciembre Hasta el 31 Diciembre para Calcular con el Sueldo Antiguo
                                    periodoActual.setPeriodoAsistencia("2023-12-26_2023-12-31");
                                    String[] fechaPeriodoFilter= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
                                    List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilterSueldoAntig=marcacionesIngresoSalidaListFilter==null? new ArrayList<>() :marcacionesIngresoSalidaListFilter.stream().filter(b->(utily.formatoDate(b.getAsisFechaEntrada()).after(utily.convertirStringDate(fechaPeriodoFilter[0]))  &&  utily.formatoDate(b.getAsisFechaEntrada()).before(utily.convertirStringDate(fechaPeriodoFilter[1])) )).collect(Collectors.toList());
                                    calculoNominaProduccionFijaService.acumularHorasSuplementariasPersonal(true,periodoOriginal,x.getIdentificacion(),marcacionesIngresoSalidaListFilterSueldoAntig);
                                   calculoNominaProduccionFijaService.calculoNominaProduccionFija(true,x.getIdentificacion(),x.getSueldoAntiguo(),periodoOriginal);
                                }
                                periodoActual.setPeriodoAsistencia("2024-01-01_2024-01-25");
                                String[] fechaPeriodoFilter= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
                                List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilterSueldoAntig=marcacionesIngresoSalidaListFilter==null? new ArrayList<>() :marcacionesIngresoSalidaListFilter.stream().filter(b->(utily.formatoDate(b.getAsisFechaEntrada()).after(utily.convertirStringDate(fechaPeriodoFilter[0]))  &&  utily.formatoDate(b.getAsisFechaEntrada()).before(utily.convertirStringDate(fechaPeriodoFilter[1])) )).collect(Collectors.toList());
                                calculoNominaProduccionFijaService.acumularHorasSuplementariasPersonal(false,periodoOriginal,x.getIdentificacion(),marcacionesIngresoSalidaListFilterSueldoAntig);
                                calculoNominaProduccionFijaService.calculoNominaProduccionFija(false,x.getIdentificacion(),x.getSueldo(),periodoOriginal);
                            }

                        } catch (Exception e)
                        {
                            e.printStackTrace();
                            throw new GenericExceptionUtils(e);
                        }
                   });
                }

            }, () -> {

            });

        }catch (Exception ex)
        {
            ex.printStackTrace();
            throw new GenericExceptionUtils(ex);
        }
    }



    public void findAllMarcacionesIngresoSalidaCalculoHorasExtras()
    {
        ResponsePeriodoActual periodoActual =restServices.consultarPeriodoActual();
        String periodoOriginal=periodoActual.getPeriodoAsistencia();
        try
        {
            ResponsePersonaProduccionFija responsePersonaProduccionFija =restServices.findAllByPersonalHorasExtras(true);
            String[] fechaPeriodo= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
           marcacionesIngresoSalidaRepository.findAllByIngresoSalidaHorasExtras(fechaPeriodo[0],fechaPeriodo[1],false).ifPresentOrElse(  marcacionesIngresoSalidaList ->
            {
                if (responsePersonaProduccionFija.isSuccess())
                {
                   // List<PersonaProduccionFijaDto> personaProduccionFijaDtoListListFilter=responsePersonaProduccionFija.getPersonaProduccionFijaDtoList()==null? new ArrayList<>() :responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().stream().filter(s->(s.getIdentificacion().equalsIgnoreCase( /*x.getIdentificacion()*/"0923988315" ))).collect(Collectors.toList());
                    //personaProduccionFijaDtoListListFilter.forEach(x ->
                             responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().forEach(x ->
                    {
                    try
                    {
                        List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilter=marcacionesIngresoSalidaList==null? new ArrayList<>() :marcacionesIngresoSalidaList.stream().filter(p->(p.getId().getIdentificacion().equalsIgnoreCase(x.getIdentificacion()))).collect(Collectors.toList());
                        if(!marcacionesIngresoSalidaListFilter.isEmpty())
                        {
                            if (x.getSueldoAntiguo()!=null)
                            {
                                //Filtro del 26 Diciembre Hasta el 31 Diciembre para Calcular con el Sueldo Antiguo
                                periodoActual.setPeriodoAsistencia("2023-12-26_2023-12-31");
                                String[] fechaPeriodoFilter= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
                                List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilterSueldoAntig=marcacionesIngresoSalidaListFilter==null? new ArrayList<>() :marcacionesIngresoSalidaListFilter.stream().filter(b->(utily.formatoDate(b.getAsisFechaEntrada()).after(utily.convertirStringDate(fechaPeriodoFilter[0]))  &&  utily.formatoDate(b.getAsisFechaEntrada()).before(utily.convertirStringDate(fechaPeriodoFilter[1])) )).collect(Collectors.toList());
                                calculoNominaProduccionFijaService.acumularHorasExtrasPersonal(true,periodoOriginal,x.getIdentificacion(),marcacionesIngresoSalidaListFilterSueldoAntig);
                                calculoNominaProduccionFijaService.calculoHorasExtrasNominaProduccionFija(true,x.getIdentificacion(),x.getSueldo(),periodoOriginal);
                            }
                            periodoActual.setPeriodoAsistencia("2024-01-01_2024-01-25");
                            String[] fechaPeriodoFilter= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
                            List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilterSueldoAntig=marcacionesIngresoSalidaListFilter==null? new ArrayList<>() :marcacionesIngresoSalidaListFilter.stream().filter(b->(utily.formatoDate(b.getAsisFechaEntrada()).after(utily.convertirStringDate(fechaPeriodoFilter[0]))  &&  utily.formatoDate(b.getAsisFechaEntrada()).before(utily.convertirStringDate(fechaPeriodoFilter[1])) )).collect(Collectors.toList());
                            calculoNominaProduccionFijaService.acumularHorasExtrasPersonal(false,periodoOriginal,x.getIdentificacion(),marcacionesIngresoSalidaListFilterSueldoAntig);
                            calculoNominaProduccionFijaService.calculoHorasExtrasNominaProduccionFija(false,x.getIdentificacion(),x.getSueldo(),periodoOriginal);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                        throw new GenericExceptionUtils(e);
                    }
                    });
                }

            }, () -> {
              /*  response.setMensaje("No se encotraron Datos");
                response.setSuccess(false);*/

            });

        }catch (Exception ex)
        {
            ex.printStackTrace();
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
