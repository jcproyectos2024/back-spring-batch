package com.backSpringBatch.postgres.repository;


import com.backSpringBatch.postgres.entity.HorasProduccionTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorasProduccionTempRepository extends JpaRepository <HorasProduccionTemp, String> {



    @Query(nativeQuery = false, value = "SELECT hp " +
            " from HorasProduccionTemp hp" +
            " where hp.identificacion =:identificacion" +
            " order by  hp.id.asisIng asc")
    List<HorasProduccionTemp> findByIdentificacion(@Param("identificacion") String identificacion);

//    List<HorasProduccionTemp> findByStatus (Boolean status);

    HorasProduccionTemp findByStatus (Boolean status);



}
