package com.backSpringBatch.postgres.repository;


import com.backSpringBatch.postgres.entity.HorasProduccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface HorasProduccionRepository extends JpaRepository <HorasProduccion, String> {

    @Query(nativeQuery = false, value = "SELECT  hp  " +
            " from HorasProduccion hp" +
            " where hp.identificacion =:identificacion " +
            " order by  hp.id.asisIng desc")
    List<HorasProduccion> getHorasProdfiltro(@Param("identificacion") String identificacion);


    @Query(nativeQuery = false, value = "select hp.id.asisId, hp.fecha, hp.horasProduccion  " +
            "from HorasProduccion hp" +
            " where hp.identificacion =:identificacion" +
            " order by  hp.id.asisIng desc")
    Page<Object[]> getIdHorasProdPag(@Param("identificacion") String identificacion, Pageable pageable);


    HorasProduccion findByIdentificacionAndFecha (String identiricacion, Date fecha );


}
