package com.backSpringBatch.postgres.entity;


import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import javax.persistence.*;



@Entity
@Table(name ="biometricos", schema = "public")
public class Biometrico {


    @Id
    @Column(name = "id_biometrico", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column(name = "ip_biometrico")
    private String ipBiometrico;

    @Column(name = "tipo_biometrico")
    private String tipoBiometrinco;


    @Column(name = "nombre_biometrico")
    private String nombreBiometrico;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpBiometrico() {
        return ipBiometrico;
    }

    public void setIpBiometrico(String ipBiometrico) {
        this.ipBiometrico = ipBiometrico;
    }

    public String getTipoBiometrinco() {
        return tipoBiometrinco;
    }

    public void setTipoBiometrinco(String tipoBiometrinco) {
        this.tipoBiometrinco = tipoBiometrinco;
    }


    public String getNombreBiometrico() {
        return nombreBiometrico;
    }

    public void setNombreBiometrico(String nombreBiometrico) {
        this.nombreBiometrico = nombreBiometrico;
    }
}



