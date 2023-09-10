package com.example.calendarAndWykres.dto.mapper.idealBodyMapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    @JsonProperty("Hamwi")

    private double Hamwi;
    @JsonProperty("Devine")

    private double Devine;
    @JsonProperty("Miller")

    private double Miller;
    @JsonProperty("Robinson")

    private double Robinson;

    public Data() {
    }

    public Data(double hamwi, double devine, double miller, double robinson) {
        Hamwi = hamwi;
        Devine = devine;
        Miller = miller;
        Robinson = robinson;
    }

    @Override
    public String toString() {
        return "Data{" +
                "Hamwi=" + Hamwi +
                ", Devine=" + Devine +
                ", Miller=" + Miller +
                ", Robinson=" + Robinson +
                '}';
    }
}
