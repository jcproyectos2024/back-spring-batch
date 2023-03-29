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

    @Query(nativeQuery = true, value = "select asi.asis_id, asi.asis_zona, asi.asis_fecha,asi.asis_hora,asi.asis_tipo, a.tiempo_atraso, a.justificacion  " +
            "from asistnow asi" +
            " join atrasos a on a.id=asis_id" +
            " where (asi.nomina_cod =:identificacion or :identificacion is null)" +
            " and asi.asis_res = 'OK' " +
            " order by  asi.asis_ing desc")
    Page<Object[]> getIdAsistSinPag(@Param("identificacion") String identificacion, Pageable pageable);










}
