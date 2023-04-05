package com.backSpringBatch.postgres.repository;




import com.backSpringBatch.postgres.entity.Biometrico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BiometricoRepository extends JpaRepository<Biometrico, Long> {




    Biometrico findByIpBiometrico( String ip);



}
