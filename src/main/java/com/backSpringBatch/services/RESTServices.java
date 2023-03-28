package com.backSpringBatch.services;

import com.backSpringBatch.Util.ScheduleDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class RESTServices {



    @Autowired
    Environment env;


    public ScheduleDTO getSchedulePerson(String identificacion) {
        String ruta = env.getProperty("url_get_schedule");
        ScheduleDTO rootc = null;
        String rutahistory=ruta;
        rutahistory=identificacion;
        try {
            Response response =
                    RestAssured.given().contentType("application/json")
                            .when().get(rutahistory).then().extract().response();

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
}
