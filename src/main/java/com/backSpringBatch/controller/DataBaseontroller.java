package com.backSpringBatch.controller;


import com.backSpringBatch.Util.SaveMantDTO;
import com.backSpringBatch.postgres.models.ResponseAsistNowPagination;
import com.backSpringBatch.postgres.models.SearchMarcaDTO;
import com.backSpringBatch.services.DataBaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



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

	@GetMapping("estadoJustificacion/")
	public SaveMantDTO estadoJustificacion(@RequestParam Boolean justificacion, @RequestParam String identificacion){
		return  dataBaseServices.justificacion(justificacion, identificacion);
	}

//	@GetMapping("simulatorMarcaciones/")
//	public void simulatorMarcaciones (Boolean inicio ) throws InterruptedException {
//		dataBaseServices.simulatorMarcaciones(inicio);
//	}

//	@GetMapping("calcularHora")
//	public String calcularHora(@RequestParam String identificaicion, @RequestParam String hora){
//		return dataBaseServices.calcularHora(identificaicion, hora);
//	}

}
	
