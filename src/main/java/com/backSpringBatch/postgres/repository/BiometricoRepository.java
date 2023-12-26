package com.backSpringBatch.postgres.repository;




import com.backSpringBatch.postgres.entity.Biometrico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BiometricoRepository extends JpaRepository<Biometrico, Long> {



	Biometrico findByTipoBiometrincoAndNombreBiometrico(String tipoBiometrico, String nombreBiometrico);
	
    Biometrico findByIpBiometrico( String ip);

   Optional<List<Biometrico>> findAllBy();

    Biometrico findByNombreBiometricoAndEmpresa( String nombreBiometrico , String empresa );

}
