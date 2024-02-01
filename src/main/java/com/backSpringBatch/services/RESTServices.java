package com.backSpringBatch.services;

import com.backSpringBatch.Util.UtilsJSON;
import com.backSpringBatch.postgres.models.*;
import com.backSpringBatch.sqlserver.models.MarcacionesMongo;
import com.backSpringBatch.sqlserver.models.ResponseMarcacionesMongo;
import com.diosmar.GenericExceptionUtils;
import com.diosmar.LogProducer;
import com.diosmar.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.zalando.problem.Status;

import java.util.HashMap;
import java.util.Map;

@Service
public class RESTServices {



    @Autowired
    Environment env;

    @Autowired
    LogProducer logProducer;


    public ShedulePersonDto getSchedulePerson(String identificacion)
    {

        String ruta = env.getProperty("url_get_schedule");
        ShedulePersonDto rootc = null;
        String rutahistory=ruta;
        rutahistory+="?identificacion="+identificacion;
        try {

          Response response = RestAssured.given()
                    .headers(
                            "Content-Type",
                            ContentType.JSON,
                            "Accept",
                            ContentType.JSON)
                    .contentType("application/json").when().get(rutahistory)
                    .then().extract().response();

            String json = response.getBody().asString();
            Gson gson = new Gson();
            rootc = gson.fromJson(json, new TypeToken<ShedulePersonDto>() {
            }.getType());
        } catch (Exception ex) {
            if(ex.getMessage().toLowerCase().contains("connection refused")) {
                throw new GenericExceptionUtils(
                        Utils.replaceText("{} --> metodo: '{}' - url: '{}' - body: '{}'", ex.getMessage(), "GET", ruta)
                        , Status.BAD_REQUEST
                );
            }else{
                throw new GenericExceptionUtils(ex.getMessage(), Status.BAD_REQUEST);
            }
        }
        return rootc;
    }

    public PersonResponseS consultarPersonaTipoBiometricoCalculo(String identificacion)
    {

        String ruta = env.getProperty("urlConsultarPersonaTipoBiometricoCalculo");
        PersonResponseS rootc = null;
        String rutahistory=ruta;
        rutahistory+="?identificacion="+identificacion;
        try {
            Response response = RestAssured.given()
                    .headers(
                            "Content-Type",
                            ContentType.JSON,
                            "Accept",
                            ContentType.JSON)
                    .contentType("application/json").when().get(rutahistory)
                    .then().extract().response();
            String json = response.getBody().asString();
            Gson gson = new Gson();
            rootc = gson.fromJson(json, new TypeToken<PersonResponseS>() {
            }.getType());
        } catch (Exception ex) {
            if(ex.getMessage().toLowerCase().contains("connection refused")) {
                throw new GenericExceptionUtils(
                        Utils.replaceText("{} --> metodo: '{}' - url: '{}' - body: '{}'", ex.getMessage(), "GET", ruta)
                        , Status.BAD_REQUEST
                );
            }else{
                throw new GenericExceptionUtils(ex.getMessage(), Status.BAD_REQUEST);
            }
        }
        return rootc;
    }


    /*Servicios de Mongo*/
    public ResponseMarcacionesMongo saveMarcacionesMongo (MarcacionesMongo marcacionesMongo) {
        String urlRemote = env.getProperty("urlRecursoHumanoslogs");

        ResponseMarcacionesMongo rootc = null;
        try {
            Response response = RestAssured.given()
                    .headers(
                            "Content-Type",
                            ContentType.JSON,
                            "Accept",
                            ContentType.JSON)
                    .contentType("application/json").body(marcacionesMongo)
                    .when().post(urlRemote)
                    .then().extract().response();
            String json = response.getBody().asString();
            ObjectMapper om = new ObjectMapper();
          //  rootc = om.readValue(json, ResponseMarcacionesMongo.class);
        } catch (Exception ex) {
            if(ex.getMessage().toLowerCase().contains("connection refused")) {
                throw new GenericExceptionUtils(
                        Utils.replaceText("{} --> metodo: '{}' - url: '{}' - body: '{}'", ex.getMessage(), "POST", urlRemote, Utils.toJson(marcacionesMongo))
                        , Status.BAD_REQUEST
                );
            }else{
                throw new GenericExceptionUtils(ex.getMessage(), Status.BAD_REQUEST);
            }
        }
        return rootc;
    }

