package com.backSpringBatch.postgres.repository;



import com.backSpringBatch.postgres.entity.Atrasos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface AtrasosRepository extends JpaRepository<Atrasos, Long> {

    @Query(nativeQuery = false, value = "SELECT  at  " +
            " from Atrasos at" +
            " join AsistNow an" +
            " where  an.identificacion =:identificacion" +
            " and an.asisTipo ='INGRESO' " +
            " and an.asisRes = 'OK' " +
            " order by  an.id.asisIng desc")
    Atrasos findIdentificacion  (String identificacion);

}
