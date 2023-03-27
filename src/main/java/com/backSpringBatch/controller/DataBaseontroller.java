package com.backSpringBatch.controller;


import com.backSpringBatch.postgres.models.AsistNowDTO;
import com.backSpringBatch.postgres.models.ResponseAsistNowPagination;
import com.backSpringBatch.postgres.models.SearchMarcaDTO;
import com.backSpringBatch.services.DataBaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("obtenerMarcaciones/")
	public ResponseAsistNowPagination obtenerMarcaciones(@RequestBody @Validated SearchMarcaDTO search){
		return dataBaseServices.obtenerMarcaciones(search);
	}

//	@GetMapping("simulatorMarcaciones/")
//	public void simulatorMarcaciones (Boolean inicio ) throws InterruptedException {
//		dataBaseServices.simulatorMarcaciones(inicio);
//	}

}
	
