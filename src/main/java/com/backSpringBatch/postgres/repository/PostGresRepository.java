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



    @Query(nativeQuery = false, value = "SELECT an.id.asisId, an.id.asisZona, an.asisFecha, an.asisHora, an.asisTipo, an.asisRes  " +
            " from AsistNow an" +
            " where  an.id.asisId =:idAsistnow")
    List<Object[]> getIdAsist(@Param("idAsistnow") String idAsistnow);







}
