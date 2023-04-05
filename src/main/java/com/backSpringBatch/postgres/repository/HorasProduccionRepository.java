package com.backSpringBatch.postgres.repository;


import com.backSpringBatch.postgres.entity.HorasProduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Repository
public interface HorasProduccionRepository extends JpaRepository <HorasProduccion, String> {



    HorasProduccion findByIdentificacionAndFecha (String identiricacion, Date fecha );


}
