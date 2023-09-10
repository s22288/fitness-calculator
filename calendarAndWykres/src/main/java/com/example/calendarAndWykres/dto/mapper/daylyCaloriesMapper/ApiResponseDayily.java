package com.example.calendarAndWykres.dto.mapper.daylyCaloriesMapper;

import com.example.calendarAndWykres.dto.mapper.BmiMapper.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponseDayily {
    @JsonProperty("status_code")
    private int statusCode;

    @JsonProperty("request_result")
    private String requestResult;

    @JsonProperty("data")
    private Data data;



    @Override
    public String toString() {
        return "ApiResponse{" +
                "statusCode=" + statusCode +
                ", requestResult='" + requestResult + '\'' +
                ", data=" + data +
                '}';
    }
}
