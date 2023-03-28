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
            " where  (an.identificacion =:identificacion or :identificacion is null)" +
            " order by  an.id.asisIng desc")
    List<AsistNow> getIdAsistfiltro(@Param("identificacion") String identificacion);

    @Query(nativeQuery = false, value = "SELECT an.id.asisId, an.id.asisZona, an.asisFecha, an.asisHora, an.asisTipo, an.asisRes  " +
            " from AsistNow an" +
            " left join Atrasos at " +
            " where  (an.identificacion =:identificacion or :identificacion is null)" +
            " and an.asisRes = 'OK' " +
            " order by  an.id.asisIng desc")
    Page<Object[]> getIdAsistSinPag(@Param("identificacion") String identificacion, Pageable pageable);










}
