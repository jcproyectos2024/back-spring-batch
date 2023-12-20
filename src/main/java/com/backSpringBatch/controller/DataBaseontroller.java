package com.backSpringBatch.controller;


import com.backSpringBatch.Util.SaveMantDTO;
import com.backSpringBatch.Util.UtilsJSON;
import com.backSpringBatch.dto.*;
import com.backSpringBatch.postgres.models.*;
import com.backSpringBatch.postgres.models.Master.MarcacionIndentificacionResponses;
import com.backSpringBatch.services.BiometricoServices;
import com.backSpringBatch.services.DataBaseServices;
import com.backSpringBatch.sqlserver.models.ResponsesEntradaSalidaMarcacionDias;
import com.diosmar.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


@Controller
@RestController
@RequestMapping("/api/marcaciones/")
public class DataBaseontroller {
	@Autowired
	private DataBaseServices dataBaseServices;
	@Autowired
	private BiometricoServices biometricoServices;


	/*@Scheduled (cron = "0/3 * * ? * *")
	public void insertSqlToPostgres() {
		dataBaseServices.insertSqlToPostgres();
	}*/

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
	public RegistroMarcacionesResponses guardadoEntradaSalidaMarcacion(@RequestBody @Validated List<RegistroMarcacionesDTO> registroMarcacionesDTO)
	{
		Utils.console("registroMarcacionesDTOLista",Utils.toJson(registroMarcacionesDTO));
		return dataBaseServices.guardadoEntradaSalidaMarcacion(registroMarcacionesDTO);
	}

	@PostMapping("consultarEntradaSalidaMarcacionPorDia/")
	public ResponsesEntradaSalidaMarcacionDias consultarEntradaSalidaMarcacionPorDia(@RequestBody @Validated ConsultarAsistenciasDias body)
	{
		return dataBaseServices.consultarEntradaSalidaMarcacionPorDia(body);
	}

	@GetMapping("calculoHorasSuplementariasProduccionXPersona/")
	public HorasSuplementariasPersonalResponses calculoHorasSuplementariasProduccionXPersona(@RequestParam String identificacion,@RequestParam  String empresa  ) throws Exception
	{
		return dataBaseServices.calculoHorasSuplementariasProduccionXPersona(identificacion,empresa);
	}
	@GetMapping("findAllByBiometricoEmpresa/")
	public BiometricoResponse findAllByBiometricoEmpresa(@RequestParam String empresa)
	{
		return biometricoServices.findAllByBiometricoEmpresa(empresa);
	}

	@PostMapping("consultarMarcacionIdentificacion/")
	public MarcacionIndentificacionResponses consultarMarcacionIdentificacion(@RequestBody String json)
	{
		Map<String, Object> map = UtilsJSON.jsonToMap(json);
		String empresa = UtilsJSON.jsonToObjeto(String.class, map.get("empresa"));
		String identificacion = UtilsJSON.jsonToObjeto(String.class, map.get("identificacion"));
		String apellidos = UtilsJSON.jsonToObjeto(String.class, map.get("apellidos"));
		return dataBaseServices.consultarMarcacionIdentificacion(identificacion,apellidos,empresa);
	}

		//@Scheduled (cron = "0/3 * * ? * *")
	//cada dos horas
		//@Scheduled (cron = "0 0 */2 * * ?")
		//@Scheduled (cron = "0/15 0 * * * ?")
		//@Scheduled(cron = "0 0 */6 * * *")//cada 6 hora
		//@Scheduled(cron = "0 0 */12 * * *")//12 horas
		//@Scheduled(cron = "0 0 */8 * * *")8 horas
		//@Scheduled(cron = "0 * * * * *")//cada un minutos
		@Scheduled(cron = "0 0 */1 * * *")//cada 6 hora
	  public void calculoHorasSuplementariasProduccionFija() {
		dataBaseServices.calculoHorasSuplementariasProduccionFija();
	}


}
	
