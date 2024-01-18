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


    public void calculoNominaProduccionFija( boolean sueldoAnterior, String identificacion, float sueldo, String periodo)
    {
        try
        {

            List<HorasSuplementariasPersonal> horasSuplementariasPersonalList = horasSuplementariasPersonalRepository.findAllByIdentificacionAndEstadoTrueAndPeriodo(identificacion,periodo);
            if (horasSuplementariasPersonalList != null) {
                horasSuplementariasPersonalList.forEach(z ->
                {
                    BigDecimal salarioPorHora = utility.calculoSalarioPorHoras(BigDecimal.valueOf(sueldo));
                    BigDecimal salarioPorMinutos = utility.calculoSalarioPorMinutos(BigDecimal.valueOf(sueldo));
                    int segundos = utility.convertirMillisecondSegundos(sueldoAnterior?z.getHorasSueldoAnterior():z.getHoras());
                    String horasMinutosSegundos = utility.calcularSegundoATiempo(segundos);
                    String[] horasMinutosSegundosSplit = utility.horasMinutosSegundosSplit(horasMinutosSegundos);
                    String horasSplit = horasMinutosSegundosSplit[0];
                    String minutosSplit = horasMinutosSegundosSplit[1];
                    //calculos por horas
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 25")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorHora);
                       // z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }else
                        {
                            z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }
                    }
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 50")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorHora);
                        //z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }else
                        {
                            z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }
                        Utils.console("horasTotal",Utils.toJson(z.getSaldoHorasExtras()));
                    }
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 100")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorHora);
                        //z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }else
                        {
                            z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }
                    }

                    //calculos por minutos
                    if (Integer.parseInt(minutosSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 25")){
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorMinutos);
                        BigDecimal minutosTotal= (BigDecimal.valueOf(Integer.parseInt(minutosSplit)).multiply(calcularPorcentaje));
                        //z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(z.getSaldoHorasExtras().add(minutosTotal));
                        }else
                        {
                            z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                        }
                    }
                    if (Integer.parseInt(minutosSplit) >0 && z.getTipo().equalsIgnoreCase("horas suplementarias 50")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorMinutos);
                        BigDecimal minutosTotal= (BigDecimal.valueOf(Integer.parseInt(minutosSplit)).multiply(calcularPorcentaje));
                        //z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(z.getSaldoHorasExtras().add(minutosTotal));
                        }else
                        {
                            z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                        }
                    }
                    if (Integer.parseInt(minutosSplit) >0 && z.getTipo().equalsIgnoreCase("horas suplementarias 100")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorMinutos);
                        BigDecimal minutosTotal= (BigDecimal.valueOf(Integer.parseInt(minutosSplit)).multiply(calcularPorcentaje));
                        //z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(z.getSaldoHorasExtras().add(minutosTotal));
                        }else
                        {
                            z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                        }
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


    public void acumularHorasSuplementariasPersonal( boolean sueldoAnterior ,String periodoActual, String identificacion ,  List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilter)
    {
        try
        {
            if (marcacionesIngresoSalidaListFilter != null)
            {
                for (MarcacionesIngresoSalida marcacionesIngresoSalida :marcacionesIngresoSalidaListFilter)
                {
                    if (marcacionesIngresoSalida.getId().getFechaEntrada()!=null && marcacionesIngresoSalida.getFecheSalida()!=null )
                    {

                        //Acumulacion de 25% para guardarlo en la table de HorasSuplementariasPersonal
                        if (marcacionesIngresoSalida.getSuplementarias25()!=null)
                        {
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
                            if (sueldoAnterior)
                            {
                                horaPersonal.setHorasSueldoAnterior(horaPersonal.getHorasSueldoAnterior()+marcacionesIngresoSalida.getSuplementarias25());
                            }else
                            {
                                horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getSuplementarias25());
                            }
                            //horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getSuplementarias25());
                            //horaPersonal.setHoras(horaPersonal.getHoras()+horas25);
                            //Utils.console("horaPersonal-----",Utils.toJson(horaPersonal));
                            HorasSuplementariasPersonal personal = horasSuplementariasPersonalRepository.save(horaPersonal);
                           // Utils.console("horaPersonal----guardado",Utils.toJson(personal));
                        }

                        //Acumulacion de 100% para guardarlo en la table de HorasSuplementariasPersonal
                        if (marcacionesIngresoSalida.getSuplementarias100()!=null)
                        {
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
                            if (sueldoAnterior)
                            {
                                horaPersonal.setHorasSueldoAnterior(horaPersonal.getHorasSueldoAnterior()+marcacionesIngresoSalida.getSuplementarias100());
                            }else
                            {
                                horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getSuplementarias100());
                            }
                           // horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getSuplementarias100());
                            //horaPersonal.setHoras(horaPersonal.getHoras()+horas25);
                            Utils.console("horaPersonal",Utils.toJson(horaPersonal));
                            horasSuplementariasPersonalRepository.save(horaPersonal);
                        }

                        //Acumulacion de 50% para guardarlo en la table de HorasSuplementariasPersonal
                        if (marcacionesIngresoSalida.getSuplementarias50()!=null)
                        {
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
                            if (sueldoAnterior)
                            {
                                horaPersonal.setHorasSueldoAnterior(horaPersonal.getHorasSueldoAnterior()+marcacionesIngresoSalida.getSuplementarias50());
                            }else
                            {
                                horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getSuplementarias50());
                            }
                           // horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getSuplementarias50());
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
                        //Acumulacion horas extras 50 % para guardarlo en la table de HorasSuplementariasPersonal
                        if (marcacionesIngresoSalida.getHorasExtras()!=null)
                        {
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
