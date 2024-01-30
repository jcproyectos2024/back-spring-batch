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
                    BigDecimal salarioPorSegundos = utility.calculoSalarioPorSegundos(BigDecimal.valueOf(sueldo));
                    int segundos = utility.convertirMillisecondSegundos(sueldoAnterior?z.getHorasSueldoAnterior():z.getHoras());
                    String horasMinutosSegundos = utility.calcularSegundoATiempo(segundos);
                    String[] horasMinutosSegundosSplit = utility.horasMinutosSegundosSplit(horasMinutosSegundos);
                    String horasSplit = horasMinutosSegundosSplit[0];
                    String minutosSplit = horasMinutosSegundosSplit[1];
                    String segundosSplit = horasMinutosSegundosSplit[2];
                    //calculos por horas 25
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 25")) {
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorHora);
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }else
                        {
                            z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }
                    }
                    //calculos por horas 100
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 100")) {
                        // Se multiplica por 2 cuando es al 100% salario por horas es doble
                        BigDecimal calcularPorcentaje = salarioPorHora.multiply(new BigDecimal(2));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }else
                        {
                            z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }
                    }

                    //calculos por minutos  25
                    if (Integer.parseInt(minutosSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 25")){
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorMinutos);
                        BigDecimal minutosTotal= (BigDecimal.valueOf(Integer.parseInt(minutosSplit)).multiply(calcularPorcentaje));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(z.getSaldoHorasExtrasSueldoAnterior().add(minutosTotal));
                        }else
                        {
                            z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                        }
                    }
                    //calculos por minutos  100
                    if (Integer.parseInt(minutosSplit) >0 && z.getTipo().equalsIgnoreCase("horas suplementarias 100")) {
                        BigDecimal calcularPorcentaje = salarioPorMinutos.multiply(new BigDecimal(2));
                        BigDecimal minutosTotal= (BigDecimal.valueOf(Integer.parseInt(minutosSplit)).multiply(calcularPorcentaje));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(z.getSaldoHorasExtrasSueldoAnterior().add(minutosTotal));
                        }else
                        {
                            z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                        }
                    }

                    //calculos por segundos 25
                    if (Integer.parseInt(segundosSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 25")){
                        BigDecimal calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje(), salarioPorSegundos);
                        BigDecimal segundosTotal= (BigDecimal.valueOf(Integer.parseInt(segundosSplit)).multiply(calcularPorcentaje));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(z.getSaldoHorasExtrasSueldoAnterior().add(segundosTotal));
                        }else
                        {
                            z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(segundosTotal));
                        }
                    }
                    //calculos por segundos 100
                    if (Integer.parseInt(segundosSplit) >0 && z.getTipo().equalsIgnoreCase("horas suplementarias 100")) {
                        BigDecimal calcularPorcentaje = salarioPorSegundos.multiply(new BigDecimal(2));
                        BigDecimal segundosTotal= (BigDecimal.valueOf(Integer.parseInt(segundosSplit)).multiply(calcularPorcentaje));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(z.getSaldoHorasExtrasSueldoAnterior().add(segundosTotal));
                        }else
                        {
                            z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(segundosTotal));
                        }
                    }

                    ///GUARDADO DE LOS LAS HORAS SUPLEMENTARIAS

                    if ( (Integer.parseInt(horasSplit) > 0 || Integer.parseInt(minutosSplit) >0  || Integer.parseInt(segundosSplit) >0 ) && (z.getTipo().equalsIgnoreCase("horas suplementarias 25")) )
                    {
                       horasSuplementariasPersonalRepository.save(z);
                    }
                    if ( (Integer.parseInt(horasSplit) > 0 || Integer.parseInt(minutosSplit) >0 || Integer.parseInt(segundosSplit) >0  ) && (z.getTipo().equalsIgnoreCase("horas suplementarias 100")) )
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



    public void calculoHorasExtrasNominaProduccionFija(boolean sueldoAnterior ,String identificacion, float sueldo, String periodo)
    {
        try
        {
            List<HorasSuplementariasPersonal> horasSuplementariasPersonalList = horasSuplementariasPersonalRepository.findAllByIdentificacionAndEstadoTrueAndPeriodo(identificacion,periodo);
            if (horasSuplementariasPersonalList != null) {
                horasSuplementariasPersonalList.forEach(z ->
                {
                    BigDecimal salarioPorHora = utility.calculoSalarioPorHoras(BigDecimal.valueOf(sueldo));
                    BigDecimal salarioPorMinutos = utility.calculoSalarioPorMinutos(BigDecimal.valueOf(sueldo));
                    BigDecimal salarioPorSegundos = utility.calculoSalarioPorSegundos(BigDecimal.valueOf(sueldo));
                    int segundos = utility.convertirMillisecondSegundos(sueldoAnterior?z.getHorasSueldoAnterior():z.getHoras());
                    String horasMinutosSegundos = utility.calcularSegundoATiempo(segundos);
                    String[] horasMinutosSegundosSplit = utility.horasMinutosSegundosSplit(horasMinutosSegundos);
                    String horasSplit = horasMinutosSegundosSplit[0];
                    String minutosSplit = horasMinutosSegundosSplit[1];
                    String segundosSplit = horasMinutosSegundosSplit[2];
                    //calculos por horas
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas extras 50")) {
                        BigDecimal calcularPorcentaje = salarioPorHora.multiply(new BigDecimal(1.5));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }
                        else
                        {
                            z.setSaldoHorasExtras(BigDecimal.valueOf(Integer.parseInt(horasSplit)).multiply(calcularPorcentaje));
                        }
                    }

                    //calculos por minutos
                    if (Integer.parseInt(minutosSplit) > 0 && z.getTipo().equalsIgnoreCase("horas extras 50")){
                        BigDecimal calcularPorcentaje = salarioPorMinutos.multiply(new BigDecimal(1.5));
                        BigDecimal minutosTotal= (BigDecimal.valueOf(Integer.parseInt(minutosSplit)).multiply(calcularPorcentaje));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(z.getSaldoHorasExtrasSueldoAnterior().add(minutosTotal));
                        }
                        else
                        {
                            z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(minutosTotal));
                        }
                    }
                    //calculos por segundos
                    if (Integer.parseInt(segundosSplit) > 0 && z.getTipo().equalsIgnoreCase("horas extras 50")){
                        BigDecimal calcularPorcentaje = salarioPorSegundos.multiply(new BigDecimal(1.5));
                        BigDecimal segundosTotal= (BigDecimal.valueOf(Integer.parseInt(segundosSplit)).multiply(calcularPorcentaje));
                        if (sueldoAnterior)
                        {
                            z.setSaldoHorasExtrasSueldoAnterior(z.getSaldoHorasExtrasSueldoAnterior().add(segundosTotal));
                        }
                        else
                        {
                            z.setSaldoHorasExtras(z.getSaldoHorasExtras().add(segundosTotal));
                        }
                    }

                    ///GUARDADO DE LOS LAS HORAS EXTRAS
                    if ( (Integer.parseInt(horasSplit) > 0 || Integer.parseInt(minutosSplit) >0 || Integer.parseInt(segundosSplit) >0  ) && (z.getTipo().equalsIgnoreCase("horas extras 50")) )
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
                            horasSuplementariasPersonalRepository.save(horaPersonal);
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



    public void acumularHorasExtrasPersonal( boolean sueldoAnterior, String periodoActual, String identificacion ,  List<MarcacionesIngresoSalida> marcacionesIngresoSalidaListFilter)
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
                            if (sueldoAnterior)
                            {
                                horaPersonal.setHorasSueldoAnterior(horaPersonal.getHorasSueldoAnterior()+marcacionesIngresoSalida.getHorasExtras());
                            }
                            else
                            {
                                horaPersonal.setHoras(horaPersonal.getHoras()+marcacionesIngresoSalida.getHorasExtras());
                            }
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
