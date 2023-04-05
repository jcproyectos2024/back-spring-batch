package com.backSpringBatch.postgres.repository;



import com.backSpringBatch.postgres.entity.AsistNow;
import com.backSpringBatch.postgres.entity.Atrasos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface AtrasosRepository extends JpaRepository<Atrasos, String> {

    @Query(nativeQuery = false, value = "SELECT  at  " +
            " from Atrasos at" +
                    " where at.identificacion =:identificacion " +
                    " order by  at.id.asisIng desc")
    List<Atrasos> getIdAtrasosfiltro(@Param("identificacion") String identificacion);


    @Query(nativeQuery = false, value = "select at.id.asisId, at.id.asisZona, at.fecha, at.tiempoAtraso, at.justificacion, at.id.asisIng  " +
            "from Atrasos at" +
            " where at.identificacion =:identificacion" +
            " order by  at.id.asisIng desc")
    Page<Object[]> getIdAtrasosPag(@Param("identificacion") String identificacion, Pageable pageable);


    Atrasos findByIdentificacionAndAndId_AsisIng  (String identificacion, Date asisIng);

    Atrasos findByIdentificacionAndAndFecha (String identificacion, Date fecha );




}
