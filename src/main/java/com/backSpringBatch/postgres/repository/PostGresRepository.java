package com.backSpringBatch.postgres.repository;


import com.backSpringBatch.postgres.entity.AsistNow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostGresRepository extends JpaRepository<AsistNow, String> {



    @Query(nativeQuery = false, value = "SELECT an " +
            " from AsistNow an" +
            " where (an.identificacion =:identificacion or :identificacion is null)" +
            " and an.asisRes = 'OK'" +
            " order by  an.id.asisIng desc")
    List<AsistNow> getIdAsistfiltro(@Param("identificacion") String identificacion);
    
   
    @Query(nativeQuery = false, value = "select asi.id.asisId, asi.id.asisZona, asi.asisFecha,asi.asisHora,asi.asisTipo, asi.id.asisIng  " +
            "from AsistNow asi" +
            " where (asi.identificacion =:identificacion)" +
            " and asi.asisRes = 'OK' " +
            " order by  asi.id.asisIng desc")
    Page<Object[]> getIdAsistSinPag(@Param("identificacion") String identificacion, Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT an " +
            " from AsistNow an" +
            " where to_char(an.asisFecha,'yyyy-MM-dd') <=: fechaRegistro " +
            " and an.asisRes = 'OK'" +
            " order by  an.id.asisIng desc")
    List<AsistNow> getAsistenciasxFechaRegistro(@Param("fechaRegistro") String fechaRegistro);








}
