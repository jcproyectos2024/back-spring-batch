package com.backSpringBatch.postgres.repository;


import com.backSpringBatch.postgres.entity.HorasSuplementariasPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorasSuplementariasPersonalRepository extends JpaRepository <HorasSuplementariasPersonal, String> {

	HorasSuplementariasPersonal findByIdentificacionAndEstadoTrueAndPorcentajeAndPeriodo(String identificacion, Double porcentaje,String periodo);


	List<HorasSuplementariasPersonal> findAllByEstadoTrue();

	List<HorasSuplementariasPersonal> findAllByEstadoTrueAndIdentificacion(String identificacion);

	HorasSuplementariasPersonal findByIdentificacionAndEstadoTrueAndTipoAndPeriodo(String identificacion, String tipo,String periodo);
	List<HorasSuplementariasPersonal> findAllByIdentificacionAndEstadoTrueAndPeriodo(String identificacion,String periodo);


}
