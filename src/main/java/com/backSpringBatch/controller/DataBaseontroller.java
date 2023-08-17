package com.backSpringBatch.controller;


import com.backSpringBatch.Util.SaveMantDTO;
import com.backSpringBatch.dto.ConsultarEntradaSalida;
import com.backSpringBatch.dto.ConsultarEntradaSalidaMarcacionResponses;
import com.backSpringBatch.dto.RegistroMarcacionesDTO;
import com.backSpringBatch.dto.RegistroMarcacionesResponses;
import com.backSpringBatch.postgres.models.*;
import com.backSpringBatch.services.DataBaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;



@Controller
@RestController
@RequestMapping("/api/marcaciones/")
public class DataBaseontroller {
	@Autowired
	private DataBaseServices dataBaseServices;


	@Scheduled (cron = "0/50 * * ? * *")
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


	@PostMapping("findAllByHorasSuplementariasPersonal/")
	public HorasSuplementariasPersonalResponses findAllByHorasSuplementariasPersonal(@RequestBody @Validated HorasSuplementariasPersonalBody  HorasSuplementariasPersonalBody)
	{

		return dataBaseServices.findAllByHorasSuplementariasPersonal(HorasSuplementariasPersonalBody);
	}


	@PostMapping("consultarEntradaSalidaMarcacion/")
	public ConsultarEntradaSalidaMarcacionResponses consultarEntradaSalidaMarcacion(@RequestBody @Validated ConsultarEntradaSalida consultarEntradaSalida)
	{

		return dataBaseServices.consultarEntradaSalidaMarcacion(consultarEntradaSalida);
	}


	@PostMapping("guardadoEntradaSalidaMarcacion/")
	public RegistroMarcacionesResponses guardadoEntradaSalidaMarcacion(@RequestBody @Validated RegistroMarcacionesDTO registroMarcacionesDTO)
	{

		return dataBaseServices.guardadoEntradaSalidaMarcacion(registroMarcacionesDTO);
	}
}
	
