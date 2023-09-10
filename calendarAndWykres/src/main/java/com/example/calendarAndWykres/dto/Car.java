package com.example.calendarAndWykres.dto;

import org.springframework.stereotype.Component;

@Component
public class Car extends Vechicle{
    @Override
    public String ride() {
        return "run a car";
    }
}
