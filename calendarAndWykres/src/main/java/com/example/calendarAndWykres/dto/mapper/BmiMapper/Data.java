package com.example.calendarAndWykres.dto.mapper.BmiMapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    @JsonProperty("bmi")
    private double bmi;

    @JsonProperty("health")
    private String health;

    @JsonProperty("healthy_bmi_range")
    private String healthyBmiRange;

    public Data() {
    }

    public Data(double bmi, String health, String healthyBmiRange) {
        this.bmi = bmi;
        this.health = health;
        this.healthyBmiRange = healthyBmiRange;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHealthyBmiRange() {
        return healthyBmiRange;
    }

    public void setHealthyBmiRange(String healthyBmiRange) {
        this.healthyBmiRange = healthyBmiRange;
    }

    @Override
    public String toString() {
        return "Data{" +
                "bmi=" + bmi +
                ", health='" + health + '\'' +
                ", healthyBmiRange='" + healthyBmiRange + '\'' +
                '}';
    }
}
