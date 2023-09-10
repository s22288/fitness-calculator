package com.example.calendarAndWykres.dto;

import org.springframework.stereotype.Component;

@Component
public class Bike extends Vechicle {
    @Override
    public String ride() {
        return "run a bike";
    }
}
