package com.backSpringBatch.services;

import com.backSpringBatch.Util.SaveMantDTO;
import com.backSpringBatch.Util.ScheduleDTO;
import com.backSpringBatch.Util.Utily;
import com.backSpringBatch.dto.HorasSuplementariasPersonalDto;
import com.backSpringBatch.postgres.entity.*;
import com.backSpringBatch.postgres.mapper.AsistNowMapper;
import com.backSpringBatch.postgres.mapper.AtrasosMapper;
import com.backSpringBatch.postgres.mapper.HorasProduccionMapper;
import com.backSpringBatch.postgres.mapper.HorasSuplementariasPersonalMapper;
import com.backSpringBatch.postgres.models.*;
import com.backSpringBatch.postgres.repository.*;
import com.backSpringBatch.sqlserver.entity.AsistNowRegistro;
import com.backSpringBatch.sqlserver.mapper.AsisRegistroMapper;
import com.backSpringBatch.sqlserver.repository.SQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class DataBaseServices {


    @Autowired
    private SQLRepository sqlRepository;

    @Autowired
    private PostGresRepository postGresRepository;

    @Autowired
    private AsisRegistroMapper asisRegistroMapper;

    @Autowired
    private AsistNowMapper asistNowMapper;

    @Autowired
    private AtrasosRepository atrasosRepository;

    @Autowired
    private RESTServices restServices;

    @Autowired
    private HorasProduccionTempRepository horaTempRepository;

    @Autowired
    private AtrasosMapper atrasosMapper;

    @Autowired
    private HorasProduccionRepository horasProduccionRepository;

    @Autowired
    private HorasProduccionMapper produccionMapper;

    @Autowired
    private BiometricoRepository biometricoRepository;
    
    @Autowired
    private AsistNowRefactorRepository asistNowRefactorRepository;

    @Autowired
    private Utily utily;

    @Autowired
    private HorasSuplementariasPersonalRepository horasSuplementariasPersonalRepository;
    
    @Autowired
    private PoliticasHorasSupleRepository politicasHorasSupleRepository;

    @Autowired
    private HorasSuplementariasPersonalMapper  horasSuplementariasPersonalMapper;

    @Transactional(rollbackFor = { Exception.class })
    public void insertSqlToPostgres(){

        try{
            SimpleDateFormat sdfResult = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<AsistNowRegistro> lsRegistros=sqlRepository.findAll();
            lsRegistros.forEach(x->{
                AsistNow regActual=asisRegistroMapper.asistNowRegistroToAsistNow(x);
                postGresRepository.save(regActual);
                
                //aqui se inserta el refactorizado 
                //ini will 10/05/23
                AsistNowRefactor busquedaRef=asistNowRefactorRepository.findByAsisFechaAndIdentificacion(x.getAsisFecha(), x.getIdentificacion());
                if(busquedaRef!=null) {
                	if(x.getAsisTipo().equals("SALIDA")) {
                		busquedaRef.setHoraSalida((busquedaRef.getHoraSalida()!=null?busquedaRef.getHoraSalida()+"\n"+x.getAsisHora():x.getAsisHora()));
                	}else if(x.getAsisTipo().equals("BREAK-OUT")) {
                		busquedaRef.setHoraAlmuerzo((busquedaRef.getHoraAlmuerzo()!=null?busquedaRef.getHoraAlmuerzo()+"\n"+x.getAsisHora():x.getAsisHora()));
                	}else if(x.getAsisTipo().equals("INGRESO")) {
                		busquedaRef.setHoraIngreso((busquedaRef.getHoraIngreso()!=null?busquedaRef.getHoraIngreso()+"\n"+x.getAsisHora():x.getAsisHora()));
                	}
                	asistNowRefactorRepository.save(busquedaRef);
                }else {
                	
                	AsistnowPK pkAsist=new AsistnowPK();
                	pkAsist.setAsisId(x.getId().getAsisId());
                	pkAsist.setAsisIng(x.getId().getAsisIng());
                	pkAsist.setAsisZona(x.getId().getAsisZona());                	
                	busquedaRef=new AsistNowRefactor(pkAsist, 
                			x.getAsisFecha(), 
                			x.getAsisHora(),
                			x.getAsisTipo(), 
                			x.getAsisRes(), 
                			x.getIdentificacion(), 
                			null, 
                			null, 
                			null);
                	if(x.getAsisTipo().equals("SALIDA")) {
                		busquedaRef.setHoraSalida(x.getAsisHora());
                	}else if(x.getAsisTipo().equals("BREAK-OUT")) {
                		busquedaRef.setHoraAlmuerzo(x.getAsisHora());
                	}else if(x.getAsisTipo().equals("INGRESO")) {
                		busquedaRef.setHoraIngreso(x.getAsisHora());
                	}
                	asistNowRefactorRepository.save(busquedaRef);
                }
                //fin will 10/05/23
                


                Biometrico bio = biometricoRepository.findByIpBiometrico(regActual.getId().getAsisZona());
                //Validar si existe un atraso
                Atrasos atra= atrasosRepository.findByIdentificacionAndAndFecha(regActual.getIdentificacion(), regActual.getAsisFecha());
                if(atra==null) {
                    if (bio.getTipoBiometrinco().equals("INGRESO") && bio.getNombreBiometrico().equals("GARITA") && x.getIdentificacion() != null)
                    {

                       Date horaGrupo = (obtenerhoraGrupo(regActual.getIdentificacion()));
                       if (horaGrupo!=null)
                       {
                        //Validar hora ingreso
                        Date difference = utily.getDifferenceBetwenDates(horaGrupo, regActual.getId().getAsisIng());
                        String horaVerificacion = sdfResult.format(difference);
                        if(!horaVerificacion.equals("00:00:00") ) {
                            Atrasos atrasos = new Atrasos();
                            atrasos.setId(regActual.getId());
                            atrasos.setIdentificacion(regActual.getIdentificacion() != null ? regActual.getIdentificacion() : "");
                            atrasos.setFecha(regActual.getAsisFecha());
                            atrasos.setJustificacion(Boolean.FALSE);
                            atrasos.setTiempoAtraso(horaVerificacion);
                            atrasosRepository.save(atrasos);
                            postGresRepository.save(regActual);
                        }
                       }
                    }
                }
                if( bio.getNombreBiometrico().equals("PLANTA")){
                    HorasProduccionTemp horasTemp= new HorasProduccionTemp();
                    horasTemp.setId(regActual.getId());
                    horasTemp.setIdentificacion(regActual.getIdentificacion());
                    horasTemp.setTipo(regActual.getAsisTipo());
                    horasTemp.setStatus(Boolean.FALSE);
                    horaTempRepository.save(horasTemp);

                    List<HorasProduccionTemp> horas= horaTempRepository.findByIdentificacion(regActual.getIdentificacion());
                    HorasProduccion horasProd = horasProduccionRepository.findByIdentificacionAndFecha(regActual.getIdentificacion(), regActual.getAsisFecha());
                    if(horas.size()>1) {
                        HorasProduccion horasProduccion = new HorasProduccion();
                        HorasProduccionTemp ingreso = horas.get(0);
                        HorasProduccionTemp salida = horas.get(1);
                        //horas producidas
                        Date calHora = utily.getDifferenceBetwenDates(ingreso.getId().getAsisIng(), salida.getId().getAsisIng());
                        ingreso.setStatus(Boolean.TRUE);
                        salida.setStatus(Boolean.TRUE);
                        horaTempRepository.save(ingreso);
                        horaTempRepository.save(salida);
                        if(horasProd ==null){
                            horasProduccion.setId(regActual.getId());
                            horasProduccion.setIdentificacion(regActual.getIdentificacion());
                            horasProduccion.setFecha(regActual.getAsisFecha());
                            try {
                                Date date = format.parse(String.valueOf(calHora));
                                horasProduccion.setCalHorasProd(date);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            horasProduccion.setCalHorasProd(calHora);
                            String hora = sdfResult.format(calHora);
                            horasProduccion.setHorasProduccion(hora);
                            horasProduccionRepository.save(horasProduccion);
                        }
                        else {
                             Date calPro= utily.getSumBetwenDates(horasProd.getCalHorasProd(),calHora);
                                horasProd.setCalHorasProd(calPro);
                                String hora= sdfResult.format(calPro);
                                horasProd.setHorasProduccion(hora);
                            horasProduccionRepository.save(horasProd);
                        }
                    }
                    List<HorasProduccionTemp> temp= horaTempRepository.findAll();
                    temp.forEach(t->{
                       if( t.getStatus()){
                           horaTempRepository.delete(t);
                       }
                    });  
                    
                }
                
                //logica para el calculo de las horas suplementarias de producción
                if(bio.getNombreBiometrico().equals("GARITA") && bio.getTipoBiometrinco().equals("SALIDA")) {

                	try {
                    	String fechaActual=utily.obtenerFechaActual(x.getId().getAsisIng());
						String fechaActualMenosDias=utily.obtenerFechaMenosDias(1, x.getId().getAsisIng());
						Biometrico bioObtenido=biometricoRepository.findByTipoBiometrincoAndNombreBiometrico("INGRESO","GARITA");
						List<AsistNow> lsMarcacionesEntradaGarita=postGresRepository.findByElementByFechas(fechaActualMenosDias, fechaActual,x.getIdentificacion(),bioObtenido.getIpBiometrico(), Sort.by(Sort.Direction.DESC,"asisFecha"));						
						/*
						 * Filtrado por las fechas ahora se debe de obtener la fecha y hora de la marcacion de entrada
						 * y la fecha y hora de la marcacion de salida 
						 * */
						if(lsMarcacionesEntradaGarita.size()>0) {
							
							//se obtiene la marcacion de entrada y salida de garita actual 
							
							AsistNow marcacionSalidaG=regActual;							
							AsistNow marcacionEntradaG=lsMarcacionesEntradaGarita.get(0);
							//se obtiene todas las marcaciones de entrada y salida de planta
							Biometrico bioIngresoPlanta=biometricoRepository.findByTipoBiometrincoAndNombreBiometrico("INGRESO","PLANTA");
							Biometrico biosSalidaPlanta=biometricoRepository.findByTipoBiometrincoAndNombreBiometrico("SALIDA","PLANTA");

							List<AsistNow> lsIngresoPlanta=postGresRepository.findByElementByFechas(utily.obtenerFechaActual(marcacionEntradaG.getAsisFecha()),  utily.obtenerFechaActual(marcacionSalidaG.getAsisFecha()),x.getIdentificacion(),bioIngresoPlanta.getIpBiometrico(), Sort.by(Sort.Direction.ASC,"asisFecha"));						
							List<AsistNow> lsSalidaPlanta=postGresRepository.findByElementByFechas(utily.obtenerFechaActual(marcacionEntradaG.getAsisFecha()),  utily.obtenerFechaActual(marcacionSalidaG.getAsisFecha()),x.getIdentificacion(),biosSalidaPlanta.getIpBiometrico(), Sort.by(Sort.Direction.DESC,"asisFecha"));						

							AsistNow igPlantaHora=lsIngresoPlanta.get(0);
							AsistNow salPlantaHora=lsSalidaPlanta.get(0);
							String horaIni=igPlantaHora.getAsisHora().replaceAll(":", "");
							String horaFin=salPlantaHora.getAsisHora().replaceAll(":", "");
							
							String rangoMarcadoFin=salPlantaHora.getAsisHora();
							
							if(igPlantaHora!=null && salPlantaHora!=null) {
		                       // Date difference = utily.getDifferenceBetwenDates(horaGrupo, regActual.getId().getAsisIng());
								List<PoliticasHorasSuple> lsPoliticas=politicasHorasSupleRepository.findByEstadoTrue();
								
								
							    
							        if(lsPoliticas.size()>0) {
							        	
										HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrue(x.getIdentificacion());
										if(horaPersonal==null) {
											horaPersonal=new HorasSuplementariasPersonal();
											horaPersonal.setIdentificacion(x.getIdentificacion());
										}
							        	
							 
							            
							            if(lsPoliticas.size()>0 && utily.horasMilisegundosGeneral(rangoMarcadoFin)>=utily.horasMilisegundosGeneral(lsPoliticas.get(0).getRangoHoraFinal())
							                    && 
							                    utily.horasMilisegundosGeneral(rangoMarcadoFin)<=utily.horasMilisegundosGeneral(lsPoliticas.get(lsPoliticas.size()-1).getRangoHoraFinal())
							                    ){
							                
							                Integer horaArrastrada=0;
							                horaArrastrada=utily.horasMilisegundosGeneral(rangoMarcadoFin)-utily.horasMilisegundosGeneral(lsPoliticas.get(0).getRangoHoraFinal());
							                                              System.out.println("horas arrastradas i:"+  horaArrastrada);

							                for(int i=0;i<lsPoliticas.size();i++) {
							                    PoliticasHorasSuple polHoras=lsPoliticas.get(i);
							                    if(i==0){
							                        if(utily.horasMilisegundosGeneral(rangoMarcadoFin)>=utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal())){
							                            horaArrastrada=horaArrastrada;//-utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal());
							                            /*Date difference = utily.getDifferenceBetwenDates(utily.concatenaHoraFechaActual(polHoras.getRangoHoraFinal(),1), utily.concatenaHoraFechaActual(polHoras.getRangoHoraInicial(),0));
							                            String horaActual = sdfResult.format(difference);*/
							                            Integer horasPaso=utily.horasMilisegundosGeneral("8:00:00");
							                            
							                            horaPersonal.setHoras(horaPersonal.getHoras()+horasPaso);
							                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
							                            
							                              System.out.println("horas arrastradas i:"+i+"   "+  horasPaso+"_____________Porcentaje:"+polHoras.getPorcentaje());
							                        }else{ 
							                            horaArrastrada=utily.horasMilisegundosGeneral(polHoras.getRangoHoraInicial())-horaArrastrada;
							                            
							                            horaPersonal.setHoras(horaPersonal.getHoras()+horaArrastrada);
							                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
							                            
							                            System.out.println("horas arrastradas i:"+i+"   "+  horaArrastrada+"_____________Porcentaje:"+polHoras.getPorcentaje());
							                            break;
							                        }
							                      
							                    }else if (i>0){
							                        Integer dif=utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal())-utily.horasMilisegundosGeneral(polHoras.getRangoHoraInicial());
							                       System.out.println("diferencia:"+dif);
							                        if(horaArrastrada>0 && horaArrastrada>=dif){
							                            horaArrastrada=horaArrastrada-dif;
							                            
							                            horaPersonal.setHoras(horaPersonal.getHoras()+horaArrastrada);
							                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
							                              System.out.println("horas arrastradas i:"+i+"   "+  horaArrastrada+"_____________Porcentaje:"+polHoras.getPorcentaje());
							                        }else if(horaArrastrada>60000 && horaArrastrada<dif){
							                            horaArrastrada= (utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal())-horaArrastrada)-utily.horasMilisegundosGeneral(polHoras.getRangoHoraInicial());
							                            
							                            horaPersonal.setHoras(horaPersonal.getHoras()+horaArrastrada);
							                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
							                            System.out.println("horas arrastradas i:"+i+"   "+  horaArrastrada+"_____________Porcentaje:"+polHoras.getPorcentaje());
							                              break;
							                        }
							                        
							                       // System.out.println("horas arrastradas:"+horaArrastrada);
							                    }
							                    
							                
							                }
							        
							            }
							        }
								
								
								
								
								
								
								
								
								
								
								
								/*
								if(lsPoliticas.size()>0) {
									HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrue(x.getIdentificacion());
									if(horaPersonal==null) {
										horaPersonal=new HorasSuplementariasPersonal();
										horaPersonal.setIdentificacion(x.getIdentificacion());
									}
									for(int i=0;i<lsPoliticas.size();i++) {
										PoliticasHorasSuple polHoras=lsPoliticas.get(i);
										if(i==0 && Integer.parseInt(horaIni)>=Integer.parseInt(polHoras.getRangoHoraInicial().replaceAll(":", ""))
												&& Integer.parseInt(horaFin)>=Integer.parseInt(polHoras.getRangoHoraFinal().replaceAll(":", ""))) {
											horaPersonal.setHoras(horaPersonal.getHoras()+8L);
										}else if(i>0 && Integer.parseInt(horaIni)>=Integer.parseInt(polHoras.getRangoHoraInicial().replaceAll(":", ""))) {
											String horaActual ="";
											if(Integer.parseInt(horaFin)>=Integer.parseInt(polHoras.getRangoHoraFinal().replaceAll(":", ""))) {
												Date difference = utily.getDifferenceBetwenDates(utily.concatenaHoraFechaActual(polHoras.getRangoHoraFinal()), utily.concatenaHoraFechaActual(polHoras.getRangoHoraInicial()));
							                    horaActual = sdfResult.format(difference);
											}else if(Integer.parseInt(horaFin)<=Integer.parseInt(polHoras.getRangoHoraFinal().replaceAll(":", ""))) {
												Date difference = utily.getDifferenceBetwenDates(utily.concatenaHoraFechaActual(salPlantaHora.getAsisHora()), utily.concatenaHoraFechaActual(polHoras.getRangoHoraInicial()));
							                    horaActual = sdfResult.format(difference);

											}
											horaPersonal.setHoras(horaPersonal.getHoras()+utily.horasMilisegundos(horaActual));
											horaPersonal.setPorcentaje(polHoras.getPorcentaje());
											horasSuplementariasPersonalRepository.save(horaPersonal);
										}
										
									}
									

								}*/
								
							}
							
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }

                sqlRepository.delete(x);
            });

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    

    

    //PAGINADO
    public ResponseAsistNowPagination obtenerMarcaciones (SearchMarcaDTO searchMarcaDTO) throws ParseException {

        ResponseAsistNowPagination exit = new ResponseAsistNowPagination();
        int totalReg = obtenermarcaGeneral(searchMarcaDTO).size();
        if (totalReg > 0) {
            int page = searchMarcaDTO.getPage() > 0 ? (searchMarcaDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, searchMarcaDTO.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            exit.setAsistNowDTOS(obtenerMarcaPag(pgRq, searchMarcaDTO));
            exit.setMessage("OK");
        }else {
            exit.setAsistNowDTOS(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");
        }
        return exit;
    }
    
    
    public ResponseAsistNowPagination obtenerMarcacionesRefactorizado (SearchMarcaDTO searchMarcaDTO) throws ParseException {

        ResponseAsistNowPagination exit = new ResponseAsistNowPagination();
        int totalReg = asistNowRefactorRepository.getIdAsistfiltro(searchMarcaDTO.getIdentificacion()).size();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<AsistNowDTO> lsAsistencia= new ArrayList<>();
        if (totalReg > 0) {
            int page = searchMarcaDTO.getPage() > 0 ? (searchMarcaDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, searchMarcaDTO.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            
            Page<AsistNowRefactor> lsRefactor=asistNowRefactorRepository.getIdAsistfiltroPagin(searchMarcaDTO.getIdentificacion(), pgRq);
            for(AsistNowRefactor ref:lsRefactor) {
            	AsistNowDTO asist=new AsistNowDTO();
                asist.setAsisId(ref.getId().getAsisId());
                Biometrico bio = biometricoRepository.findByIpBiometrico(ref.getId().getAsisZona());
                asist.setAsisZona(bio.getNombreBiometrico());
                asist.setAsisFecha(format.format(ref.getAsisFecha()));
                asist.setAsisHora(ref.getAsisHora());
                asist.setAsisTipo("");
                asist.setAsisIng(ref.getId().getAsisIng());
                asist.setHoraIngreso((ref.getHoraIngreso()!=null? ref.getHoraIngreso():""));
                asist.setHoraAlmuerzo((ref.getHoraAlmuerzo()!=null?ref.getHoraAlmuerzo():""));
                asist.setHoraSalida((ref.getHoraSalida()!=null?ref.getHoraSalida():""));
                lsAsistencia.add(asist);
            }
            exit.setAsistNowDTOS(lsAsistencia);
            exit.setMessage("OK");
        }else {
            exit.setAsistNowDTOS(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");
        }
        return exit;
    }

    public  List<AsistNowDTO> obtenermarcaGeneral(SearchMarcaDTO search){

        return asistNowMapper.toAsistNowDTOToAsistNow(postGresRepository.getIdAsistfiltro(search.getIdentificacion()));
    }

    public List<AsistNowDTO> obtenerMarcaPag( Pageable pag, SearchMarcaDTO search) throws ParseException {

        List<AsistNowDTO> exit= new ArrayList<>();
        Page<Object[]> asistObject =(postGresRepository.getIdAsistSinPag(search.getIdentificacion(), pag));
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(Object[] objects : asistObject){

            AsistNowDTO asist=new AsistNowDTO();
            asist.setAsisId(objects[0].toString());
            Biometrico bio = biometricoRepository.findByIpBiometrico(objects[1].toString());
            asist.setAsisZona(bio.getNombreBiometrico());
            asist.setAsisFecha(objects[2].toString());
            asist.setAsisHora(objects[3].toString());
            asist.setAsisTipo(objects[4].toString());
            Date date= format.parse(objects[5].toString());
            asist.setAsisIng(date);
            exit.add(asist);
        }
        return exit;
    }

    //PAGINADO
    public ResponseAsistNowPagination obtenerAtrasos (SearchMarcaDTO searchMarcaDTO) throws ParseException {

        ResponseAsistNowPagination exit = new ResponseAsistNowPagination();
        int totalReg = obtenerAtrasosGeneral(searchMarcaDTO).size();
        if (totalReg > 0) {
            int page = searchMarcaDTO.getPage() > 0 ? (searchMarcaDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, searchMarcaDTO.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            exit.setAsistNowDTOS(obtenerAtrasosPag(pgRq, searchMarcaDTO));
            exit.setMessage("OK");
        }else {
            exit.setAsistNowDTOS(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");

        }
        return exit;
    }

    public  List<AsistNowDTO> obtenerAtrasosGeneral(SearchMarcaDTO search){

        return atrasosMapper.toAsistNowDTOToAtrasos(atrasosRepository.getIdAtrasosfiltro(search.getIdentificacion()));
    }

    public List<AsistNowDTO> obtenerAtrasosPag( Pageable pag, SearchMarcaDTO search) throws ParseException {

        List<AsistNowDTO> exit= new ArrayList<>();
        Page<Object[]> asistObject =(atrasosRepository.getIdAtrasosPag(search.getIdentificacion(), pag));
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(Object[] objects : asistObject){

            AsistNowDTO asist=new AsistNowDTO();
            asist.setAsisId(objects[0].toString());
            Biometrico bio = biometricoRepository.findByIpBiometrico(objects[1].toString());
            asist.setAsisZona(bio.getNombreBiometrico());
            asist.setAsisFecha(objects[2].toString());
            asist.setAtraso(objects[3].toString()!=null?objects[3].toString():"");
            asist.setJustificacion(Boolean.valueOf(objects[4].toString()));
            Date date= format.parse(objects[5].toString());
            asist.setAsisIng(date);
            exit.add(asist);
        }
        return exit;
    }

    //PAGINADO
    public ResponseHorasProduccionPagination obtenerHorasProd(SearchMarcaDTO searchMarcaDTO) throws ParseException {
        ResponseHorasProduccionPagination exit = new ResponseHorasProduccionPagination();
        int totalReg = obtenerhorasProdGeneral(searchMarcaDTO).size();
        if (totalReg > 0) {
            int page = searchMarcaDTO.getPage() > 0 ? (searchMarcaDTO.getPage() - 1) : 0;
            PageRequest pgRq = PageRequest.of(page, searchMarcaDTO.getReg_por_pag());
            exit.setTotalRegister(totalReg);
            exit.setHorasProduccionDTO(obtenerhorasProdPag(pgRq, searchMarcaDTO));
            exit.setMessage("OK");
        }else {
            exit.setHorasProduccionDTO(null);
            exit.setTotalRegister(0);
            exit.setMessage("No existen datos");

        }
        return exit;
    }

    public  List<HorasProduccionDTO> obtenerhorasProdGeneral(SearchMarcaDTO search){

        return produccionMapper.toAsistNowDTOToHorasProduccion(horasProduccionRepository.getHorasProdfiltro(search.getIdentificacion()));
    }

    public List<HorasProduccionDTO> obtenerhorasProdPag( Pageable pag, SearchMarcaDTO search) throws ParseException {

        List<HorasProduccionDTO> exit= new ArrayList<>();
        Page<Object[]> asistObject =(horasProduccionRepository.getIdHorasProdPag(search.getIdentificacion(), pag));

        for(Object[] objects : asistObject){

            HorasProduccionDTO horas=new HorasProduccionDTO();
            horas.setAsisId(objects[0].toString());
            horas.setAsisFecha(objects[1].toString());
            horas.setHorasProd(objects[2].toString());
            exit.add(horas);
        }
        return exit;
    }

    public SaveMantDTO justificacion(JustificacionDTO justDTO){
        
        SaveMantDTO exit = new SaveMantDTO();

        Atrasos atrasos = atrasosRepository.findByIdentificacionAndAndId_AsisIng(justDTO.getIdentificacion(),justDTO.getFechaIng());

        if(atrasos.getJustificacion()){
            exit.setMessage("Ya exite una justificacion");
            return exit;
        }
        atrasos.setJustificacion(justDTO.getJustificacion());
        atrasosRepository.save(atrasos);
        exit.setMessage("Atraso Justificado");
        return exit;
    }

    public Date obtenerhoraGrupo(String identificacion){
        ScheduleDTO horaGupo= restServices.getSchedulePerson(identificacion);
        Date horaGrupo = horaGupo == null ? null : horaGupo.getDesde();
        //Date horaGrupo= horaGupo.getDesde();
        return  horaGrupo;
    }


	public String procesarDataGuardada() {
    	String exito="OK";
    	try {
    		//aqui se inserta el refactorizado 
            //ini will 10/05/23
    		List<AsistNow> lsAsistencias=postGresRepository.findAll();
    		lsAsistencias.stream().forEach(x->{
                AsistNowRefactor busquedaRef=asistNowRefactorRepository.findByAsisFechaAndIdentificacion(x.getAsisFecha(), x.getIdentificacion());
                if(busquedaRef!=null) {
                	if(x.getAsisTipo().equals("SALIDA")) {
                		busquedaRef.setHoraSalida((busquedaRef.getHoraSalida()!=null?busquedaRef.getHoraSalida()+"-"+x.getAsisHora():x.getAsisHora()));
                	}else if(x.getAsisTipo().equals("BREAK-OUT")) {
                		busquedaRef.setHoraAlmuerzo((busquedaRef.getHoraAlmuerzo()!=null?busquedaRef.getHoraAlmuerzo()+"-"+x.getAsisHora():x.getAsisHora()));
                	}else if(x.getAsisTipo().equals("INGRESO")) {
                		busquedaRef.setHoraIngreso((busquedaRef.getHoraIngreso()!=null?busquedaRef.getHoraIngreso()+"-"+x.getAsisHora():x.getAsisHora()));
                	}
                	asistNowRefactorRepository.save(busquedaRef);
                }else {
                	
                	AsistnowPK pkAsist=new AsistnowPK();
                	pkAsist.setAsisId(x.getId().getAsisId());
                	pkAsist.setAsisIng(x.getId().getAsisIng());
                	pkAsist.setAsisZona(x.getId().getAsisZona());                	
                	busquedaRef=new AsistNowRefactor(pkAsist, 
                			x.getAsisFecha(), 
                			x.getAsisHora(),
                			"", 
                			x.getAsisRes(), 
                			x.getIdentificacion(), 
                			null, 
                			null, 
                			null);
                	if(x.getAsisTipo().equals("SALIDA")) {
                		busquedaRef.setHoraSalida(x.getAsisHora());
                	}else if(x.getAsisTipo().equals("BREAK-OUT")) {
                		busquedaRef.setHoraAlmuerzo(x.getAsisHora());
                	}else if(x.getAsisTipo().equals("INGRESO")) {
                		busquedaRef.setHoraIngreso(x.getAsisHora());
                	}
                	asistNowRefactorRepository.save(busquedaRef);
                }
    		});
    		

            //fin will 10/05/23
		} catch (Exception e) {
			exito=e.getMessage();
			// TODO: handle exception
		}
		return exito;
	}


















//*/public void simulatorMarcaciones (Boolean inicio) throws InterruptedException {
//
//if(inicio){
//            String [] maracaciones = new String[5];
//            maracaciones[0] ="002864";
//            maracaciones[1] ="002865";
//            maracaciones[2] ="002866";
//            maracaciones[3] ="002867";
//            maracaciones[4] ="002868";
//
//            String[] biometrico = new String[2];
//            biometrico[0] = "192.168.9.102";
//            biometrico[1]= "192.168.9.101";
//
//            String[] tipo = new String[2];
//            tipo[0]= "INGRESO";
//            tipo[1]= "SALIDA";
//
//
//            while(1==1) {
//                AsistNowSql sql = new AsistNowSql();
//                String id = maracaciones[(1 + new Random().nextInt(4))];
//                String zona = biometrico[(1 + new Random().nextInt(1))];
//                String tip = tipo[(1 + new Random().nextInt(1))];
//
//                AsistnowRegistroPK asispk = new AsistnowRegistroPK();
//                asispk.setAsisId(id);
//                asispk.setAsisIng(obtenergetdateNow());
//                asispk.setAsisZona(zona);
//
//                sql.setId(asispk);
//                sql.setAsisTipo(tip);
//                sql.setAsisFecha(obtenergetdateNow());
//                sql.setAsisHora(getHourNow());
//                sql.setAsisRes("OK");
//
//                asistNowSqlRepository.save(sql);
//                System.out.println("Resultado"+" "+sql);
//
//                Thread.sleep(3000);
//                ;
//            }
//
//
//        }
//}



    public HorasSuplementariasPersonalResponses findAllByHorasSuplementariasPersonal()
    {
        HorasSuplementariasPersonalResponses response = new HorasSuplementariasPersonalResponses();
        try {

            List<HorasSuplementariasPersonal> horasSuplementariasPersonalList = horasSuplementariasPersonalRepository.findAllByEstadoTrue();
            List<HorasSuplementariasPersonalDto>  horasSuplementariasPersonalDtoList = horasSuplementariasPersonalMapper.toHorasSuplementariasPersonalDtoList(horasSuplementariasPersonalList);
            response.setHorasSuplementariasPersonalDtoList(horasSuplementariasPersonalDtoList);
            response.setMensaje("ok");
            response.setTotalRegistros(horasSuplementariasPersonalDtoList.size());
            response.setSuccess(true);
            return response;

        }catch (Exception e) {
            // TODO: handle exception
            response.setMensaje(e.getMessage());
            response.setSuccess(false);
            return response;
        }

    }


}
