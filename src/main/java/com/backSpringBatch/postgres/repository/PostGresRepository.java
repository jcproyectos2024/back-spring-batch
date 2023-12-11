package com.backSpringBatch.postgres.repository;


import com.backSpringBatch.postgres.entity.AsistNow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostGresRepository extends JpaRepository<AsistNow, String> {



    @Query(nativeQuery = false, value = "SELECT an " +
            " from AsistNow an" +
            " where (an.identificacion =:identificacion or :identificacion is null)" +
            " and an.asisRes = 'OK'" +
            " order by  an.id.asisIng desc")
    List<AsistNow> getIdAsistfiltro(@Param("identificacion") String identificacion);
    
   
    @Query(nativeQuery = false, value = "select asi.id.asisId, asi.id.asisZona, asi.asisFecha,asi.asisHora,asi.asisTipo, asi.id.asisIng  " +
            "from AsistNow asi" +
            " where (asi.identificacion =:identificacion)" +
            " and asi.asisRes = 'OK' " +
            " order by  asi.id.asisIng desc")
    Page<Object[]> getIdAsistSinPag(@Param("identificacion") String identificacion, Pageable pageable);


    @Query(nativeQuery = false, value = "SELECT an " +
            " from AsistNow an" +
            " where to_char(an.asisFecha,'yyyy-MM-dd') <=: fechaRegistro " +
            " and an.asisRes = 'OK'" +
            " order by  an.id.asisIng desc")
    List<AsistNow> getAsistenciasxFechaRegistro(@Param("fechaRegistro") String fechaRegistro);



    @Query(nativeQuery=false, value="select an from AsistNow an "
    		+ " where to_char(an.asisFecha,'yyyy-MM-dd') between :fechaIni  and :fechaFin "
    		+ " and an.identificacion=:nominaCod "
    		+ " and an.id.asisZona=:ipZona ")
    List<AsistNow> findByElementByFechas(String fechaIni, String fechaFin, String nominaCod, String ipZona, Sort sort);



   @Query(nativeQuery=false, value="select an from AsistNow an  "
            + " where to_char(an.asisFecha,'yyyy-MM-dd') between :fechaIni  and :fechaFin "
            + " and an.identificacion=:nominaCod "
            + " and   an.empresa=:empresa and an.biometrico.nombreBiometrico=:nombreBiometrico and an.biometrico.tipoBiometrinco='SALIDA' ")
    List<AsistNow> findByElementByFechasEmpresa(String fechaIni, String fechaFin, String nominaCod,String empresa, String nombreBiometrico ,Sort sort);


    @Query(nativeQuery=false, value="select an from AsistNow an "
            + " where to_char(an.asisFecha,'yyyy-MM-dd') between :fechaIni  and :fechaFin "
            + " and an.identificacion=:nominaCod "
            + " and (an.id.asisZona=:ipZonaGarita or  an.id.asisZona=:ipZonaPlanta ) ")
    List<AsistNow> findByElementByFechasSalidaGaritaPlanta(String fechaIni, String fechaFin, String nominaCod, String ipZonaGarita,  String ipZonaPlanta, Sort sort);


    @Query(nativeQuery=false, value="select an from AsistNow an  "
            + " where to_char(an.asisFecha,'yyyy-MM-dd') between :fechaIni  and :fechaFin "
            + " and an.identificacion=:nominaCod "
            + " and   an.empresa=:empresa and an.biometrico.nombreBiometrico=:nombreBiometrico and an.biometrico.tipoBiometrinco=:tipoBiometrinco ")
    List<AsistNow> findByElementByFechasEmpresaEntrada(String fechaIni, String fechaFin,String nominaCod, String nombreBiometrico, String tipoBiometrinco , String empresa  ,Sort sort);


    @Query(nativeQuery=false, value="select an from AsistNow an  "
            + " where to_char(an.asisFecha,'yyyy-MM-dd') between :fechaIni  and :fechaFin "
          //  + " and an.identificacion=:nominaCod "
            + " AND (:nominaCod IS NULL OR an.identificacion=:nominaCod)"
            + " and   an.empresa=:empresa and an.biometrico.nombreBiometrico=:nombreBiometrico   ORDER BY an.identificacion ASC ,an.id.asisIng ASC ")
    List<AsistNow> listahoraEntradaBiometrico(String fechaIni, String fechaFin,String nominaCod, String nombreBiometrico , String empresa  );



    @Query(nativeQuery=false, value="select an from AsistNow an  "
            + " where to_char(an.asisFecha,'yyyy-MM-dd') between :fechaIni  and :fechaFin "
           // + " and an.identificacion=:nominaCod " +
           + " AND (:nominaCod IS NULL OR an.identificacion=:nominaCod)"
            + " and   an.empresa=:empresa and an.biometrico.nombreBiometrico=:nombreBiometrico and an.biometrico.tipoBiometrinco=:tipoBiometrinco ")
    List<AsistNow> listahoraSalidadBiometrico(String fechaIni, String fechaFin,String nominaCod, String nombreBiometrico, String tipoBiometrinco , String empresa  ,Sort sort);


    List<AsistNow>   findAllByIdentificacion(String identificacion);

    @Query(nativeQuery=false, value="select an from AsistNow an  "
            + " where to_char(an.asisFecha,'yyyy-MM-dd') between :fechaIni  and :fechaFin "
            + " and an.identificacion=:nominaCod "
            + " and   an.empresa=:empresa and an.biometrico.nombreBiometrico=:nombreBiometrico   and an.biometrico.tipoBiometrinco=:tipoBiometrinco   ORDER BY an.id.asisIng ASC ")
    List<AsistNow> listaDiaAsistenciasBiometrico(String fechaIni, String fechaFin,String nominaCod, String nombreBiometrico ,String tipoBiometrinco , String empresa  );


    Optional<AsistNow> findById_AsisIdAndId_AsisIngAndId_AsisZona(String asisId, Date asisIng, String asisZona );

    @Query(nativeQuery=false, value="select an from AsistNow an  "
            + " where to_char(an.asisFecha,'yyyy-MM-dd') between :fechaIni  and :fechaFin "
            + " and an.identificacion=:nominaCod" +
            "  AND an.asisHorasSuplementaria =:asisHorasSuplementaria"
            + " and   an.empresa=:empresa and an.biometrico.nombreBiometrico=:nombreBiometrico and an.biometrico.tipoBiometrinco=:tipoBiometrinco ")
    List<AsistNow> findAllByIdentificacionEntada(String fechaIni, String fechaFin, String nominaCod,String empresa, String nombreBiometrico , String tipoBiometrinco , boolean asisHorasSuplementaria, Sort sort);

    @Query(nativeQuery=false, value="select an from AsistNow an  "
            + " where to_char(an.asisFecha,'yyyy-MM-dd') between :fechaIni  and :fechaFin "
            + " and an.identificacion=:nominaCod" +
            "  AND an.asisHorasSuplementaria =:asisHorasSuplementaria"
            + " and   an.empresa=:empresa and an.biometrico.nombreBiometrico=:nombreBiometrico and an.biometrico.tipoBiometrinco=:tipoBiometrinco ")
    List<AsistNow> findAllByIdentificacionSalida(String fechaIni, String fechaFin, String nominaCod,String empresa, String nombreBiometrico , String tipoBiometrinco , boolean asisHorasSuplementaria, Sort sort);


    @Modifying
    @Query(nativeQuery = false, value = "update AsistNow asn set asn.asisHorasSuplementaria =:asisHorasSuplementaria" +
            " where asn.identificacion=:identificacion AND asn.id.asisIng=:asisIng AND asn.asisTipo=:asisTipo ")
    @Transactional
    void updateHorasSuplementaria(@Param("identificacion") String identificacion,  @Param("asisIng") Date asisIng  , @Param("asisTipo") String asisTipo  , @Param("asisHorasSuplementaria") boolean asisHorasSuplementaria);

    @Query(nativeQuery = false, value = "SELECT asw.id.asisId,asw.asisFecha,asw.identificacion,asw.apellidos,asw.nombres, " +
            " asw.biometrico.nombreBiometrico AS zona," +
            "    MAX(CASE WHEN asw.asisTipo = 'INGRESO' THEN asw.asisHora END) AS hora_entrada," +
            "    MAX(CASE WHEN asw.asisTipo = 'SALIDA' THEN asw.asisHora END) AS hora_salida," +
            "    MAX(CASE WHEN asw.asisTipo = 'INGRESO' THEN asw.id.asisIng END) AS fecha_entrada," +
            "    MAX(CASE WHEN asw.asisTipo = 'SALIDA' THEN asw.id.asisIng  END) AS fecha_salida, " +
            " asw.empresa " +
            " FROM AsistNow asw " +
            " WHERE ((asw.identificacion like:identificacion or :identificacion is null) AND (asw.apellidos like:apellidos or :apellidos is null)  " +
            " AND to_char(asw.asisFecha,'yyyy-MM-dd') BETWEEN :fechaIni  AND :fechaFin  ) " +
            " AND   (asw.biometrico.nombreBiometrico=:nombreBiometrico) AND (asw.empresa=:empresa) " +
            " GROUP BY" +
            " asw.id.asisId," +
            " asw.asisFecha," +
            " asw.nombres," +
            " asw.apellidos," +
            " asw.identificacion," +
            " asw.biometrico.nombreBiometrico," +
            " asw.empresa " +
            "  ORDER by " +
            " asw.apellidos," +
            " asw.asisFecha  ASC")
      Page<Object[]> consultarMarcacionesEntradaSalidaPagineo(@Param("identificacion") String identificacion,
                                                              @Param("apellidos") String apellidos,
                                                             @Param("fechaIni")  String fechaIni,
                                                             @Param("fechaFin")  String fechaFin ,
                                                             @Param("nombreBiometrico")  String nombreBiometrico,
                                                             @Param("empresa") String empresa  ,Pageable pageable);


  /*  @Query(nativeQuery = false, value = "SELECT asw.id.asisId,asw.asisFecha,asw.identificacion,asw.apellidos,asw.nombres, " +
            " asw.biometrico.nombreBiometrico AS zona," +
            "    MAX(CASE WHEN asw.asisTipo = 'INGRESO' THEN asw.asisHora END) AS hora_entrada," +
            "    MAX(CASE WHEN asw.asisTipo = 'INGRESO' THEN " +
            "        CASE WHEN EXTRACT(HOUR FROM asw.asisIng) >= 16 " +
            "             THEN (SELECT MAX(ed.asisHora) " +
            "                   FROM AsistNow ed " +
            "                   WHERE ed.identificacion = asw.identificacion  " +
            "                         AND ed.asisFecha = a.asisFecha + INTERVAL '1 day' " +
            "                         AND ed.asisTipo = 'SALIDA')" +
            "            " +
            "        END " +
            "    ELSE asw.asisHora END) AS hora_salida," +
            "    MAX(CASE WHEN asw.asisTipo = 'INGRESO' THEN asw.id.asisIng END) AS fecha_entrada," +
            "    MAX(CASE WHEN asw.asisTipo = 'SALIDA' THEN asw.id.asisIng  END) AS fecha_salida, " +
            " asw.empresa " +
            " FROM AsistNow asw " +
            " WHERE ((asw.identificacion like:identificacion or :identificacion is null) AND (asw.apellidos like:apellidos or :apellidos is null)  " +
            " AND to_char(asw.asisFecha,'yyyy-MM-dd') BETWEEN :fechaIni  AND :fechaFin  ) " +
            " AND   (asw.biometrico.nombreBiometrico=:nombreBiometrico) AND (asw.empresa=:empresa) " +
            " GROUP BY" +
            " asw.id.asisId," +
            " asw.asisFecha," +
            " asw.nombres," +
            " asw.apellidos," +
            " asw.identificacion," +
            " asw.biometrico.nombreBiometrico," +
            " asw.empresa " +
            "  ORDER by " +
            " asw.apellidos," +
            " asw.asisFecha  ASC")
    Page<Object[]> consultarMarcacionesEntradaSalidaPagineo(@Param("identificacion") String identificacion,
                                                            @Param("apellidos") String apellidos,
                                                            @Param("fechaIni")  String fechaIni,
                                                            @Param("fechaFin")  String fechaFin ,
                                                            @Param("nombreBiometrico")  String nombreBiometrico,
                                                            @Param("empresa") String empresa  ,Pageable pageable);
*/


    @Query(nativeQuery = false, value = "SELECT " +
            "asw.id.asisId,asw.asisFecha,asw.identificacion,asw.apellidos,asw.nombres,asw.asisTipo, " +
            " asw.biometrico.nombreBiometrico AS zona,asw.asisHora,asw.id.asisIng," +
            " asw.empresa " +
            " FROM AsistNow asw " +
            " WHERE ((asw.identificacion like:identificacion or :identificacion is null) AND (asw.apellidos like:apellidos or :apellidos is null)  " +
            " AND to_char(asw.asisFecha,'yyyy-MM-dd') BETWEEN :fechaIni  AND :fechaFin  ) " +
            " AND   (asw.biometrico.nombreBiometrico=:nombreBiometrico) AND (asw.empresa=:empresa) " +
            "  ORDER by " +
            " asw.apellidos," +
            " asw.asisFecha  ASC")
    List<Object[]>  consultarMarcacionesEntradaSalida(@Param("identificacion") String identificacion,
                                                            @Param("apellidos") String apellidos,
                                                            @Param("fechaIni")  String fechaIni,
                                                            @Param("fechaFin")  String fechaFin ,
                                                            @Param("nombreBiometrico")  String nombreBiometrico,
                                                            @Param("empresa") String empresa );

        @Query(nativeQuery = true, value =  "SELECT" +
                "    a.asis_id," +
                "    a.asis_fecha," +
                "    a.nomina_cod," +
                "    a.nomina_ape," +
                "    a.nomina_nom," +
                "    b.nombre_biometrico AS zona," +
                "    MAX(CASE WHEN a.asis_tipo = 'INGRESO' THEN a.asis_hora END) AS hora_entrada, " +
                "   MAX(CASE WHEN a.asis_tipo = 'INGRESO' THEN " +
                "        CASE WHEN EXTRACT(HOUR FROM a.asis_ing) >= 16 " +
                "             THEN (SELECT MAX(ed.asis_hora) " +
                "                   FROM marcaciones.asistnow ed " +
                "                   WHERE ed.nomina_cod = a.nomina_cod" +
                "                         AND ed.asis_fecha = a.asis_fecha + INTERVAL '1 day' " +
                "                         AND ed.asis_tipo = 'SALIDA') " +
                "            " +
                "        END " +
                "    ELSE a.asis_hora END) AS hora_salida, " +
                "    MAX(CASE WHEN a.asis_tipo = 'INGRESO' THEN a.asis_ing END) AS fecha_entrada, " +
                "    " +
                " MAX(CASE WHEN a.asis_tipo = 'INGRESO' THEN  " +
                "        CASE WHEN EXTRACT(HOUR FROM a.asis_ing) >= 16  " +
                "             THEN (SELECT MAX(ed.asis_ing) " +
                "                   FROM marcaciones.asistnow ed " +
                "                   WHERE ed.nomina_cod = a.nomina_cod " +
                "                         AND ed.asis_fecha = a.asis_fecha + INTERVAL '1 day' " +
                "                         AND ed.asis_tipo = 'SALIDA' " +
                "                  ) " +
                "          " +
                "        END else " +
                "   a.asis_ing  END ) AS fecha_salida   ,a.empresa " +
                " FROM " +
                "    marcaciones.asistnow a " +
                " JOIN " +
                "    marcaciones.biometricos b ON a.asis_zona = b.ip_biometrico " +
                " WHERE " +
                "    ((a.nomina_cod LIKE :identificacion OR  :identificacion IS NULL)   AND (a.nomina_ape LIKE :apellidos OR :apellidos is null)  " +
                "        AND   to_char(a.asis_fecha,'yyyy-MM-dd') BETWEEN :fechaIni  AND :fechaFin )" +
                "    AND (b.nombre_biometrico =:nombreBiometrico )  AND (a.empresa =:empresa ) " +
                "GROUP BY  " +
                "    a.asis_id, " +
                "    a.asis_fecha, " +
                "    a.nomina_nom, " +
                "    a.nomina_ape, " +
                "    a.nomina_cod, " +
                "    b.nombre_biometrico," +
                "   a.empresa  " +
                "  ORDER BY " +
                "    a.nomina_ape, " +
                "    a.asis_fecha ASC ")
    Page<Object[]> consultarMarcacionesEntradaSalidaPagin(@Param("identificacion") String identificacion,
                                                            @Param("apellidos") String apellidos,
                                                            @Param("fechaIni")  String fechaIni,
                                                            @Param("fechaFin")  String fechaFin ,
                                                            @Param("nombreBiometrico")  String nombreBiometrico,
                                                            @Param("empresa") String empresa  ,Pageable pageable);



}

