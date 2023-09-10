package com.example.calendarAndWykres.dto.mapper.BmiMapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponseBmi {
    @JsonProperty("status_code")
    private int statusCode;

    @JsonProperty("request_result")
    private String requestResult;

    @JsonProperty("data")
    private Data data;

    // Getters and setters for the fields

    // Data class definition (same as before)

    @Override
    public String toString() {
        return "ApiResponse{" +
                "statusCode=" + statusCode +
                ", requestResult='" + requestResult + '\'' +
                ", data=" + data +
                '}';
    }
}
