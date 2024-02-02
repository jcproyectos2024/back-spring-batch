package com.backSpringBatch.postgres.repository;
import com.backSpringBatch.postgres.entity.AsistNow;
import com.backSpringBatch.postgres.entity.MantenimientoFeriado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MantenimientoFeriadoRepository  extends JpaRepository<MantenimientoFeriado, Long>
{
    Optional<List<MantenimientoFeriado>> findAllByEstadoTrue();

    Optional<MantenimientoFeriado> findByEstadoTrueAndIdMantenimientoFeriado(long idMasterEtnica);

    @Query(nativeQuery = false, value = "SELECT mfd " +
            " FROM MantenimientoFeriado mfd " +
            " WHERE mfd.feriado like:feriado  or :feriado is null order by  mfd.feriado  ASC ")
    Page<MantenimientoFeriado> consultarMantenimientoFeriadoPagineo(@Param("feriado") String feriado, Pageable pageable);


}
