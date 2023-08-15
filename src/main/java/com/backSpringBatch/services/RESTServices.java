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

       // HttpServletRequest request1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ4ZHp3RkY0ZC1GTDV0N09Kb1JRQzhOMEppMElqQkc1V0lJa01rNThrZGtVIn0.eyJleHAiOjE2OTA1MjIwMTQsImlhdCI6MTY5MDQ5MzIxNCwianRpIjoiNTIzN2Y4YjAtNTBiOS00NmI4LWI4MjctMWQ4YTBmZTM4ODU5IiwiaXNzIjoiaHR0cDovLzE3Mi4xNi4xMS4yNTo4MDgwL3JlYWxtcy9QUk9DQU1BUk9ORVgiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiZWYwZjQ3NjItYzc1Yi00MDRmLWE2ZjItMTBiMjgxNzJkZDIyIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiYXBpLWdhdGV3YXkiLCJzZXNzaW9uX3N0YXRlIjoiZjU2YmMzNzYtNzg5OC00OTcxLTg5MDAtNzk1MmJjY2ZjODExIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vbG9jYWxob3N0Ojk5OTgiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwiZGVmYXVsdC1yb2xlcy1wcm9jYW1hcm9uZXgiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoicHJvZmlsZSBlbWFpbCIsInNpZCI6ImY1NmJjMzc2LTc4OTgtNDk3MS04OTAwLTc5NTJiY2NmYzgxMSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Ikp1bGlvIEFsYXJjb24iLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJqaGVyZWRpYSIsImdpdmVuX25hbWUiOiJKdWxpbyIsImZhbWlseV9uYW1lIjoiQWxhcmNvbiIsImVtYWlsIjoiamhlcmVkaWFAcHJvY2FtYXJvbmV4LmNvbSJ9.YIhmqTvFreNJCudM8KZlFg6wtYrOUBGSYHYkkC66zqMywR4N_xGDO-6nYD9nd6Uo0L0naERqLev-bUxO-_nqv1HjPTIcdORso181COwYOiPBWZ1KjdEfmzu9bpGqz9Bab-Jp-7f0FdbkVugvuDkoChlBf5zjjiS6WjcdBpHLxs8gWXWQJxV6nK-y-HN-CitTZa508XFCWOJGlZL-dhpluyLFU5XobvoGn170qYc_zfDIz-smjDWbhuGNR5fkn0kskIPBDDgfJC1Vr2X3mYJxKh5dw0ENcrS2c9nMb-VJYMoLc7EjaX_F-Lhpm09t495VXUQ4yqyoyrDE62Gid82acQ";

        String ruta = env.getProperty("url_get_schedule");
        ScheduleDTO rootc = null;
        String rutahistory=ruta;
        rutahistory+="?identificacion="+identificacion;
        try {
        /*  Response response =
               RestAssured.given().contentType("application/json")
                         .when().get(rutahistory).then().extract().response();*/

          Response response = RestAssured.given()
                    .headers(
                            "Authorization",
                            token ,
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
       /* HttpServletRequest request1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token1 = request1.getHeader("authorization").toString();
*/
        String token1 = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ4ZHp3RkY0ZC1GTDV0N09Kb1JRQzhOMEppMElqQkc1V0lJa01rNThrZGtVIn0.eyJleHAiOjE2OTA1MjIwMTQsImlhdCI6MTY5MDQ5MzIxNCwianRpIjoiNTIzN2Y4YjAtNTBiOS00NmI4LWI4MjctMWQ4YTBmZTM4ODU5IiwiaXNzIjoiaHR0cDovLzE3Mi4xNi4xMS4yNTo4MDgwL3JlYWxtcy9QUk9DQU1BUk9ORVgiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiZWYwZjQ3NjItYzc1Yi00MDRmLWE2ZjItMTBiMjgxNzJkZDIyIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiYXBpLWdhdGV3YXkiLCJzZXNzaW9uX3N0YXRlIjoiZjU2YmMzNzYtNzg5OC00OTcxLTg5MDAtNzk1MmJjY2ZjODExIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vbG9jYWxob3N0Ojk5OTgiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwiZGVmYXVsdC1yb2xlcy1wcm9jYW1hcm9uZXgiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoicHJvZmlsZSBlbWFpbCIsInNpZCI6ImY1NmJjMzc2LTc4OTgtNDk3MS04OTAwLTc5NTJiY2NmYzgxMSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Ikp1bGlvIEFsYXJjb24iLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJqaGVyZWRpYSIsImdpdmVuX25hbWUiOiJKdWxpbyIsImZhbWlseV9uYW1lIjoiQWxhcmNvbiIsImVtYWlsIjoiamhlcmVkaWFAcHJvY2FtYXJvbmV4LmNvbSJ9.YIhmqTvFreNJCudM8KZlFg6wtYrOUBGSYHYkkC66zqMywR4N_xGDO-6nYD9nd6Uo0L0naERqLev-bUxO-_nqv1HjPTIcdORso181COwYOiPBWZ1KjdEfmzu9bpGqz9Bab-Jp-7f0FdbkVugvuDkoChlBf5zjjiS6WjcdBpHLxs8gWXWQJxV6nK-y-HN-CitTZa508XFCWOJGlZL-dhpluyLFU5XobvoGn170qYc_zfDIz-smjDWbhuGNR5fkn0kskIPBDDgfJC1Vr2X3mYJxKh5dw0ENcrS2c9nMb-VJYMoLc7EjaX_F-Lhpm09t495VXUQ4yqyoyrDE62Gid82acQ";

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
