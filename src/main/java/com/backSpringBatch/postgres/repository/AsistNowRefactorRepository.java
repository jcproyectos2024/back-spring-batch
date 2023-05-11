package com.backSpringBatch.postgres.repository;

import com.backSpringBatch.postgres.entity.AsistNowRefactor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface AsistNowRefactorRepository extends JpaRepository<AsistNowRefactor, String> {


	
	@Query(nativeQuery = false, value = "SELECT an " +
	            " from AsistNowRefactor an" +
	            " where (an.identificacion =:identificacion or :identificacion is null)" +
	            " and an.asisRes = 'OK'" +
	            " order by  an.id.asisIng desc")
	List<AsistNowRefactor> getIdAsistfiltro(@Param("identificacion") String identificacion);
	
	@Query(nativeQuery = false, value = "SELECT an " +
            " from AsistNowRefactor an" +
            " where (an.identificacion =:identificacion or :identificacion is null)" +
            " and an.asisRes = 'OK'" +
            " order by  an.id.asisIng desc")
	Page<AsistNowRefactor> getIdAsistfiltroPagin(@Param("identificacion") String identificacion, Pageable pag);
	

	AsistNowRefactor findByAsisFechaAndIdentificacion(Date asisFecha, String identificacion );
    
   
   








}
