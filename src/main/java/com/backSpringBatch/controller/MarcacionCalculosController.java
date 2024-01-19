package com.backSpringBatch.controller;

import com.backSpringBatch.services.MarcacionesIngresoSalidaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.scheduling.annotation.Scheduled;
@Controller
@RestController
@RequestMapping("/api/marcacionCalculos/")
public class MarcacionCalculosController
{
    @Autowired
    MarcacionesIngresoSalidaServices marcacionesIngresoSalidaServices;

    @Scheduled(cron = "0 0 */8 * * *")
    @GetMapping("findAllMarcacionesIngresoSalida/")
    public void findAllMarcacionesIngresoSalida()
    {
        marcacionesIngresoSalidaServices.calculoHorasExtrasCalculoHorasSuplementarias();
    }


}
