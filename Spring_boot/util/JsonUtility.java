package com.happyapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {

    public static String getJSON(Object obj) {

        ObjectMapper mapper = new ObjectMapper();
        String resultJSON = "";

        try {
            resultJSON = mapper.writeValueAsString(obj);

            if (resultJSON.indexOf('[') == -1 )
                resultJSON = '['+resultJSON+']';

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return resultJSON;

    }
}
