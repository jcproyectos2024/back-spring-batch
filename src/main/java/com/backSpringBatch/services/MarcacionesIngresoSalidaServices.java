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
import java.util.Optional;
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
            Optional<List<MarcacionesIngresoSalida>>  marcacionesIngresoSalidaListSueldoAntigOptional=marcacionesIngresoSalidaRepository.findAllByIngresoSalida("2023-12-26","2023-12-31",false);
            Optional<List<MarcacionesIngresoSalida>>  marcacionesIngresoSalidaListOptional=marcacionesIngresoSalidaRepository.findAllByIngresoSalida("2024-01-01","2024-01-25",false);

            // marcacionesIngresoSalidaRepository. findAllByIngresoSalida(fechaPeriodo[0],fechaPeriodo[1],false).ifPresentOrElse(  marcacionesIngresoSalidaList -
            if(marcacionesIngresoSalidaListSueldoAntigOptional.isPresent() || marcacionesIngresoSalidaListOptional.isPresent())
            {
                List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListSueldoAntig=marcacionesIngresoSalidaListSueldoAntigOptional.get();
                List<MarcacionesIngresoSalida>      marcacionesIngresoSalidaList=marcacionesIngresoSalidaListOptional.get();

                if (responsePersonaProduccionFija.isSuccess())
                {
                  // List<PersonaProduccionFijaDto> personaProduccionFijaDtoListListFilter=responsePersonaProduccionFija.getPersonaProduccionFijaDtoList()==null? new ArrayList<>() :responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().stream().filter(s->(s.getIdentificacion().equalsIgnoreCase( /*x.getIdentificacion()*/"0953839032" ))).collect(Collectors.toList());
                  //  personaProduccionFijaDtoListListFilter.forEach(x ->
                   responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().forEach(x ->
                {
                        try
                        {
                            List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilter=marcacionesIngresoSalidaList==null? new ArrayList<>() :marcacionesIngresoSalidaList.stream().filter(ls->(ls.getId().getIdentificacion().equalsIgnoreCase(x.getIdentificacion()))).collect(Collectors.toList());
                            List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListSueldoAntigFilter=marcacionesIngresoSalidaListSueldoAntig==null? new ArrayList<>() :marcacionesIngresoSalidaListSueldoAntig.stream().filter(ow->(ow.getId().getIdentificacion().equalsIgnoreCase(x.getIdentificacion()))).collect(Collectors.toList());

                            if(!marcacionesIngresoSalidaListSueldoAntigFilter.isEmpty())
                            {

                              //  if ((x.getSueldoAntiguo()==null?0F:x.getSueldoAntiguo())==458.64F)
                                    if (x.getSueldoAntiguo()!=null)
                                {
                                    //Filtro del 26 Diciembre Hasta el 31 Diciembre para Calcular con el Sueldo Antiguo
                                    calculoNominaProduccionFijaService.acumularHorasSuplementariasPersonal(true,periodoOriginal,x.getIdentificacion(),marcacionesIngresoSalidaListSueldoAntigFilter);
                                   calculoNominaProduccionFijaService.calculoNominaProduccionFija(true,x.getIdentificacion(),x.getSueldoAntiguo(),periodoOriginal);
                                }else
                                {
                                    calculoNominaProduccionFijaService.acumularHorasSuplementariasPersonal(false,periodoOriginal,x.getIdentificacion(),marcacionesIngresoSalidaListSueldoAntigFilter);
                                    calculoNominaProduccionFijaService.calculoNominaProduccionFija(false,x.getIdentificacion(),x.getSueldo(),periodoOriginal);
                                }
                            }
                            if(!marcacionesIngresoSalidaListFilter.isEmpty())
                            {
                                calculoNominaProduccionFijaService.acumularHorasSuplementariasPersonal(false,periodoOriginal,x.getIdentificacion(),marcacionesIngresoSalidaListFilter);
                                calculoNominaProduccionFijaService.calculoNominaProduccionFija(false,x.getIdentificacion(),x.getSueldo(),periodoOriginal);
                            }

                        } catch (Exception e)
                        {
                            e.printStackTrace();
                            throw new GenericExceptionUtils(e);
                        }
                   });
                }

            }
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
          //  Utils.console("responsePersonaProduccionFija",Utils.toJson(responsePersonaProduccionFija.getPersonaProduccionFijaDtoList()));
            String[] fechaPeriodo= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
            Optional<List<MarcacionesIngresoSalida>>  marcacionesIngresoSalidaListSueldoAntigOptional=marcacionesIngresoSalidaRepository.findAllByIngresoSalidaHorasExtras("2023-12-26","2023-12-31",false);
            Optional<List<MarcacionesIngresoSalida>>  marcacionesIngresoSalidaListOptional=marcacionesIngresoSalidaRepository.findAllByIngresoSalidaHorasExtras("2024-01-01","2024-01-25",false);
           //marcacionesIngresoSalidaRepository.findAllByIngresoSalidaHorasExtras(fechaPeriodo[0],fechaPeriodo[1],false).ifPresentOrElse(  marcacionesIngresoSalidaList ->
            if(marcacionesIngresoSalidaListSueldoAntigOptional.isPresent() || marcacionesIngresoSalidaListOptional.isPresent())
            {
                List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListSueldoAntig=marcacionesIngresoSalidaListSueldoAntigOptional.get();
                List<MarcacionesIngresoSalida>      marcacionesIngresoSalidaList=marcacionesIngresoSalidaListOptional.get();
                if (responsePersonaProduccionFija.isSuccess())
                {
                      // List<PersonaProduccionFijaDto> personaProduccionFijaDtoListListFilter=responsePersonaProduccionFija.getPersonaProduccionFijaDtoList()==null? new ArrayList<>() :responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().stream().filter(s->(s.getIdentificacion().equalsIgnoreCase( /*x.getIdentificacion()*/"1310952690" ))).collect(Collectors.toList());
                     //personaProduccionFijaDtoListListFilter.forEach(persona ->
                               responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().forEach(persona ->
                    {
                    try
                    {
                        List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilter=marcacionesIngresoSalidaList==null? new ArrayList<>() :marcacionesIngresoSalidaList.stream().filter(j->(j.getId().getIdentificacion().equalsIgnoreCase(persona.getIdentificacion()))).collect(Collectors.toList());
                        List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListSueldoAntigFilter=marcacionesIngresoSalidaListSueldoAntig==null? new ArrayList<>() :marcacionesIngresoSalidaListSueldoAntig.stream().filter(t->(t.getId().getIdentificacion().equalsIgnoreCase(persona.getIdentificacion()))).collect(Collectors.toList());
                        if(!marcacionesIngresoSalidaListSueldoAntigFilter.isEmpty())
                        {
                           // if ((persona.getSueldoAntiguo()==null?0F:persona.getSueldoAntiguo())==458.64F)
                                if (persona.getSueldoAntiguo()!=null)
                            {
                                calculoNominaProduccionFijaService.acumularHorasExtrasPersonal(true,periodoOriginal,persona.getIdentificacion(),marcacionesIngresoSalidaListSueldoAntigFilter);
                                calculoNominaProduccionFijaService.calculoHorasExtrasNominaProduccionFija(true,persona.getIdentificacion(),persona.getSueldoAntiguo(),periodoOriginal);
                            }else
                            {
                                calculoNominaProduccionFijaService.acumularHorasExtrasPersonal(false,periodoOriginal,persona.getIdentificacion(),marcacionesIngresoSalidaListSueldoAntigFilter);
                                calculoNominaProduccionFijaService.calculoHorasExtrasNominaProduccionFija(false,persona.getIdentificacion(),persona.getSueldo(),periodoOriginal);
                            }
                        }
                        if(!marcacionesIngresoSalidaListFilter.isEmpty())
                        {
                            calculoNominaProduccionFijaService.acumularHorasExtrasPersonal(false,periodoOriginal,persona.getIdentificacion(),marcacionesIngresoSalidaListFilter);
                            calculoNominaProduccionFijaService.calculoHorasExtrasNominaProduccionFija(false,persona.getIdentificacion(),persona.getSueldo(),periodoOriginal);
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                        throw new GenericExceptionUtils(e);
                    }
                    });
                }

            }
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
