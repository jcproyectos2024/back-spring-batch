package com.backSpringBatch.sqlserver.repository;

import com.backSpringBatch.sqlserver.entity.AsistNowRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SQLRepository extends JpaRepository<AsistNowRegistro, String> {


 List<AsistNowRegistro> findAllByEstadoAsistnowRegistroTrue();







}
