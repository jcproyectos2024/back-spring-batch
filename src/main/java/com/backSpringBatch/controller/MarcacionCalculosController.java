package com.backSpringBatch.controller;

import com.backSpringBatch.services.MarcacionesIngresoSalidaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/marcacionCalculos/")
public class MarcacionCalculosController
{
    @Autowired
    MarcacionesIngresoSalidaServices marcacionesIngresoSalidaServices;

    @GetMapping("findAllMarcacionesIngresoSalida/")
    public void findAllMarcacionesIngresoSalida()
    {
        marcacionesIngresoSalidaServices.findAllMarcacionesIngresoSalida2();
    }


}
