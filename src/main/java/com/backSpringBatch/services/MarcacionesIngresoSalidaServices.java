package com.backSpringBatch.services;

import com.backSpringBatch.Util.Utily;
import com.backSpringBatch.postgres.models.ResponsePeriodoActual;
import com.backSpringBatch.postgres.models.ResponsePersonaProduccionFija;
import com.backSpringBatch.postgres.repository.MarcacionesIngresoSalidaRepository;
import com.diosmar.GenericExceptionUtils;
import com.diosmar.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class MarcacionesIngresoSalidaServices
{
    @Autowired
    MarcacionesIngresoSalidaRepository marcacionesIngresoSalidaRepository;
    @Autowired
    private Utily utily;
    @Autowired
    private RESTServices restServices;

    public void findAllMarcacionesIngresoSalida()
    {
        ResponsePeriodoActual periodoActual =restServices.consultarPeriodoActual();
        try
        {
            ResponsePersonaProduccionFija responsePersonaProduccionFija =restServices.consultarPersonaProduccionFijaCalculo("PRODUCCIÓN FIJA");
            String[] fechaPeriodo= utily.fechaPeriodoSplit(periodoActual.getPeriodoAsistencia());
            marcacionesIngresoSalidaRepository.findAllByIngresoSalida(fechaPeriodo[0],fechaPeriodo[1],false).ifPresentOrElse(  marcacionesIngresoSalidaList ->
            {
                Utils.console("marcacionesIngresoSalidaList",Utils.toJson(marcacionesIngresoSalidaList));
                if (responsePersonaProduccionFija.isSuccess())
                {
                    responsePersonaProduccionFija.getPersonaProduccionFijaDtoList().forEach(x ->
                    {
                        try
                        {
                            calculoHorasSuplementariasProduccionXPersona(x.getIdentificacion(), x.getEmpNombre(),periodoActual);
                            //calculoHorasSuplementariasProduccionXPersona("0917425266", "PROCAMARONEX",periodoActual);
                            calculoNominaProduccionFija.calculoNominaProduccionFija(x.getIdentificacion(),x.getSueldo(),periodoActual.getPeriodoAsistencia());
                            //calculoNominaProduccionFija.calculoNominaProduccionFija("0917425266", (float) 458.64,periodoActual.getPeriodoAsistencia());
                        } catch (Exception e)
                        {
                            throw new GenericExceptionUtils(e);
                        }
                    });
                    System.out.println("***********************AQUI-----"+utily.convertirDateString(new Date()));
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

}
