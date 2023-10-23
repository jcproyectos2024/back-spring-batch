package com.backSpringBatch.sqlserver.repository;

import com.backSpringBatch.sqlserver.entity.AsistNowRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SQLRepository extends JpaRepository<AsistNowRegistro, String> {


   // List<AsistNowRegistro> findAllBy







}
