package com.example.calendarAndWykres.service;

import com.example.calendarAndWykres.dto.mapper.BmiMapper.ApiResponseBmi;
import com.example.calendarAndWykres.dto.mapper.idealBodyMapper.ApiResponseIdealBodyWeight;
import okhttp3.Request;
import okhttp3.Response;

public interface FitnessCalculators {
    ApiResponseBmi calculateBmi(int age, double weight, double height);

    ApiResponseIdealBodyWeight idealWeight(String sex, double height);



    Double bodyFatPercentage(int age, String sex, double weight, double height, double neck, double waist, double hip);

    Double dayliFatRequirement(int age,String gender,double height,double weight, int activityLevel);


}
