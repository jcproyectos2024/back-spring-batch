package com.backSpringBatch.services;

import com.backSpringBatch.Util.Marcaciones;
import com.backSpringBatch.postgres.entity.AsistNow;
import com.backSpringBatch.postgres.mapper.AsistNowMapper;
import com.backSpringBatch.postgres.models.AsistNowDTO;
import com.backSpringBatch.postgres.repository.PostGresRepository;
import com.backSpringBatch.sqlserver.entity.AsistNowRegistro;
import com.backSpringBatch.sqlserver.entity.AsistNowSql;
import com.backSpringBatch.sqlserver.entity.AsistnowRegistroPK;
import com.backSpringBatch.sqlserver.mapper.AsisRegistroMapper;
import com.backSpringBatch.sqlserver.repository.AsistNowSqlRepository;
import com.backSpringBatch.sqlserver.repository.SQLRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


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


    @Transactional(rollbackFor = { Exception.class })
    public void insertSqlToPostgres(){

        try{

            List<AsistNowRegistro> lsRegistros=sqlRepository.findAll();
            lsRegistros.forEach(x->{
                AsistNow regActual=asisRegistroMapper.asistNowRegistroToAsistNow(x);
                postGresRepository.save(regActual);
                sqlRepository.delete(x);
            });

        }catch (Exception ex){
            ex.printStackTrace();
        }
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
////                System.out.println("Resultado"+" "+sql);
//
//                Thread.sleep(3000);
//                ;
//            }
//
//
//        }
//}
    public String getHourNow() {
        String hora = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now());
        return hora;
    }

    public LocalDateTime obtenergetdateNow(){

        LocalDateTime date = LocalDateTime.now();

        return  date;
    }




  public List<AsistNowDTO> obtenerMarcaciones(String idAsistNow){

        List<AsistNowDTO> exit= new ArrayList<>();
           List <Object[]> asistObject =(postGresRepository.getIdAsist(idAsistNow));

           for(Object[] objects : asistObject){

               AsistNowDTO asist=new AsistNowDTO();
               asist.setAsisId(objects[0].toString());
               asist.setAsisZona(objects[1].toString());
               asist.setAsisFecha(objects[2].toString());
               asist.setAsisHora(objects[3].toString());
               asist.setAsisTipo(objects[4].toString());
               asist.setAsisRes(objects[5].toString());
               exit.add(asist);

           }

        return exit;
  }





}
