package com.backSpringBatch.services;

import com.backSpringBatch.Util.ScheduleDTO;
import com.backSpringBatch.postgres.models.PersonResponseS;
import com.backSpringBatch.postgres.models.ShedulePersonDto;
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


    public ShedulePersonDto getSchedulePerson(String identificacion)
    {

        //System.out.println("getSchedulePerson"+identificacion);
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
         //   System.out.println("json"+response.getStatusLine());
          //  System.out.println("json"+response.getStatusCode());
            rootc = gson.fromJson(json, new TypeToken<ShedulePersonDto>() {
            }.getType());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return rootc;
    }

    public PersonResponseS consultarPersonaTipoBiometricoCalculo(String identificacion)
    {

        //System.out.println("consultarPersonaTipoBiometricoCalculo"+identificacion);
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
