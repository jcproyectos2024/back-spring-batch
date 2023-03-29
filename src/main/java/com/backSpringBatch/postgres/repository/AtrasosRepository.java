package com.backSpringBatch.postgres.repository;



import com.backSpringBatch.postgres.entity.Atrasos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface AtrasosRepository extends JpaRepository<Atrasos, String> {

//    @Query(nativeQuery = false, value = "SELECT  at  " +
//            " from Atrasos at" +
//            " where  at.identificacion =:identificacion" )
//    Atrasos getIdentificacion  (String identificacion);

    Atrasos findByIdentificacion (String identificacion );


}
