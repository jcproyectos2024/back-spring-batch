package com.backSpringBatch.postgres.repository;
import com.backSpringBatch.postgres.entity.AsistNow;
import com.backSpringBatch.postgres.entity. MarcacionesIngresoSalida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarcacionesIngresoSalidaRepository  extends JpaRepository<MarcacionesIngresoSalida, String>
{

    @Query(nativeQuery = false, value = " SELECT an " +
            " from MarcacionesIngresoSalida an  " +
            " where   to_char(an.id.fechaEntrada,'yyyy-MM-dd') between :fechaIni  and :fechaFin  AND an.procesado=:procesado ")
    Optional<List<MarcacionesIngresoSalida>>  findAllByIngresoSalida(@Param("fechaIni") String fechaIni ,
                                                                     @Param("fechaFin") String fechaFin ,
                                                                     @Param("procesado") boolean procesado );

    @Query(nativeQuery = false, value = " SELECT an " +
            " from MarcacionesIngresoSalida an  " +
            " where   to_char(an.id.fechaEntrada,'yyyy-MM-dd') between :fechaIni  and :fechaFin  AND an.horasExtrasProcesada=:horasExtrasProcesada ")
    Optional<List<MarcacionesIngresoSalida>>  findAllByIngresoSalidaHorasExtras(@Param("fechaIni") String fechaIni ,
                                                                     @Param("fechaFin") String fechaFin ,
                                                                     @Param("horasExtrasProcesada") boolean horasExtrasProcesada );

}
