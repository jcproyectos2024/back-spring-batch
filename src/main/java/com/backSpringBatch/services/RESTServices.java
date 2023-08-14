package com.backSpringBatch.services;

import com.backSpringBatch.Util.ScheduleDTO;
import com.backSpringBatch.postgres.models.PersonResponseS;
import com.backSpringBatch.sqlserver.models.MarcacionesMongo;
import com.backSpringBatch.sqlserver.models.ResponseMarcacionesMongo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class RESTServices {



    @Autowired
    Environment env;


    public ScheduleDTO getSchedulePerson(String identificacion)
    {
        HttpServletRequest request1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token1 = request1.getHeader("authorization").toString();

        String ruta = env.getProperty("url_get_schedule");
        ScheduleDTO rootc = null;
        String rutahistory=ruta;
        rutahistory+="?identificacion="+identificacion;
        try {
//            Response response =
//                    RestAssured.given().contentType("application/json")
//                            .when().get(rutahistory).then().extract().response();

            Response response = RestAssured.given()
                    .headers(
                            "Authorization",
                            token1 ,
                            "Content-Type",
                            ContentType.JSON,
                            "Accept",
                            ContentType.JSON)
                    .contentType("application/json").when().get(rutahistory)
                    .then().extract().response();

            String json = response.getBody().asString();
            Gson gson = new Gson();
            rootc = gson.fromJson(json, new TypeToken<ScheduleDTO>() {
            }.getType());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rootc;
    }

    public PersonResponseS consultarPersonaTipoBiometricoCalculo(String identificacion)
    {
        HttpServletRequest request1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token1 = request1.getHeader("authorization").toString();

        String ruta = env.getProperty("consultarPersonaTipoBiometricoCalculo");
        PersonResponseS rootc = null;
        String rutahistory=ruta;
        rutahistory+="?identificacion="+identificacion;
        try {
//            Response response =
//                    RestAssured.given().contentType("application/json")
//                            .when().get(rutahistory).then().extract().response();
            Response response = RestAssured.given()
                    .headers(
                            "Authorization",
                            token1 ,
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
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
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
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rootc;
    }


}
