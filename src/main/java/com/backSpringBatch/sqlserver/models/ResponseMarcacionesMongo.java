package com.backSpringBatch.sqlserver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMarcacionesMongo
{


    private Boolean success;
    private String message;
    private Object datasource;

    public ResponseMarcacionesMongo() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDatasource() {
        return datasource;
    }

    public void setDatasource(Object datasource) {
        this.datasource = datasource;
    }
}
