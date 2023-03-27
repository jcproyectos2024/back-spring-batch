package com.backSpringBatch.controller;


import com.backSpringBatch.postgres.models.AsistNowDTO;
import com.backSpringBatch.services.DataBaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RestController
@RequestMapping("/api/marcaciones/")
public class DataBaseontroller {
	@Autowired
	private DataBaseServices dataBaseServices;

	
	
	@Scheduled (cron = "0/3 * * ? * *")
	public void insertSqlToPostgres() {
		dataBaseServices.insertSqlToPostgres();
		System.out.println("Mensaje de cron:"+System.currentTimeMillis());

	}

	@GetMapping("obtenerMarcaciones/")

	public List<AsistNowDTO> obtenerMarcaciones(@RequestParam String idAsistnow){
		return dataBaseServices.obtenerMarcaciones(idAsistnow);
	}

//	@GetMapping("simulatorMarcaciones/")
//	public void simulatorMarcaciones (Boolean inicio ) throws InterruptedException {
//		dataBaseServices.simulatorMarcaciones(inicio);
//	}

}
	
