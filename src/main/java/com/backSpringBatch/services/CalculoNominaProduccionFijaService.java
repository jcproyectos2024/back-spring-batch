package com.backSpringBatch.services;

import com.backSpringBatch.Util.Utily;
import com.backSpringBatch.postgres.entity.HorasSuplementariasPersonal;
import com.backSpringBatch.postgres.entity.MarcacionesIngresoSalida;
import com.backSpringBatch.postgres.repository.HorasSuplementariasPersonalRepository;
import com.backSpringBatch.postgres.repository.MarcacionesIngresoSalidaRepository;
import com.diosmar.GenericExceptionUtils;
import com.diosmar.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CalculoNominaProduccionFijaService
{
    @Autowired
    private HorasSuplementariasPersonalRepository horasSuplementariasPersonalRepository;
    @Autowired
    Utily  utility;
    @Autowired
    MarcacionesIngresoSalidaRepository marcacionesIngresoSalidaRepository;


    public void calculoNominaProduccionFija(String identificacion, float sueldo, String periodo)
    {
        try
        {

            List<HorasSuplementariasPersonal> horasSuplementariasPersonalList = horasSuplementariasPersonalRepository.findAllByIdentificacionAndEstadoTrueAndPeriodo(identificacion,periodo);
            if (horasSuplementariasPersonalList != null) {
                horasSuplementariasPersonalList.forEach(z ->
                {
                    BigDecimal salarioPorHora = utility.calculoSalarioPorHoras(BigDecimal.valueOf(sueldo));
                    BigDecimal salarioPorMinutos = utility.calculoSalarioPorMinutos(BigDecimal.valueOf(sueldo));
                    int segundos = utility.convertirMillisecondSegundos(z.getHoras());
                    String horasMinutosSegundos = utility.calcularSegundoATiempo(segundos);
                    String[] horasMinutosSegundosSplit = utility.horasMinutosSegundosSplit(horasMinutosSegundos);
                    String horasSplit = horasMinutosSegundosSplit[0];
                    String minutosSplit = horasMinutosSegundosSplit[1];
                    //calculos por horas
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 25")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorHora);
                        z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                    }
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 50")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorHora);
                        z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        Utils.console("horasTotal",Utils.toJson(z.getSaldoHorasExtras()));
                    }
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 100")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorHora);
                        z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                    }

                    //calculos por minutos
                    if (Integer.parseInt(minutosSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 25")){
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorMinutos);
                        BigDecimal minutosTotal= (BigDecimal.valueOf(Integer.parseInt(minutosSplit)).multiply(calcularPorcentaje));
                        z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                    }
                    if (Integer.parseInt(minutosSplit) >0 && z.getTipo().equalsIgnoreCase("horas suplementarias 50")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorMinutos);
                        BigDecimal minutosTotal= (BigDecimal.valueOf(Integer.parseInt(minutosSplit)).multiply(calcularPorcentaje));
                        z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                    }
                    if (Integer.parseInt(minutosSplit) >0 && z.getTipo().equalsIgnoreCase("horas suplementarias 100")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorMinutos);
                        BigDecimal minutosTotal= (BigDecimal.valueOf(Integer.parseInt(minutosSplit)).multiply(calcularPorcentaje));
                        z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                    }

                    ///GUARDADO DE LOS LAS HORAS SUPLEMENTARIAS

                    if ( (Integer.parseInt(horasSplit) > 0 || Integer.parseInt(minutosSplit) >0 ) && (z.getTipo().equalsIgnoreCase("horas suplementarias 25")) )
                    {
                       horasSuplementariasPersonalRepository.save(z);
                    }
                    if ( (Integer.parseInt(horasSplit) > 0 || Integer.parseInt(minutosSplit) >0 ) && (z.getTipo().equalsIgnoreCase("horas suplementarias 50"))) {
                        horasSuplementariasPersonalRepository.save(z);
                    }
                    if ((Integer.parseInt(horasSplit) > 0 || Integer.parseInt(minutosSplit) >0 ) && (z.getTipo().equalsIgnoreCase("horas suplementarias 100")))
                    {
                        horasSuplementariasPersonalRepository.save(z);
                    }

                });

            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
          /*  response.setMensaje("Error de Servidor");
            response.setSuccess(false);
            // return response;*/
            throw new GenericExceptionUtils(ex);

        }
    }



    public void calculoHorasExtrasNominaProduccionFija(String identificacion, float sueldo, String periodo)
    {
        try
        {

            List<HorasSuplementariasPersonal> horasSuplementariasPersonalList = horasSuplementariasPersonalRepository.findAllByIdentificacionAndEstadoTrueAndPeriodo(identificacion,periodo);
            if (horasSuplementariasPersonalList != null) {
                horasSuplementariasPersonalList.forEach(z ->
                {
                    BigDecimal salarioPorHora = utility.calculoSalarioPorHoras(BigDecimal.valueOf(sueldo));
                    BigDecimal salarioPorMinutos = utility.calculoSalarioPorMinutos(BigDecimal.valueOf(sueldo));
                    int segundos = utility.convertirMillisecondSegundos(z.getHoras());
                    String horasMinutosSegundos = utility.calcularSegundoATiempo(segundos);
                    String[] horasMinutosSegundosSplit = utility.horasMinutosSegundosSplit(horasMinutosSegundos);
                    String horasSplit = horasMinutosSegundosSplit[0];
                    String minutosSplit = horasMinutosSegundosSplit[1];
                    //calculos por horas
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas extras 50")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorHora);
                        z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                    }

                    //calculos por minutos
                    if (Integer.parseInt(minutosSplit) > 0 && z.getTipo().equalsIgnoreCase("horas extras 50")){
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorMinutos);
                        BigDecimal minutosTotal= (BigDecimal.valueOf(Integer.parseInt(minutosSplit)).multiply(calcularPorcentaje));
                        z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                    }

                    ///GUARDADO DE LOS LAS HORAS EXTRAS

                    if ( (Integer.parseInt(horasSplit) > 0 || Integer.parseInt(minutosSplit) >0 ) && (z.getTipo().equalsIgnoreCase("horas extras 50")) )
                    {
                        horasSuplementariasPersonalRepository.save(z);
                    }

                });

            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
          /*  response.setMensaje("Error de Servidor");
            response.setSuccess(false);
            // return response;*/
            throw new GenericExceptionUtils(ex);

        }
    }


    public void acumularHorasSuplementariasPersonal(String periodoActual, String identificacion ,  List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilter)
    {
        try
        {
            if (marcacionesIngresoSalidaListFilter != null)
            {
                for (MarcacionesIngresoSalida marcacionesIngresoSalida :marcacionesIngresoSalidaListFilter)
                {
                    if (marcacionesIngresoSalida.getId().getFechaEntrada()!=null && marcacionesIngresoSalida.getFecheSalida()!=null )
                    {
                        Utils.console("ENTRO",Utils.toJson(""));
                        //Acumulacion de 25% para guardarlo en la table de HorasSuplementariasPersonal
                        if (marcacionesIngresoSalida.getSuplementarias25()!=null)
                        {
                            Utils.console("getSuplementarias25",Utils.toJson(marcacionesIngresoSalida.getSuplementarias25()));
                            //int horas25=0;
                            HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrueAndTipoAndPeriodo(identificacion,"horas suplementarias 25",periodoActual);
                            if(horaPersonal==null)
                            {
                                horaPersonal=new HorasSuplementariasPersonal();
                                horaPersonal.setIdentificacion(identificacion);
                                horaPersonal.setPeriodo(periodoActual);
                                horaPersonal.setPorcentaje(BigDecimal.valueOf(25));
                            }
                            horaPersonal.setTipo("horas suplementarias 25");
                            horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getSuplementarias25());
                            //horaPersonal.setHoras(horaPersonal.getHoras()+horas25);
                            Utils.console("horaPersonal",Utils.toJson(horaPersonal));
                            horasSuplementariasPersonalRepository.save(horaPersonal);
                        }

                        //Acumulacion de 100% para guardarlo en la table de HorasSuplementariasPersonal
                        if (marcacionesIngresoSalida.getSuplementarias100()!=null)
                        {
                            Utils.console("getSuplementarias100",Utils.toJson(marcacionesIngresoSalida.getSuplementarias100()));
                            //int horas25=0;
                            HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrueAndTipoAndPeriodo(identificacion,"horas suplementarias 100",periodoActual);
                            if(horaPersonal==null)
                            {
                                horaPersonal=new HorasSuplementariasPersonal();
                                horaPersonal.setIdentificacion(identificacion);
                                horaPersonal.setPeriodo(periodoActual);
                                horaPersonal.setPorcentaje(BigDecimal.valueOf(100));
                            }
                            horaPersonal.setTipo("horas suplementarias 100");
                            horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getSuplementarias100());
                            //horaPersonal.setHoras(horaPersonal.getHoras()+horas25);
                            Utils.console("horaPersonal",Utils.toJson(horaPersonal));
                            horasSuplementariasPersonalRepository.save(horaPersonal);
                        }

                        //Acumulacion de 50% para guardarlo en la table de HorasSuplementariasPersonal
                        if (marcacionesIngresoSalida.getSuplementarias50()!=null)
                        {
                            Utils.console("getSuplementarias50",Utils.toJson(marcacionesIngresoSalida.getSuplementarias50()));
                            //int horas25=0;
                            HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrueAndTipoAndPeriodo(identificacion,"horas suplementarias 50",periodoActual);
                            if(horaPersonal==null)
                            {
                                horaPersonal=new HorasSuplementariasPersonal();
                                horaPersonal.setIdentificacion(identificacion);
                                horaPersonal.setPeriodo(periodoActual);
                                horaPersonal.setPorcentaje(BigDecimal.valueOf(50));
                            }
                            horaPersonal.setTipo("horas suplementarias 50");
                            horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getSuplementarias50());
                            //horaPersonal.setHoras(horaPersonal.getHoras()+horas25);
                            Utils.console("horaPersonal",Utils.toJson(horaPersonal));
                            horasSuplementariasPersonalRepository.save(horaPersonal);
                        }
                        marcacionesIngresoSalida.setProcesado(true);
                        marcacionesIngresoSalidaRepository.save(marcacionesIngresoSalida);
                    }
                }
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
          /*  response.setMensaje("Error de Servidor");
            response.setSuccess(false);
            // return response;*/
            throw new GenericExceptionUtils(ex);

        }
    }



    public void acumularHorasExtrasPersonal(String periodoActual, String identificacion ,  List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilter)
    {
        try
        {
            if (marcacionesIngresoSalidaListFilter != null)
            {
                for (MarcacionesIngresoSalida marcacionesIngresoSalida :marcacionesIngresoSalidaListFilter)
                {
                    if (marcacionesIngresoSalida.getId().getFechaEntrada()!=null && marcacionesIngresoSalida.getFecheSalida()!=null )
                    {
                        Utils.console("ENTRO");
                        //Acumulacion horas extras 50 % para guardarlo en la table de HorasSuplementariasPersonal
                        if (marcacionesIngresoSalida.getHorasExtras()!=null)
                        {
                            Utils.console("horas extras 50",Utils.toJson(marcacionesIngresoSalida.getHorasExtras()));
                            HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrueAndTipoAndPeriodo(identificacion,"horas extras 50",periodoActual);
                            if(horaPersonal==null)
                            {
                                horaPersonal=new HorasSuplementariasPersonal();
                                horaPersonal.setIdentificacion(identificacion);
                                horaPersonal.setPeriodo(periodoActual);
                                horaPersonal.setPorcentaje(BigDecimal.valueOf(50));
                            }
                            horaPersonal.setTipo("horas extras 50");
                            horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getHorasExtras());
                            horasSuplementariasPersonalRepository.save(horaPersonal);
                        }
                        marcacionesIngresoSalida.setHorasExtrasProcesada(true);
                        marcacionesIngresoSalidaRepository.save(marcacionesIngresoSalida);
                    }
                }
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
          /*  response.setMensaje("Error de Servidor");
            response.setSuccess(false);
            // return response;*/
            throw new GenericExceptionUtils(ex);

        }
    }

}
