package com.example.calendarAndWykres.dto.mapper.idealBodyMapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponseIdealBodyWeight {
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
