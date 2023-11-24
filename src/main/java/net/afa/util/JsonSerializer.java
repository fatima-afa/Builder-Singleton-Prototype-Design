package net.afa.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.runtime.ObjectMethods;

public class JsonSerializer<T> {
    public String toJson(T dataObject){
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataObject);
            return json;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