    public ResponsePeriodoActual consultarPeriodoActual()
    {
        String ruta = env.getProperty("urlConsultarPeriodoActual");
        ResponsePeriodoActual rootc=null;
        try {
            Response response = RestAssured.given()
                    .headers(
                            "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                    .contentType("application/json;charset=utf-8").when()
                    .get(ruta)
                    .then().extract().response();
            rootc = response.getBody().as(ResponsePeriodoActual.class);
        } catch (Exception ex)
        {
            if(ex.getMessage().toLowerCase().contains("connection refused")) {
                throw new GenericExceptionUtils(
                        Utils.replaceText("{} --> metodo: '{}' - url: '{}' - body: '{}'", ex.getMessage(), "GET", ruta)
                        , Status.BAD_REQUEST
                );
            }else{
                throw new GenericExceptionUtils(ex.getMessage(), Status.BAD_REQUEST);
            }
        }
        return rootc;

    }

    public EmpresaResponse findByEstadoEmpCodigoEmpresa(String empCodigo)
    {
        String ruta = env.getProperty("urlFindByEstadoEmpCodigoEmpresa");
        ruta+="?empCodigo="+empCodigo;
        EmpresaResponse rootc=null;
        try {
            Response response = RestAssured.given()
                    .headers(
                            "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                    .contentType("application/json;charset=utf-8").when()
                    .get(ruta)
                    .then().extract().response();
            rootc = response.getBody().as(EmpresaResponse.class);
        } catch (Exception ex)
        {
            if(ex.getMessage().toLowerCase().contains("connection refused")) {
                throw new GenericExceptionUtils(
                        Utils.replaceText("{} --> metodo: '{}' - url: '{}' - body: '{}'", ex.getMessage(), "GET", ruta)
                        , Status.BAD_REQUEST
                );
            }else{
                throw new GenericExceptionUtils(ex.getMessage(), Status.BAD_REQUEST);
            }
        }
        return rootc;

    }

    public ResponsePersonaProduccionFija consultarPersonaProduccionFijaCalculo(String tipoNomina)
    {
        String ruta = env.getProperty("urlConsultarPersonaProduccionFija");
        ruta+="?tipoNomina="+tipoNomina;
        ResponsePersonaProduccionFija rootc=null;
        try {
            Response response = RestAssured.given()
                    .headers(
                            "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                    .contentType("application/json;charset=utf-8").when()
                    .get(ruta)
                    .then().extract().response();
            rootc = response.getBody().as(ResponsePersonaProduccionFija.class);
        } catch (Exception ex)
        {
            if(ex.getMessage().toLowerCase().contains("connection refused")) {
                throw new GenericExceptionUtils(
                        Utils.replaceText("{} --> metodo: '{}' - url: '{}' - body: '{}'", ex.getMessage(), "GET", ruta)
                        , Status.BAD_REQUEST
                );
            }else{
                throw new GenericExceptionUtils(ex.getMessage(), Status.BAD_REQUEST);
            }
        }
        return rootc;

    }

    public ResponsePersonaProduccionFija findAllByPersonalHorasExtras(boolean horasExtras)
    {
        String ruta = env.getProperty("urlFindAllByPersonalHorasExtras");
        ruta+="?horasExtras="+horasExtras;
        ResponsePersonaProduccionFija rootc=null;
        try {
            Response response = RestAssured.given()
                    .headers(
                            "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                    .contentType("application/json;charset=utf-8").when()
                    .get(ruta)
                    .then().extract().response();
            rootc = response.getBody().as(ResponsePersonaProduccionFija.class);
        } catch (Exception ex)
        {
            if(ex.getMessage().toLowerCase().contains("connection refused")) {
                throw new GenericExceptionUtils(
                        Utils.replaceText("{} --> metodo: '{}' - url: '{}' - body: '{}'", ex.getMessage(), "GET", ruta)
                        , Status.BAD_REQUEST
                );
            }else{
                throw new GenericExceptionUtils(ex.getMessage(), Status.BAD_REQUEST);
            }
        }
        return rootc;

    }

    public EmpresaResponse findAllByEmpresa()
    {
        String ruta = env.getProperty("urlFindAllByEmpresa");
        EmpresaResponse rootc=null;
        try {
            Response response = RestAssured.given()
                    .headers(
                            "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                    .contentType("application/json;charset=utf-8").when()
                    .get(ruta)
                    .then().extract().response();
            rootc = response.getBody().as(EmpresaResponse.class);
        } catch (Exception ex)
        {
            // TODO: handle exception
            ex.printStackTrace();
            throw new GenericExceptionUtils(ex);
        }
        return rootc;

    }


    public String parametrizacionRecursosHumanos(String nombreParametro)
    {
        String ruta = env.getProperty("urlParametrizacionRecursosHumanos");
        ruta+="?nombreParametro="+nombreParametro;
        Map<String, Object> rootc=null;
        String valorParametro;
        try {
            Response response = RestAssured.given()
                    .headers(
                            "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                    .contentType("application/json;charset=utf-8").when()
                    .get(ruta)
                    .then().extract().response();
               rootc = response.getBody().as(HashMap.class);
             valorParametro = UtilsJSON.jsonToObjeto(String.class, rootc.get("valorParametro"));
        } catch (Exception ex)
        {
            if(ex.getMessage().toLowerCase().contains("connection refused")) {
                throw new GenericExceptionUtils(
                        Utils.replaceText("{} --> metodo: '{}' - url: '{}' - body: '{}'", ex.getMessage(), "GET", ruta)
                        , Status.BAD_REQUEST
                );
            }else{
                throw new GenericExceptionUtils(ex.getMessage(), Status.BAD_REQUEST);
            }
        }
        return valorParametro;

    }

    public void modificacionAsistenciasEntradaSalida(String identificacion ,String periodo,String fechaAsistencia)
    {
        String ruta = env.getProperty("urlModificacionAsistenciasEntradaSalida");
        ruta+="?identificacion="+identificacion+"&periodo="+periodo+"&fechaAsistencia="+fechaAsistencia;
        String rootc=null;
        try {
            Response response = RestAssured.given()
                    .headers(
                            "Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                    .contentType("application/json;charset=utf-8").when()
                    .get(ruta)
                    .then().extract().response();
        } catch (Exception ex)
        {
            // TODO: handle exception
            if(ex.getMessage().toLowerCase().contains("connection refused")) {
                throw new GenericExceptionUtils(
                        Utils.replaceText("{} --> metodo: '{}' - url: '{}' - body: '{}'", ex.getMessage(), "GET", ruta)
                        , Status.BAD_REQUEST
                );
            }else{
                throw new GenericExceptionUtils(ex.getMessage(), Status.BAD_REQUEST);
            }
        }

    }

}
