package com.backSpringBatch.Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import static com.fasterxml.jackson.databind.type.TypeFactory.defaultInstance;
import java.util.List;
import java.util.Map;
@Component
public class UtilsJSON {

    private static final ObjectMapper om = new ObjectMapper();

    public static String objetoToJson(Object obj) {
        try {
            return om.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> jsonToList(Class<T> clase, Object json) {
        try {
            return om.readValue(objetoToJson(json),
                    defaultInstance().constructCollectionType(List.class, clase));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> jsonToMap(String json) {
        try {
            return om.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T jsonToObjeto(Class<T> clase, String json) {
        try {
            return om.readValue(json, clase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T jsonToObjeto(Class<T> clase, Object json) {
        try {
            return om.readValue(objetoToJson(json), clase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}