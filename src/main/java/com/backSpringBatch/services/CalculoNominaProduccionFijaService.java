package com.backSpringBatch.services;

import com.backSpringBatch.Util.Utily;
import com.backSpringBatch.postgres.entity.HorasSuplementariasPersonal;
import com.backSpringBatch.postgres.repository.HorasSuplementariasPersonalRepository;
import com.diosmar.GenericExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CalculoNominaProduccionFijaService
{
    @Autowired
    private HorasSuplementariasPersonalRepository horasSuplementariasPersonalRepository;
    @Autowired
    Utily  utility;
    public void calculoNominaProduccionFija(String identificacion, float sueldo, String periodo)
    {
        try
        {

            List<HorasSuplementariasPersonal> horasSuplementariasPersonalList = horasSuplementariasPersonalRepository.findAllByIdentificacionAndEstadoTrueAndPeriodo(identificacion,periodo);
            if (horasSuplementariasPersonalList != null) {
                horasSuplementariasPersonalList.forEach(z ->
                {
                    float salarioPorHora = utility.calculoSalarioPorHoras(sueldo);
                    float salarioPorMinutos = utility.calculoSalarioPorMinutos(sueldo);
                    int segundos = utility.convertirMillisecondSegundos(z.getHoras());
                    String horasMinutosSegundos = utility.calcularSegundoATiempo(segundos);
                    String[] horasMinutosSegundosSplit = utility.horasMinutosSegundosSplit(horasMinutosSegundos);
                    String horasSplit = horasMinutosSegundosSplit[0];
                    String minutosSplit = horasMinutosSegundosSplit[1];
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 25")) {
                        float calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje().floatValue(), salarioPorHora);
                        //x.setCtaRecargoJornadaNocturna(BigDecimal.valueOf(Integer.parseInt(horasSplit) * calcularPorcentaje).setScale(decimalPlaces, BigDecimal.ROUND_DOWN));
                        z.setSaldoHorasExtras(Integer.parseInt(horasSplit) * calcularPorcentaje);
                    }
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 50")) {
                        float calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje().floatValue(), salarioPorHora);
                        //x.setPrSaldoHorasExtras50(BigDecimal.valueOf(Integer.parseInt(horasSplit) * calcularPorcentaje).setScale(decimalPlaces, BigDecimal.ROUND_DOWN));
                        z.setSaldoHorasExtras(Integer.parseInt(horasSplit) * calcularPorcentaje);
                    }
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 100")) {
                        float calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje().floatValue(), salarioPorHora);
                        //x.setPrSaldoHorasExtras100(BigDecimal.valueOf(Integer.parseInt(horasSplit) * calcularPorcentaje).setScale(decimalPlaces, BigDecimal.ROUND_DOWN));
                        z.setSaldoHorasExtras(Integer.parseInt(horasSplit) * calcularPorcentaje);
                    }

                    if (Integer.parseInt(minutosSplit) > 30 && z.getTipo().equalsIgnoreCase("horas suplementarias 25")){
                        float calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje().floatValue(), salarioPorMinutos);
                        //x.setCtaRecargoJornadaNocturna(BigDecimal.valueOf(Integer.parseInt(minutosSplit) * calcularPorcentaje).setScale(decimalPlaces, BigDecimal.ROUND_DOWN));
                        z.setSaldoHorasExtras(Integer.parseInt(horasSplit) * calcularPorcentaje);
                    }
                    if (Integer.parseInt(minutosSplit) > 30 && z.getTipo().equalsIgnoreCase("horas suplementarias 50")) {
                        float calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje().floatValue(), salarioPorMinutos);
                        //x.setPrSaldoHorasExtras50(BigDecimal.valueOf(Integer.parseInt(minutosSplit) * calcularPorcentaje).setScale(decimalPlaces, BigDecimal.ROUND_DOWN));
                        z.setSaldoHorasExtras(Integer.parseInt(horasSplit) * calcularPorcentaje);
                    }
                    if (Integer.parseInt(minutosSplit) > 30 && z.getTipo().equalsIgnoreCase("horas suplementarias 100")) {
                        float calcularPorcentaje = utility.calcularPorcentaje(z.getPorcentaje().floatValue(), salarioPorMinutos);
                        //x.setPrSaldoHorasExtras100(BigDecimal.valueOf(Integer.parseInt(minutosSplit) * calcularPorcentaje).setScale(decimalPlaces, BigDecimal.ROUND_DOWN));
                        z.setSaldoHorasExtras(Integer.parseInt(horasSplit) * calcularPorcentaje);
                    }

                    ///GUARDADO DE LOS LAS HORAS SUPLEMENTARIAS

                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 25"))
                    {
                       horasSuplementariasPersonalRepository.save(z);
                    }
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 50")) {
                        horasSuplementariasPersonalRepository.save(z);
                    }
                    if (Integer.parseInt(horasSplit) > 0 && z.getTipo().equalsIgnoreCase("horas suplementarias 100"))
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

}
