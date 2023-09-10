package com.example.calendarAndWykres.dto.mapper;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class JsonToPOJO {
    @Autowired
    private Gson gson = new Gson();


    public <T> T toJavaClass(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
