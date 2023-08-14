package com.backSpringBatch.sqlserver.models;

import java.util.List;

public class MarcacionesMongo
{

    private String tenant;
    private String database;
    private String collection;
    private String compositeKey;

    private List<AsistNowRegistroDTO> payload;


    public MarcacionesMongo() {
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getCompositeKey() {
        return compositeKey;
    }

    public void setCompositeKey(String compositeKey) {
        this.compositeKey = compositeKey;
    }

    public List<AsistNowRegistroDTO> getPayload() {
        return payload;
    }

    public void setPayload(List<AsistNowRegistroDTO> payload) {
        this.payload = payload;
    }
}
