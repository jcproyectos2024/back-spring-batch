package com.backSpringBatch.postgres.repository;


import com.backSpringBatch.postgres.entity.HorasSuplementariasPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorasSuplementariasPersonalRepository extends JpaRepository <HorasSuplementariasPersonal, String> {

	HorasSuplementariasPersonal findByIdentificacionAndEstadoTrue(String identificacion);
    

}
