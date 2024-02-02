package com.backSpringBatch.postgres.repository;
import com.backSpringBatch.postgres.entity.MantenimientoFeriado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MantenimientoFeriadoRepository  extends JpaRepository<MantenimientoFeriado, Long>
{
    Optional<List<MantenimientoFeriado>> findAllByEstadoTrue();

    Optional<MantenimientoFeriado> findByEstadoTrueAndIdMantenimientoFeriado(long idMasterEtnica);

}
