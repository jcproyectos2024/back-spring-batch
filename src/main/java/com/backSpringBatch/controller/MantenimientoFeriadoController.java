package com.backSpringBatch.controller;

import com.backSpringBatch.postgres.models.MantenimientoFeriadoDto;
import com.backSpringBatch.services.MantenimientoFeriadoServices;
import com.diosmar.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mantenimientoFeriado/")
public class MantenimientoFeriadoController
{
    @Autowired
    MantenimientoFeriadoServices mantenimientoFeriadoServices;

    @GetMapping("findAllMantenimientoFeriado/")
    public GenericResponse findAllMantenimientoFeriado()
    {
        return mantenimientoFeriadoServices.findAllMantenimientoFeriado();
    }

    @GetMapping("findByIdMantenimientoFeriado/")
    public GenericResponse findByIdMantenimientoFeriado(@RequestParam Long id)
    {
        return mantenimientoFeriadoServices.findByIdMantenimientoFeriado(id);
    }


    @PostMapping("saveUpdateMantenimientoFeriado/")
    public GenericResponse saveUpdateMantenimientoFeriado(@RequestBody List<MantenimientoFeriadoDto> mantenimientoFeriadoDto)
    {
        return mantenimientoFeriadoServices.saveUpdateMantenimientoFeriado(mantenimientoFeriadoDto);
    }


    @DeleteMapping("deleteMantenimientoFeriado/")
    public GenericResponse deleteMantenimientoFeriado(@RequestParam long id)
    {
        return mantenimientoFeriadoServices.deleteMantenimientoFeriado(id);
    }

    @PostMapping("consultarMantenimientoFeriadoPagineo/")
    public GenericResponse consultarMantenimientoFeriadoPagineo( @RequestBody Map<String, Object> body )
    {
        return mantenimientoFeriadoServices.consultarMantenimientoFeriadoPagineo(body);
    }
}
