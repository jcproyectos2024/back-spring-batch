package com.backSpringBatch.controller;


import com.backSpringBatch.Util.SaveMantDTO;
import com.backSpringBatch.Util.Utily;
import com.backSpringBatch.postgres.entity.AsistNow;
import com.backSpringBatch.postgres.models.JustificacionDTO;
import com.backSpringBatch.postgres.models.ResponseAsistNowPagination;
import com.backSpringBatch.postgres.models.ResponseHorasProduccionPagination;
import com.backSpringBatch.postgres.models.SearchMarcaDTO;
import com.backSpringBatch.services.DataBaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


@Controller
@RestController
@RequestMapping("/api/marcaciones/")
public class DataBaseontroller {
	@Autowired
	private DataBaseServices dataBaseServices;

	@Autowired
	private Utily utily;

	
	
	@Scheduled (cron = "0/3 * * ? * *")
	public void insertSqlToPostgres() {
		dataBaseServices.insertSqlToPostgres();
		System.out.println("Mensaje de cron:"+System.currentTimeMillis());
	}

	/*metodo anterior, ahora estara el refactorizado
	@PostMapping("obtenerMarcaciones/")
	public ResponseAsistNowPagination obtenerMarcaciones(@RequestBody @Validated SearchMarcaDTO search) throws ParseException {
		return dataBaseServices.obtenerMarcaciones(search);
	}
	*/
	@PostMapping("obtenerMarcaciones/")
	public ResponseAsistNowPagination obtenerMarcaciones(@RequestBody @Validated SearchMarcaDTO search) throws ParseException {
		return dataBaseServices.obtenerMarcacionesRefactorizado(search);
	}

	@PostMapping("obtenerAtrasos/")
	public ResponseAsistNowPagination obtenerAtrasos(@RequestBody @Validated SearchMarcaDTO search) throws ParseException {
		return dataBaseServices.obtenerAtrasos(search);
	}

	@PostMapping("obtenerHorasProd/")
	public ResponseHorasProduccionPagination obtenerHorasProd(@RequestBody @Validated SearchMarcaDTO search) throws ParseException {
		return dataBaseServices.obtenerHorasProd(search);
	}

	@PostMapping("estadoJustificacion/")
	public SaveMantDTO estadoJustificacion(@RequestBody @Validated JustificacionDTO justDTO){
		return  dataBaseServices.justificacion(justDTO);
	}

	
	
	@GetMapping("obtenerRegistrosPaginadoLista/")
	public List<AsistNow> obtenerRegistrosPaginadoLista(@RequestParam int numberPage, 
			@RequestParam int pageSize,
			@RequestParam String fechaRegistro) {
		return dataBaseServices.pruebaPaginado(numberPage,pageSize,fechaRegistro);
	}
	
	
	@GetMapping("procesarDataGuardada/")
	public String procesarDataGuardada() {
		return dataBaseServices.procesarDataGuardada();
	}
	
	
//	@GetMapping("sumarHoras")
//	public Date sumaHoras (@RequestParam Date dateInicio, Date dateFinal){
//		return utily.getSumBetwenDates(dateInicio, dateFinal);
//
//	}

//	@GetMapping("simulatorMarcaciones/")
//	public void simulatorMarcaciones (Boolean inicio ) throws InterruptedException {
//		dataBaseServices.simulatorMarcaciones(inicio);
//	}

//	@GetMapping("calcularHora")
//	public String calcularHora(@RequestParam String identificaicion, @RequestParam String hora){
//		return dataBaseServices.calcularHora(identificaicion, hora);
//	}

}
	
