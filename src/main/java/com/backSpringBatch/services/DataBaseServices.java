package com.backSpringBatch.services;

import com.backSpringBatch.Util.SaveMantDTO;
import com.backSpringBatch.postgres.entity.AsistNow;
import com.backSpringBatch.postgres.entity.Atrasos;
import com.backSpringBatch.postgres.mapper.AsistNowMapper;
import com.backSpringBatch.postgres.models.AsistNowDTO;
import com.backSpringBatch.postgres.models.ResponseAsistNowPagination;
import com.backSpringBatch.postgres.models.SearchMarcaDTO;
import com.backSpringBatch.postgres.repository.AtrasosRepository;
import com.backSpringBatch.postgres.repository.PostGresRepository;
import com.backSpringBatch.sqlserver.entity.AsistNowRegistro;
import com.backSpringBatch.sqlserver.mapper.AsisRegistroMapper;
import com.backSpringBatch.sqlserver.repository.SQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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


    @Transactional(rollbackFor = { Exception.class })
    public void insertSqlToPostgres(){

        try{

            List<AsistNowRegistro> lsRegistros=sqlRepository.findAll();
            lsRegistros.forEach(x->{
                AsistNow regActual=asisRegistroMapper.asistNowRegistroToAsistNow(x);
                //Llenar tabla atrasos
                Atrasos atrasos = new Atrasos();
                atrasos.setId(x.getId().getAsisId());
                atrasos.setIdentificacion(x.getIdentificacion());
                atrasos.setJustificacion(Boolean.FALSE);
                int hora = Integer.parseInt(x.getAsisHora());
                int  calHora= hora-83000;
                String calculo= String.valueOf(calHora);
                atrasos.setTiempoAtraso(calculo);

                postGresRepository.save(regActual);
                sqlRepository.delete(x);
            });

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    //PAGINADO
    public ResponseAsistNowPagination obtenerMarcaciones (SearchMarcaDTO searchMarcaDTO){

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

    public  List<AsistNowDTO> obtenermarcaGeneral(SearchMarcaDTO search){

        return asistNowMapper.toAsistNowDTOToAsistNow(postGresRepository.getIdAsistfiltro(search.getIdentificacion()));
    }

    public List<AsistNowDTO> obtenerMarcaPag( Pageable pag, SearchMarcaDTO search){

        List<AsistNowDTO> exit= new ArrayList<>();
        Page<Object[]> asistObject =(postGresRepository.getIdAsistSinPag(search.getIdentificacion(), pag));

        for(Object[] objects : asistObject){

            AsistNowDTO asist=new AsistNowDTO();
            asist.setAsisId(objects[0].toString());
            asist.setAsisZona(objects[1].toString());
            asist.setAsisFecha(objects[2].toString());
            asist.setAsisHora(objects[3].toString());
            asist.setAsisTipo(objects[4].toString());
            asist.setAsisRes(objects[5].toString());
//            asist.setAtraso(objects[6].toString());
//            asist.setJustificacion(Boolean.valueOf(objects[7].toString()));

            exit.add(asist);

        }

        return exit;
    }

    public SaveMantDTO justificacion( Boolean justificacion, String identificacion){

        SaveMantDTO exit = new SaveMantDTO();

        Atrasos atrasos = atrasosRepository.getIdentificacion(identificacion);
        atrasos.setJustificacion(justificacion);
        atrasosRepository.save(atrasos);
        exit.setMessage("Atraso Justificado");
        return exit;

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




}
