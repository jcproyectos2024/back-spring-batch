package com.backSpringBatch.services;

import com.backSpringBatch.Util.SaveMantDTO;
import com.backSpringBatch.Util.Utily;
import com.backSpringBatch.dto.*;
import com.backSpringBatch.postgres.entity.*;
import com.backSpringBatch.postgres.mapper.*;
import com.backSpringBatch.postgres.models.*;
import com.backSpringBatch.postgres.repository.*;
import com.backSpringBatch.sqlserver.entity.AsistNowRegistro;
import com.backSpringBatch.sqlserver.mapper.AsisRegistroMapper;
import com.backSpringBatch.sqlserver.models.AsistNowRegistroDTO;
import com.backSpringBatch.sqlserver.models.MarcacionesMongo;
import com.backSpringBatch.sqlserver.models.ResponsesEntradaSalidaMarcacionDias;
import com.backSpringBatch.sqlserver.repository.SQLRepository;
import com.diosmar.LogProducer;
import com.diosmar.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


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
    @Autowired
    RegistroMarcacionesMapper registroMarcacionesMapper;
    @Autowired
    private Environment ev;
    @Autowired
    LogProducer logProducer;
    @Transactional(rollbackFor = { Exception.class })
    public void insertSqlToPostgres(){

        final Object[] asistNowRegistroError = {null};
        try{
            SimpleDateFormat sdfResult = new SimpleDateFormat("HH:mm:ss");
           // SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //List<AsistNowRegistro> lsRegistros=sqlRepository.findAll();
            List<AsistNowRegistro>   lsRegistros = sqlRepository.findAllByEstadoAsistnowRegistroTrue();
                if ( !(lsRegistros ==null ? new ArrayList<>():lsRegistros).isEmpty()) {
                  // System.out.println("lsRegistros Cantidad" + lsRegistros.size());
                    //   lsRegistros.forEach(x->{
                    lsRegistros.forEach(x -> {
                        asistNowRegistroError[0] =Utils.toJson(x);
                        AsistNow regActual = asisRegistroMapper.asistNowRegistroToAsistNow(x);
                        Biometrico biometricoGuarado = biometricoRepository.findByIpBiometrico(regActual.getId().getAsisZona());
                        regActual.setBiometrico(biometricoGuarado);
                        //  postGresRepository.save(regActual);
                        postGresRepository.findById_AsisIdAndId_AsisIngAndId_AsisZona(regActual.getId().getAsisId(), regActual.getId().getAsisIng(), regActual.getId().getAsisZona()).ifPresentOrElse(asistNow ->
                        {
                          // System.out.println("YA ESTA GUARDADO");
                        }, () -> {
                          //  System.out.println("NUEVO.");
                            postGresRepository.save(regActual);
                        });

                        //  guardadoHistorialMarcaciones(regActual);
                        //aqui se inserta el refactorizado
                        //ini will 10/05/23
                        AsistNowRefactor busquedaRef = asistNowRefactorRepository.findByAsisFechaAndIdentificacion(x.getAsisFecha(), x.getIdentificacion());
                        if (busquedaRef != null) {
                            if (x.getAsisTipo().equals("SALIDA")) {
                                busquedaRef.setHoraSalida((busquedaRef.getHoraSalida() != null ? busquedaRef.getHoraSalida() + "\n" + x.getAsisHora() : x.getAsisHora()));
                            } else if (x.getAsisTipo().equals("BREAK-OUT")) {
                                busquedaRef.setHoraAlmuerzo((busquedaRef.getHoraAlmuerzo() != null ? busquedaRef.getHoraAlmuerzo() + "\n" + x.getAsisHora() : x.getAsisHora()));
                            } else if (x.getAsisTipo().equals("INGRESO")) {
                                busquedaRef.setHoraIngreso((busquedaRef.getHoraIngreso() != null ? busquedaRef.getHoraIngreso() + "\n" + x.getAsisHora() : x.getAsisHora()));
                            }
                            asistNowRefactorRepository.save(busquedaRef);
                        } else {

                            AsistnowPK pkAsist = new AsistnowPK();
                            pkAsist.setAsisId(x.getId().getAsisId());
                            pkAsist.setAsisIng(x.getId().getAsisIng());
                            pkAsist.setAsisZona(x.getId().getAsisZona());
                            busquedaRef = new AsistNowRefactor(pkAsist,
                                    x.getAsisFecha(),
                                    x.getAsisHora(),
                                    x.getAsisTipo(),
                                    x.getAsisRes(),
                                    x.getIdentificacion(),
                                    null,
                                    null,
                                    null);
                            if (x.getAsisTipo().equals("SALIDA")) {
                                busquedaRef.setHoraSalida(x.getAsisHora());
                            } else if (x.getAsisTipo().equals("BREAK-OUT")) {
                                busquedaRef.setHoraAlmuerzo(x.getAsisHora());
                            } else if (x.getAsisTipo().equals("INGRESO")) {
                                busquedaRef.setHoraIngreso(x.getAsisHora());
                            }
                            asistNowRefactorRepository.save(busquedaRef);
                        }
                        //fin will 10/05/23


                        //   System.out.println("regActual.getId().getAsisZona()"+regActual.getId().getAsisZona());
                        Biometrico bio = biometricoRepository.findByIpBiometrico(regActual.getId().getAsisZona());
                        //Validar si existe un atraso
                        Atrasos atra = atrasosRepository.findByIdentificacionAndAndFecha(regActual.getIdentificacion(), regActual.getAsisFecha());
                        if (atra == null) {
                            if ((bio == null ? "" : bio.getTipoBiometrinco()).equals("INGRESO") && (bio == null ? "" : bio.getNombreBiometrico()).equals("GARITA") && x.getIdentificacion() != null) {

                                Date horaGrupo = (obtenerhoraGrupo(regActual.getIdentificacion()));
                                //   System.out.println("horaGrupo"+horaGrupo);
                                if (horaGrupo != null) {
                                    //Validar hora ingreso
                                    Date difference = utily.getDifferenceBetwenDates(horaGrupo, regActual.getId().getAsisIng());
                                    String horaVerificacion = sdfResult.format(difference);
                                    if (!horaVerificacion.equals("00:00:00")) {
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
                        if ((bio == null ? "" : bio.getNombreBiometrico()).equals("PLANTA")) {
                            HorasProduccionTemp horasTemp = new HorasProduccionTemp();
                            horasTemp.setId(regActual.getId());
                            horasTemp.setIdentificacion(regActual.getIdentificacion());
                            horasTemp.setTipo(regActual.getAsisTipo());
                            horasTemp.setStatus(Boolean.FALSE);
                            horaTempRepository.save(horasTemp);

                            List<HorasProduccionTemp> horas = horaTempRepository.findByIdentificacion(regActual.getIdentificacion());
                            HorasProduccion horasProd = horasProduccionRepository.findByIdentificacionAndFecha(regActual.getIdentificacion(), regActual.getAsisFecha());

                            if (horas.size() > 1) {


                                HorasProduccion horasProduccion = new HorasProduccion();
                                HorasProduccionTemp ingreso = horas.get(0);
                                // System.out.println("HorasProduccionTemp++ingreso"+ingreso.getId().getAsisIng());
                                HorasProduccionTemp salida = horas.get(1);
                                //   System.out.println("HorasProduccionTemp++salida"+salida.getId().getAsisIng());
                                //horas producidas
                                Date calHora = utily.getDifferenceBetwenDates(ingreso.getId().getAsisIng(), salida.getId().getAsisIng());
                                ingreso.setStatus(Boolean.TRUE);
                                salida.setStatus(Boolean.TRUE);
                                horaTempRepository.save(ingreso);
                                horaTempRepository.save(salida);
                                if (horasProd == null) {

                                    horasProduccion.setId(regActual.getId());
                                    horasProduccion.setIdentificacion(regActual.getIdentificacion());
                                    horasProduccion.setFecha(regActual.getAsisFecha());
                                    // try {
                                    //  System.out.println("-----calHora----"+calHora);
                                    //Date date = format.parse(String.valueOf(calHora));
                                    Date date = calHora;
                                    horasProduccion.setCalHorasProd(date);
                         /*   } catch (ParseException e)
                            {
                                e.printStackTrace();
                            }*/

                                    horasProduccion.setCalHorasProd(calHora);
                                    String hora = sdfResult.format(calHora);
                                    horasProduccion.setHorasProduccion(hora);
                                    horasProduccionRepository.save(horasProduccion);
                                } else {
                                    //  System.out.println("getCalHorasProd"+horasProd.getCalHorasProd());
                                    //  System.out.println("getHorasProduccion"+horasProd.getHorasProduccion());
                                    Date calPro = utily.getSumBetwenDates(horasProd.getCalHorasProd(), calHora);
                                    horasProd.setCalHorasProd(calPro);
                                    String hora = sdfResult.format(calPro);
                                    horasProd.setHorasProduccion(hora);
                                    horasProduccionRepository.save(horasProd);
                                }
                            }
                            List<HorasProduccionTemp> temp = horaTempRepository.findAll();
                            temp.forEach(t -> {
                                if (t.getStatus()) {
                                    horaTempRepository.delete(t);
                                }
                            });

                        }
                        if ((bio == null ? "" : bio.getNombreBiometrico()).equals("GARITA") && (bio == null ? "" : bio.getTipoBiometrinco()).equals("SALIDA")) {
                            calculoHorasSuplementariasPersonalProduccionFija(regActual);
                        }

//                //logica para el calculo de las horas suplementarias de producción
//                if(bio.getNombreBiometñrico().equals("GARITA") && bio.getTipoBiometrinco().equals("SALIDA"))
//                {
//
//                	try {
//                    	String fechaActual=utily.obtenerFechaActual(regActual.getId().getAsisIng());
//						String fechaActualMenosDias=utily.obtenerFechaMenosDias(1, regActual.getId().getAsisIng());
//						Biometrico bioObtenido=biometricoRepository.findByTipoBiometrincoAndNombreBiometrico("INGRESO","GARITA");
//						List<AsistNow> lsMarcacionesEntradaGarita=postGresRepository.findByElementByFechas(fechaActualMenosDias, fechaActual,regActual.getIdentificacion(),bioObtenido.getIpBiometrico(), Sort.by(Sort.Direction.ASC,"id.asisIng"));
//						/*
//						 * Filtrado por las fechas ahora se debe de obtener la fecha y hora de la marcacion de entrada
//						 * y la fecha y hora de la marcacion de salida
//						 * */
//						if(lsMarcacionesEntradaGarita.size()>0) {
//
//							//se obtiene la marcacion de entrada y salida de garita actual
//
//							AsistNow marcacionSalidaG=regActual;
//							AsistNow marcacionEntradaG=lsMarcacionesEntradaGarita.get(0);
//							//se obtiene todas las marcaciones de entrada y salida de planta
//							Biometrico bioIngresoPlanta=biometricoRepository.findByTipoBiometrincoAndNombreBiometrico("INGRESO","PLANTA");
//							Biometrico biosSalidaPlanta=biometricoRepository.findByTipoBiometrincoAndNombreBiometrico("SALIDA","PLANTA");
//
//							List<AsistNow> lsIngresoPlanta=postGresRepository.findByElementByFechas(utily.obtenerFechaActual(marcacionEntradaG.getAsisFecha()),  utily.obtenerFechaActual(marcacionSalidaG.getAsisFecha()),x.getIdentificacion(),bioIngresoPlanta.getIpBiometrico(), Sort.by(Sort.Direction.ASC,"asisFecha"));
//							List<AsistNow> lsSalidaPlanta=postGresRepository.findByElementByFechas(utily.obtenerFechaActual(marcacionEntradaG.getAsisFecha()),  utily.obtenerFechaActual(marcacionSalidaG.getAsisFecha()),x.getIdentificacion(),biosSalidaPlanta.getIpBiometrico(), Sort.by(Sort.Direction.DESC,"asisFecha"));
//
//                            if(lsIngresoPlanta.size()>0 && lsSalidaPlanta.size()>0) {
//
//							AsistNow igPlantaHora=lsIngresoPlanta.get(0);
//							AsistNow salPlantaHora=lsSalidaPlanta.get(0);
//
//
//							String rangoMarcadoFin=salPlantaHora.getAsisHora();
//
//
//		                       // Date difference = utily.getDifferenceBetwenDates(horaGrupo, regActual.getId().getAsisIng());
//								List<PoliticasHorasSuple> lsPoliticas=politicasHorasSupleRepository.findByEstadoTrue();
//
//
//
//							        if(lsPoliticas.size()>0) {
//
//										HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrue(x.getIdentificacion());
//										if(horaPersonal==null) {
//											horaPersonal=new HorasSuplementariasPersonal();
//											horaPersonal.setIdentificacion(x.getIdentificacion());
//										}
//
//
//
//							            if(lsPoliticas.size()>0 && utily.horasMilisegundosGeneral(rangoMarcadoFin)>=utily.horasMilisegundosGeneral(lsPoliticas.get(0).getRangoHoraFinal())
//							                    &&
//							                    utily.horasMilisegundosGeneral(rangoMarcadoFin)<=utily.horasMilisegundosGeneral(lsPoliticas.get(lsPoliticas.size()-1).getRangoHoraFinal())
//							                    ){
//
//							                Integer horaArrastrada=0;
//							                horaArrastrada=utily.horasMilisegundosGeneral(rangoMarcadoFin)-utily.horasMilisegundosGeneral(lsPoliticas.get(0).getRangoHoraFinal());
//							                                              System.out.println("horas arrastradas i:"+  horaArrastrada);
//
//							                for(int i=0;i<lsPoliticas.size();i++) {
//							                    PoliticasHorasSuple polHoras=lsPoliticas.get(i);
//							                    if(i==0){
//							                        if(utily.horasMilisegundosGeneral(rangoMarcadoFin)>=utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal())){
//							                            horaArrastrada=horaArrastrada;//-utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal());
//							                            /*Date difference = utily.getDifferenceBetwenDates(utily.concatenaHoraFechaActual(polHoras.getRangoHoraFinal(),1), utily.concatenaHoraFechaActual(polHoras.getRangoHoraInicial(),0));
//							                            String horaActual = sdfResult.format(difference);*/
//							                            Integer horasPaso=utily.horasMilisegundosGeneral("8:00:00");
//
//							                            horaPersonal.setHoras(horaPersonal.getHoras()+horasPaso);
//							                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
//                                                        horasSuplementariasPersonalRepository.save(horaPersonal);
//							                              System.out.println("horas arrastradas i:"+i+"   "+  horasPaso+"_____________Porcentaje:"+polHoras.getPorcentaje());
//							                        }else{
//							                            horaArrastrada=utily.horasMilisegundosGeneral(polHoras.getRangoHoraInicial())-horaArrastrada;
//
//							                            horaPersonal.setHoras(horaPersonal.getHoras()+horaArrastrada);
//							                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
//                                                        horasSuplementariasPersonalRepository.save(horaPersonal);
//							                            System.out.println("horas arrastradas i:"+i+"   "+  horaArrastrada+"_____________Porcentaje:"+polHoras.getPorcentaje());
//							                            break;
//							                        }
//
//							                    }else if (i>0){
//							                        Integer dif=utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal())-utily.horasMilisegundosGeneral(polHoras.getRangoHoraInicial());
//							                       System.out.println("diferencia:"+dif);
//							                        if(horaArrastrada>0 && horaArrastrada>=dif){
//							                            horaArrastrada=horaArrastrada-dif;
//
//							                            horaPersonal.setHoras(horaPersonal.getHoras()+horaArrastrada);
//							                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
//                                                        horasSuplementariasPersonalRepository.save(horaPersonal);
//							                              System.out.println("horas arrastradas i:"+i+"   "+  horaArrastrada+"_____________Porcentaje:"+polHoras.getPorcentaje());
//							                        }else if(horaArrastrada<dif){
//							                            horaArrastrada= (utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal())-horaArrastrada)-utily.horasMilisegundosGeneral(polHoras.getRangoHoraInicial());
//
//							                            horaPersonal.setHoras(horaPersonal.getHoras()+horaArrastrada);
//							                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
//                                                        horasSuplementariasPersonalRepository.save(horaPersonal);
//							                            System.out.println("horas arrastradas i:"+i+"   "+  horaArrastrada+"_____________Porcentaje:"+polHoras.getPorcentaje());
//							                              break;
//							                        }
//                                                  //  horasSuplementariasPersonalRepository.save(horaPersonal);
//							                       // System.out.println("horas arrastradas:"+horaArrastrada);
//							                    }
//
//
//							                }
//
//							            }
//							        }
//
//							}
//
//						}
//					} catch (ParseException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//                }

                     sqlRepository.delete(x);


                    });
                }



        }catch (Exception ex)
        {

            logProducer.commit(
                    Utils
                            .LogProducerDefault()
                            .methodName(Utils.currentMethodName())
                            .className(Utils.currentClassName())
                            .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                            .errorCode(ex.hashCode())
                            .errorDescription(ex.getMessage())
                            .data(asistNowRegistroError[0])
                            .toJson()
            );
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
        try
        {
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

        } catch (Exception ex)
        {

            logProducer.commit(
                    Utils
                            .LogProducerDefault()
                            .methodName(Utils.currentMethodName())
                            .className(Utils.currentClassName())
                            .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                            .data(Utils.toJson(searchMarcaDTO))
                            .errorCode(ex.hashCode())
                            .errorDescription(ex.getMessage())
                            .toJson()
            );
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
        try
        {
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

        } catch (Exception ex)
        {
            logProducer.commit(
                    Utils
                            .LogProducerDefault()
                            .methodName(Utils.currentMethodName())
                            .className(Utils.currentClassName())
                            .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                            .data(Utils.toJson(searchMarcaDTO))
                            .errorCode(ex.hashCode())
                            .errorDescription(ex.getMessage())
                            .toJson()
            );
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
        try
        {
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
        } catch (Exception ex)
        {

            logProducer.commit(
                    Utils
                            .LogProducerDefault()
                            .methodName(Utils.currentMethodName())
                            .className(Utils.currentClassName())
                            .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                            .data(Utils.toJson(searchMarcaDTO))
                            .errorCode(ex.hashCode())
                            .errorDescription(ex.getMessage())
                            .toJson()
            );
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

        try
        {
            Atrasos atrasos = atrasosRepository.findByIdentificacionAndAndId_AsisIng(justDTO.getIdentificacion(),justDTO.getFechaIng());

            if(atrasos.getJustificacion()){
                exit.setMessage("Ya exite una justificacion");
                return exit;
            }
            atrasos.setJustificacion(justDTO.getJustificacion());
            atrasosRepository.save(atrasos);
            exit.setMessage("Atraso Justificado");

        } catch (Exception ex)
        {

            logProducer.commit(
                    Utils
                            .LogProducerDefault()
                            .methodName(Utils.currentMethodName())
                            .className(Utils.currentClassName())
                            .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                            .data(Utils.toJson(justDTO))
                            .errorCode(ex.hashCode())
                            .errorDescription(ex.getMessage())
                            .toJson()
            );
        }

        return exit;
    }

    public Date obtenerhoraGrupo(String identificacion)
    {
        try
        {

            //  ScheduleDTO horaGupo= restServices.getSchedulePerson(identificacion);
            //  Date horaGrupo = horaGupo == null ? null : horaGupo.getDesde();
            ShedulePersonDto horaGupo= restServices.getSchedulePerson(identificacion);
            Date horaGrupo = horaGupo.getGroupsScheduleDtoList() == null ||  horaGupo.getGroupsScheduleDtoList().isEmpty()? null : horaGupo.getGroupsScheduleDtoList().get(0).getSchedule().getDesde();
            //Date horaGrupo= horaGupo.getDesde();

            return  horaGrupo;
    } catch (Exception ex)
    {

        logProducer.commit(
                Utils
                        .LogProducerDefault()
                        .methodName(Utils.currentMethodName())
                        .className(Utils.currentClassName())
                        .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                        .data(Utils.toJson(identificacion))
                        .errorCode(ex.hashCode())
                        .errorDescription(ex.getMessage())
                        .toJson()
        );
    }
        return  null;
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
		} catch (Exception ex)
        {

            logProducer.commit(
                    Utils
                            .LogProducerDefault()
                            .methodName(Utils.currentMethodName())
                            .className(Utils.currentClassName())
                            .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                            .errorCode(ex.hashCode())
                            .errorDescription(ex.getMessage())
                            .toJson()
            );
			exito=ex.getMessage();
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



    @Transactional
    public HorasSuplementariasPersonalResponses findAllByHorasSuplementariasPersonal(HorasSuplementariasPersonalBody  horasSuplementariasPersonalBody )
    {
        HorasSuplementariasPersonalResponses response = new HorasSuplementariasPersonalResponses();
        //Comienza a calcular las horas suplementariasProduccion Fijas
        //calculoHorasSuplementariasProduccion(horasSuplementariasPersonalBody.getFechaIni(),horasSuplementariasPersonalBody.getFechaFin(),horasSuplementariasPersonalBody.getIdentificacion(),horasSuplementariasPersonalBody.getEmpresa());
        try {

            List<HorasSuplementariasPersonal> horasSuplementariasPersonalList = horasSuplementariasPersonalRepository.findAllByEstadoTrueAndIdentificacion(horasSuplementariasPersonalBody.getIdentificacion());
            List<HorasSuplementariasPersonalDto>  horasSuplementariasPersonalDtoList = horasSuplementariasPersonalMapper.toHorasSuplementariasPersonalDtoList(horasSuplementariasPersonalList);
            if (horasSuplementariasPersonalDtoList.isEmpty())
            {
                response.setMensaje("No Existe Horas Suplementarias Personal");
                response.setTotalRegistros(0);
                response.setSuccess(false);
                return response;
            }
            else
            {
                response.setHorasSuplementariasPersonalDtoList(horasSuplementariasPersonalDtoList);
                response.setMensaje("ok");
                response.setTotalRegistros(horasSuplementariasPersonalDtoList.size());
                response.setSuccess(true);
                return response;
            }


        }catch (Exception ex)
        {
            // TODO: handle exception

            logProducer.commit(
                    Utils
                            .LogProducerDefault()
                            .methodName(Utils.currentMethodName())
                            .className(Utils.currentClassName())
                            .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                            .data(Utils.toJson(horasSuplementariasPersonalBody))
                            .errorCode(ex.hashCode())
                            .errorDescription(ex.getMessage())
                            .toJson()
            );
            response.setMensaje(ex.getMessage());
            response.setSuccess(false);
            return response;
        }

    }

    @Transactional
    public HorasSuplementariasPersonalResponses calculoHorasSuplementariasProduccion(String fechaIni, String fechaFin ,String identificacion, String empresa )
    {

        HorasSuplementariasPersonalResponses response = new HorasSuplementariasPersonalResponses();


       List<AsistNow>  asistNowList =postGresRepository.findByElementByFechasEmpresa(fechaIni,fechaFin,identificacion,empresa,Sort.by(Sort.Direction.ASC,"id.asisIng"));




        asistNowList.stream().forEach(regActual ->
        {





       // Biometrico bio = biometricoRepository.findByIpBiometrico(regActual.getId().getAsisZona());
        //logica para el calculo de las horas suplementarias de producción
    //   if(bio.getNombreBiometrico().equals("GARITA") && bio.getTipoBiometrinco().equals("SALIDA"))
     //   {

            try {
                String fechaActual=utily.obtenerFechaActual(regActual.getId().getAsisIng());
                String fechaActualMenosDias=utily.obtenerFechaMenosDias(1, regActual.getId().getAsisIng());
                Biometrico bioObtenido=biometricoRepository.findByTipoBiometrincoAndNombreBiometrico("INGRESO","GARITA");
                List<AsistNow> lsMarcacionesEntradaGarita=postGresRepository.findByElementByFechas(fechaActualMenosDias, fechaActual,regActual.getIdentificacion(),bioObtenido.getIpBiometrico(), Sort.by(Sort.Direction.ASC,"id.asisIng"));
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
                    Biometrico biosSalidaGarita=biometricoRepository.findByTipoBiometrincoAndNombreBiometrico("SALIDA","GARITA");
                    List<AsistNow> lsIngresoPlanta=postGresRepository.findByElementByFechas(utily.obtenerFechaActual(marcacionEntradaG.getAsisFecha()),  utily.obtenerFechaActual(marcacionSalidaG.getAsisFecha()),regActual.getIdentificacion(),bioIngresoPlanta.getIpBiometrico(), Sort.by(Sort.Direction.ASC,"asisFecha"));
                    List<AsistNow> lsSalidaPlanta=postGresRepository.findByElementByFechasSalidaGaritaPlanta(utily.obtenerFechaActual(marcacionEntradaG.getAsisFecha()),  utily.obtenerFechaActual(marcacionSalidaG.getAsisFecha()),regActual.getIdentificacion(),biosSalidaGarita.getIpBiometrico(),biosSalidaPlanta.getIpBiometrico() , Sort.by(Sort.Direction.DESC,"asisFecha"));

                    if(lsIngresoPlanta.size()>0 && lsSalidaPlanta.size()>0)
                    {

                        AsistNow igPlantaHora=lsIngresoPlanta.get(0);
                        AsistNow salPlantaHora=lsSalidaPlanta.get(0);


                        String rangoMarcadoFin=salPlantaHora.getAsisHora();


                        // Date difference = utily.getDifferenceBetwenDates(horaGrupo, regActual.getId().getAsisIng());
                        List<PoliticasHorasSuple> lsPoliticas=politicasHorasSupleRepository.findByEstadoTrue();



                        if(lsPoliticas.size()>0)
                        {





                            if(utily.horasMilisegundosGeneral(rangoMarcadoFin)>=utily.horasMilisegundosGeneral(lsPoliticas.get(0).getRangoHoraFinal())
                                    &&
                                    utily.horasMilisegundosGeneral(rangoMarcadoFin)<=utily.horasMilisegundosGeneral(lsPoliticas.get(lsPoliticas.size()-1).getRangoHoraFinal())
                            ){

                                Integer horaArrastrada=0;
                                horaArrastrada=utily.horasMilisegundosGeneral(rangoMarcadoFin)-utily.horasMilisegundosGeneral(lsPoliticas.get(0).getRangoHoraFinal());
                             //   System.out.println("horas arrastradas i:"+  horaArrastrada);

                                for(int i=0;i<lsPoliticas.size();i++)
                                {
                                    PoliticasHorasSuple polHoras=lsPoliticas.get(i);

                                    HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrueAndPorcentaje(regActual.getIdentificacion(),polHoras.getPorcentaje());
                                    if(horaPersonal==null)
                                    {
                                        horaPersonal=new HorasSuplementariasPersonal();
                                        horaPersonal.setIdentificacion(regActual.getIdentificacion());
                                    }
                                    if(i==0)
                                    {
                                        if(utily.horasMilisegundosGeneral(rangoMarcadoFin)>=utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal())){
                                            horaArrastrada=horaArrastrada;//-utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal());
							                            /*Date difference = utily.getDifferenceBetwenDates(utily.concatenaHoraFechaActual(polHoras.getRangoHoraFinal(),1), utily.concatenaHoraFechaActual(polHoras.getRangoHoraInicial(),0));
							                            String horaActual = sdfResult.format(difference);*/
                                            Integer horasPaso=utily.horasMilisegundosGeneral("8:00:00");

                                            horaPersonal.setHoras(horaPersonal.getHoras()+horasPaso);
                                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
                                            horasSuplementariasPersonalRepository.save(horaPersonal);
                                         //   System.out.println("horas arrastradas i:"+i+"   "+  horasPaso+"_____________Porcentaje:"+polHoras.getPorcentaje());
                                        }else{
                                            horaArrastrada=utily.horasMilisegundosGeneral(polHoras.getRangoHoraInicial())-horaArrastrada;

                                            horaPersonal.setHoras(horaPersonal.getHoras()+horaArrastrada);
                                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
                                            horasSuplementariasPersonalRepository.save(horaPersonal);
                                           // System.out.println("horas arrastradas i:"+i+"   "+  horaArrastrada+"_____________Porcentaje:"+polHoras.getPorcentaje());
                                            break;
                                        }

                                    }else if (i>0){
                                        Integer dif=utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal())-utily.horasMilisegundosGeneral(polHoras.getRangoHoraInicial());
                                        //System.out.println("diferencia:"+dif);
                                        if(horaArrastrada>0 && horaArrastrada>=dif)
                                        {
                                            horaArrastrada=horaArrastrada-dif;

                                            horaPersonal.setHoras(horaPersonal.getHoras()+horaArrastrada);
                                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
                                            horasSuplementariasPersonalRepository.save(horaPersonal);
                                           // System.out.println("horas arrastradas i:"+i+"   "+  horaArrastrada+"_____________Porcentaje:"+polHoras.getPorcentaje());
                                        }
                                        else if(horaArrastrada<dif){
                                            horaArrastrada= (utily.horasMilisegundosGeneral(polHoras.getRangoHoraFinal())-horaArrastrada)-utily.horasMilisegundosGeneral(polHoras.getRangoHoraInicial());

                                            horaPersonal.setHoras(horaPersonal.getHoras()+horaArrastrada);
                                            horaPersonal.setPorcentaje(polHoras.getPorcentaje());
                                            horasSuplementariasPersonalRepository.save(horaPersonal);
                                           // System.out.println("horas arrastradas i:"+i+"   "+  horaArrastrada+"_____________Porcentaje:"+polHoras.getPorcentaje());
                                            break;
                                        }
                                        //  horasSuplementariasPersonalRepository.save(horaPersonal);
                                        // System.out.println("horas arrastradas:"+horaArrastrada);
                                    }


                                }

                            }
                        }

                    }

                }

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
       // }

        });

            return response;


    }




    public HorasSuplementariasPersonalResponses calculoHorasSuplementariasPersonalProduccionFija(AsistNow asistNow )
    {
        HorasSuplementariasPersonalResponses response = new HorasSuplementariasPersonalResponses();
        try {


            List<PoliticasHorasSuple> lsPoliticas=politicasHorasSupleRepository.findByEstadoTrue();
            String horasMinutosSegundosEntradaNocturno;
            PersonResponseS  personResponseS=   restServices.consultarPersonaTipoBiometricoCalculo(asistNow.getIdentificacion());

            List<ScheduleDTO>  scheduleDTOListFilter= personResponseS.getScheduleDTOList()==null? new ArrayList<>() :personResponseS.getScheduleDTOList().stream().filter(x->(x.getTurns().getNameTurns().equalsIgnoreCase("NOCTURNO"))).collect(Collectors.toList());
            if (personResponseS!=null && lsPoliticas.size()>0 )
            {
                if (!scheduleDTOListFilter.isEmpty())
                {
                    //System.out.println("TINE HORARIO NOCTURNO");
                    //consulto la marcacion de entrada con la configurtacion de biometrico asignado a cada empleado
                    //la fecha consultada se le resta -1 dia por que la jornada Nocturno
                    String fechaActual=utily.obtenerFechaActual(asistNow.getId().getAsisIng());
                    String fechaActualMenosDias=utily.obtenerFechaMenosDias(1, asistNow.getId().getAsisIng());
                    List<AsistNow> lsMarcacionesEntrada=postGresRepository.findByElementByFechasEmpresaEntrada(fechaActualMenosDias,fechaActual,asistNow.getIdentificacion(),personResponseS.getTipoBiometricoCalculoDto().getNombreBiometrico(), "INGRESO", asistNow.getEmpresa(),Sort.by(Sort.Direction.ASC,"asisFecha"));
                    List<AsistNow> lsMarcacionesSalida=postGresRepository.findByElementByFechasEmpresaEntrada(fechaActual,fechaActual,asistNow.getIdentificacion(),personResponseS.getTipoBiometricoCalculoDto().getNombreBiometrico(), "SALIDA", asistNow.getEmpresa(),Sort.by(Sort.Direction.ASC,"asisFecha"));

                    if (!lsMarcacionesEntrada.isEmpty() && !lsMarcacionesSalida.isEmpty() )
                    {
                        //calcular total de horas trabajadas
                        String  totalHorasTrabajadas= utily.calculaDiferencia(utily.convertirDateString(lsMarcacionesSalida.get(0).getId().getAsisIng()) ,utily.convertirDateString(lsMarcacionesEntrada.get(0).getId().getAsisIng()));
                        String[]  totalHorasTrabajadasSplit= utily.horasMinutosSegundosSplit(totalHorasTrabajadas);
                        String horasTrabajadasSplit = totalHorasTrabajadasSplit[0];
                        String minutosTrabajadasSplit = totalHorasTrabajadasSplit[1];
                        String segundosTrabajadasSplit = totalHorasTrabajadasSplit[2];
                        //Politica del 25 % horas
                      if ( Integer.valueOf(horasTrabajadasSplit) > 8 )
                      {
                          List<PoliticasHorasSuple>  lsPoliticasFilter25=lsPoliticas.stream().filter(x->(x.getPorcentaje()==25)).collect(Collectors.toList());
                         // System.out.println("lsPoliticasFilter25"+lsPoliticasFilter25.get(0));

                          HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrueAndPorcentaje(asistNow.getIdentificacion(),lsPoliticasFilter25.get(0).getPorcentaje());
                          if(horaPersonal==null)
                          {
                              horaPersonal=new HorasSuplementariasPersonal();
                              horaPersonal.setIdentificacion(asistNow.getIdentificacion());
                          }

                          Integer horasPaso=utily.horasMilisegundosGeneral("8:00:00");

                          horaPersonal.setHoras(horaPersonal.getHoras()+horasPaso);
                          horaPersonal.setPorcentaje(lsPoliticasFilter25.get(0).getPorcentaje());
                          horasSuplementariasPersonalRepository.save(horaPersonal);
                         // System.out.println("horas arrastradas "+  horasPaso+"_____________Porcentaje:"+lsPoliticasFilter25.get(0).getPorcentaje());
                      }
                      // calcular cuantas horas de diferencia me queda despues de mis 9.5 horas trabajadas
                        //        String hora1 = "09:30:00";
                        //        String hora2 = "11:30:00";
                        String fechaSinHhMnSs= utily.convertirDateStringSinHhMnSs(lsMarcacionesSalida.get(0).getId().getAsisIng());
                        //System.out.println(fechaSinHhMnSs+" "+totalHorasTrabajadas);
                        String horasTrabajadas =fechaSinHhMnSs+" "+totalHorasTrabajadas;
                        String horasHaTrabajadas =fechaSinHhMnSs+" "+personResponseS.getTipoBiometricoCalculoDto().getHoraTrabajada();
                        String diferenciaHorasTrabajadas =utily.calculaDiferencia(horasTrabajadas,horasHaTrabajadas);
                        // me queda 2:0:0 horas despues de haber cumpñidos mis 9.5 horas traabajadas
                        //tomo la hora de salida de la marcacion 07:00:00 y le restro las  2:00:00 para saber ah que hora culmino sus 9.5 poder calcular
                        //las horas suplemetarias
                        String diferenciaHorasTrabajadasHhMmSS =fechaSinHhMnSs+" "+diferenciaHorasTrabajadas;
                       String horaMinutosSegundo100= utily.calculaDiferencia(utily.convertirDateString(lsMarcacionesSalida.get(0).getId().getAsisIng()),diferenciaHorasTrabajadasHhMmSS);
                        String[]  horaMinutosSegundo100Split= utily.horasMinutosSegundosSplit(horaMinutosSegundo100);
                        String horasTrabajadas100Split = horaMinutosSegundo100Split[0];
                        String minutosTrabajadas100Split = horaMinutosSegundo100Split[1];
                        String segundosTrabajadas100Split = horaMinutosSegundo100Split[2];
                       // System.out.println("horasTrabajadas100Split"+horasTrabajadas100Split);
                        String horasGeneral100 = null;
                        if ( Integer.valueOf(horasTrabajadas100Split) ==5 )
                        {
                            List<PoliticasHorasSuple>  lsPoliticasFilter100=lsPoliticas.stream().filter(x->(x.getPorcentaje()==100)).collect(Collectors.toList());

                            HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrueAndPorcentaje(asistNow.getIdentificacion(),lsPoliticasFilter100.get(0).getPorcentaje());
                            if(horaPersonal==null)
                            {
                                horaPersonal=new HorasSuplementariasPersonal();
                                horaPersonal.setIdentificacion(asistNow.getIdentificacion());
                            }

                            String rangoHoraFinal100 =fechaSinHhMnSs+" "+lsPoliticasFilter100.get(0).getRangoHoraFinal();
                             horasGeneral100= utily.calculaDiferencia(rangoHoraFinal100,horaMinutosSegundo100);
                           // System.out.println("horasGeneral100"+horasGeneral100);
                            Integer horasPaso=utily.horasMilisegundosGeneral(horasGeneral100);

                            horaPersonal.setHoras(horaPersonal.getHoras()+horasPaso);
                            horaPersonal.setPorcentaje(lsPoliticasFilter100.get(0).getPorcentaje());
                            horasSuplementariasPersonalRepository.save(horaPersonal);
                            //System.out.println("horas arrastradas "+  horasPaso+"_____________Porcentaje:"+lsPoliticasFilter100.get(0).getPorcentaje());

                        }


                        String diferenciaHorasTrabajadasHhMmS50 =fechaSinHhMnSs+" "+horasGeneral100;
                        String horaMinutosSegundo50= utily.calculaDiferencia(utily.convertirDateString(lsMarcacionesSalida.get(0).getId().getAsisIng()),diferenciaHorasTrabajadasHhMmS50);
                        String[]  horaMinutosSegundo50Split= utily.horasMinutosSegundosSplit(horaMinutosSegundo50);
                        String horasTrabajadas50Split = horaMinutosSegundo50Split[0];
                        String minutosTrabajadas50Split = horaMinutosSegundo50Split[1];
                        String segundosTrabajadas50Split = horaMinutosSegundo50Split[2];
                        //System.out.println("horasTrabajadas50Split"+horaMinutosSegundo50Split);
                        if ( Integer.valueOf(horasTrabajadas50Split) ==6 )
                        {
                            List<PoliticasHorasSuple>  lsPoliticasFilter50=lsPoliticas.stream().filter(x->(x.getPorcentaje()==50)).collect(Collectors.toList());

                            HorasSuplementariasPersonal horaPersonal=horasSuplementariasPersonalRepository.findByIdentificacionAndEstadoTrueAndPorcentaje(asistNow.getIdentificacion(),lsPoliticasFilter50.get(0).getPorcentaje());
                            if(horaPersonal==null)
                            {
                                horaPersonal=new HorasSuplementariasPersonal();
                                horaPersonal.setIdentificacion(asistNow.getIdentificacion());
                            }

                            String rangoHoraFinal50 =fechaSinHhMnSs+" "+lsPoliticasFilter50.get(0).getRangoHoraFinal();
                            String horasGeneral50= utily.calculaDiferencia(rangoHoraFinal50,horaMinutosSegundo50);
                            Integer horasPaso=utily.horasMilisegundosGeneral(horasGeneral50);

                            horaPersonal.setHoras(horaPersonal.getHoras()+horasPaso);
                            horaPersonal.setPorcentaje(lsPoliticasFilter50.get(0).getPorcentaje());
                            horasSuplementariasPersonalRepository.save(horaPersonal);
                           // System.out.println("horas arrastradas "+  horasPaso+"_____________Porcentaje:"+lsPoliticasFilter50.get(0).getPorcentaje());

                        }

                    }
                }
            }
                return response;
        }catch (Exception e)
        {
            // TODO: handle exception
            response.setMensaje(e.getMessage());
            response.setSuccess(false);
            return response;
        }

    }




    public ConsultarEntradaSalidaMarcacionResponses consultarEntradaSalidaMarcacion(ConsultarEntradaSalida consultarEntradaSalida )
    {
        ConsultarEntradaSalidaMarcacionResponses response = new ConsultarEntradaSalidaMarcacionResponses();
        List<RegistroMarcacionesDTO> registroMarcacionesEntradaSalidadDTOList  =new ArrayList<>();
        int cont = 0;
        try
        {

            consultarEntradaSalida.setEmpresa(utily.empresa(consultarEntradaSalida.getEmpresa()));

            List<AsistNow> lsMarcacionesEntrada=postGresRepository.listahoraEntradaBiometrico(consultarEntradaSalida.getFechaInicio(),consultarEntradaSalida.getFechaFin(),consultarEntradaSalida.getIdentificacion(),consultarEntradaSalida.getBiometrico(),  consultarEntradaSalida.getEmpresa());
            if (!lsMarcacionesEntrada.isEmpty() )
            {

                List<RegistroMarcacionesDTO> registroMarcacionesEntradaDTOList  =registroMarcacionesMapper.toRegistroMarcacionesDTOList(lsMarcacionesEntrada);

               for (RegistroMarcacionesDTO x:registroMarcacionesEntradaDTOList )
               {


                   if(cont>0)
                   {

                       if (x.getBiometrico().getTipoBiometrinco().equals(registroMarcacionesEntradaDTOList.get(cont-1).getBiometrico().getTipoBiometrinco()))
                       {


                           RegistroMarcacionesDTO  registroMarcacionesDTO =  new RegistroMarcacionesDTO();
                           BiometricoDto biometrico =  new BiometricoDto();
                           biometrico.setNombreBiometrico(x.getBiometrico().getNombreBiometrico());
                           registroMarcacionesDTO.setBiometrico(biometrico);
                           registroMarcacionesDTO.setApellidos(x.getApellidos());
                           registroMarcacionesDTO.setNombres(x.getNombres());
                           registroMarcacionesDTO.setEmpresa(x.getEmpresa());
                           registroMarcacionesDTO.setIdentificacion(x.getIdentificacion());
                           registroMarcacionesEntradaSalidadDTOList.add(registroMarcacionesDTO);
                       }

                   }

                   registroMarcacionesEntradaSalidadDTOList.add(x);

                   cont++;


               }
                response.setLsMarcacionesEntradaSalida(registroMarcacionesEntradaSalidadDTOList);
                response.setTotalRegistrosEntradaSalidad(registroMarcacionesEntradaSalidadDTOList.size());
                response.setMensaje("Consulta Existosa");
                response.setSuccess(true);
                return response;
            }

        }
        catch (Exception ex)
        {

            logProducer.commit(
                    Utils
                            .LogProducerDefault()
                            .methodName(Utils.currentMethodName())
                            .className(Utils.currentClassName())
                            .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                            .data(Utils.toJson(consultarEntradaSalida))
                            .errorCode(ex.hashCode())
                            .errorDescription(ex.getMessage())
                            .toJson()
            );

            // TODO: handle exception
            response.setMensaje(ex.getMessage());
            response.setSuccess(false);
            return response;
        }

        return response;
    }



    public RegistroMarcacionesResponses guardadoEntradaSalidaMarcacion(RegistroMarcacionesDTO registroMarcacionesDTO)
    {
        RegistroMarcacionesResponses response = new RegistroMarcacionesResponses();

        try
        {

            List<AsistNow>   asistNowExiste=  postGresRepository.findAllByIdentificacion(registroMarcacionesDTO.getIdentificacion());
            if (!asistNowExiste.isEmpty()) {
                AsistnowPK asistnowPK = new AsistnowPK();
                Biometrico biometrico = biometricoRepository.findByTipoBiometrincoAndNombreBiometrico(registroMarcacionesDTO.getBiometrico().getTipoBiometrinco(), registroMarcacionesDTO.getBiometrico().getNombreBiometrico());
                AsistNow registroMarcaciones = registroMarcacionesMapper.registroMarcacionesDTOToAsistNow(registroMarcacionesDTO);
                registroMarcaciones.setBiometrico(biometrico);
                asistnowPK.setAsisId(asistNowExiste.get(0).getId().getAsisId());
                asistnowPK.setAsisIng(utily.concatenaHoraFechaEntradaSalidaMarcacion(registroMarcacionesDTO.getAsisFecha(),registroMarcacionesDTO.getAsisHora()));
                asistnowPK.setAsisZona(biometrico.getIpBiometrico());
                registroMarcaciones.setId(asistnowPK);
                registroMarcaciones.setAsisRes("OK");
                registroMarcaciones.setAsisTipo(biometrico.getTipoBiometrinco());
                registroMarcaciones.setAsisFecha(registroMarcacionesDTO.getAsisFecha());
                AsistNow registroMarcacionesSave = postGresRepository.save(registroMarcaciones);
                RegistroMarcacionesDTO marcacionesDTO = registroMarcacionesMapper.asistNowToRegistroMarcacionesDTO(registroMarcacionesSave);
                response.setMessage("GUARDADO CON EXISTO");
                response.setSuccess(true);
                response.setRegistroMarcacionesDTO(marcacionesDTO);
                guardadoHistorialMarcaciones(registroMarcacionesSave);
                return response;
            }

        }
        catch (Exception ex)
        {
            logProducer.commit(
                    Utils
                            .LogProducerDefault()
                            .methodName(Utils.currentMethodName())
                            .className(Utils.currentClassName())
                            .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                            .data(Utils.toJson(registroMarcacionesDTO))
                            .errorCode(ex.hashCode())
                            .errorDescription(ex.getMessage())
                            .toJson()
            );

            // TODO: handle exception
            response.setMessage(ex.getMessage());
            response.setSuccess(false);
            return response;
        }


        return response;
    }




    public RegistroMarcacionesResponses guardadoHistorialMarcaciones(AsistNow asistNow)
    {
        RegistroMarcacionesResponses response = new RegistroMarcacionesResponses();

        try
        {

            //History
            AsistNowRegistroDTO  historyAsistNowRDTO = new AsistNowRegistroDTO();
            MarcacionesMongo  marcacionesMongo = new MarcacionesMongo();
            List<AsistNowRegistroDTO>  asistNowRegistroDTOS= new ArrayList<>();
            //Datos de multi Tenant
           // System.out.println("tenant"+ev.getProperty("tenant"));
            marcacionesMongo.setTenant(ev.getProperty("tenant"));
            marcacionesMongo.setDatabase(ev.getProperty("database"));
            marcacionesMongo.setCollection(ev.getProperty("collectionAsistencias"));
            marcacionesMongo.setCompositeKey(asistNow.getIdentificacion());
            historyAsistNowRDTO.setAsisId(asistNow.getId().getAsisId());
            historyAsistNowRDTO.setAsisIng(utily.convertirDateString(asistNow.getId().getAsisIng()));
            historyAsistNowRDTO.setAsisZona(asistNow.getId().getAsisZona());
            historyAsistNowRDTO.setAsisFecha(utily.convertirDateString(asistNow.getAsisFecha()));
            historyAsistNowRDTO.setAsisHora(asistNow.getAsisHora());
            historyAsistNowRDTO.setAsisTipo(asistNow.getAsisTipo());
            historyAsistNowRDTO.setAsisRes(asistNow.getAsisRes());
            historyAsistNowRDTO.setIdentificacion(asistNow.getIdentificacion());
            historyAsistNowRDTO.setEmpresa(asistNow.getEmpresa());
            historyAsistNowRDTO.setNombres(asistNow.getNombres());
            historyAsistNowRDTO.setApellidos(asistNow.getApellidos());
            historyAsistNowRDTO.setFechaAccion(utily.convertirDateString(new Date()));
            historyAsistNowRDTO.setAccion("GUARDADO");
            historyAsistNowRDTO.setFechaAccion(utily.convertirDateString(new Date()));
            asistNowRegistroDTOS.add(historyAsistNowRDTO);
            marcacionesMongo.setPayload(asistNowRegistroDTOS);
            restServices.saveMarcacionesMongo(marcacionesMongo);

        }
        catch (Exception e)
        {
            // TODO: handle exception
            response.setMessage(e.getMessage());
            response.setSuccess(false);
            return response;
        }


        return response;
    }




    public ResponsesEntradaSalidaMarcacionDias consultarEntradaSalidaMarcacionPorDia(ConsultarAsistenciasDias consultarAsistenciasDias )
    {
        ResponsesEntradaSalidaMarcacionDias response = new ResponsesEntradaSalidaMarcacionDias();
        try
        {
            consultarAsistenciasDias.setEmpresa(utily.empresa(consultarAsistenciasDias.getEmpresa()));
            List<AsistNow> lsMarcacionesEntrada=postGresRepository.listaDiaAsistenciasBiometrico(consultarAsistenciasDias.getFechaInicio(),consultarAsistenciasDias.getFechaFin(),consultarAsistenciasDias.getIdentificacion(),"GARITA","INGRESO", consultarAsistenciasDias.getEmpresa());
            List<AsistNow> lsMarcacionesSalida=postGresRepository.listaDiaAsistenciasBiometrico(consultarAsistenciasDias.getFechaInicio(),consultarAsistenciasDias.getFechaFin(),consultarAsistenciasDias.getIdentificacion(),"GARITA","SALIDA", consultarAsistenciasDias.getEmpresa());
            response.setLsMarcacionesEntrada(lsMarcacionesEntrada);
            response.setLsMarcacionesSalida(lsMarcacionesSalida);
            response.setMensaje("Consulta Existosa");
            response.setSuccess(true);
        }
        catch (Exception ex)
        {
            logProducer.commit(
                    Utils
                            .LogProducerDefault()
                            .methodName(Utils.currentMethodName())
                            .className(Utils.currentClassName())
                            .errorLine(Utils.errorLineNumber(ex,Utils.currentClassName()))
                            .data(Utils.toJson(consultarAsistenciasDias))
                            .errorCode(ex.hashCode())
                            .errorDescription(ex.getMessage())
                            .toJson()
            );


            // TODO: handle exception
            response.setMensaje(ex.getMessage());
            response.setSuccess(false);
            return response;
        }

        return response;
    }

}
