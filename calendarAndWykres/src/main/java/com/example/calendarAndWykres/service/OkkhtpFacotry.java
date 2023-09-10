package com.example.calendarAndWykres.service;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class OkkhtpFacotry {
    @Bean
    public OkHttpClient  OkkhtpFacotry(){
        return  new OkHttpClient();
    }
}
