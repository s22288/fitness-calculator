package com.example.calendarAndWykres.controllers;

import com.example.calendarAndWykres.dto.Vechicle;
import com.example.calendarAndWykres.dto.mapper.BmiMapper.ApiResponseBmi;
import com.example.calendarAndWykres.dto.mapper.idealBodyMapper.ApiResponseIdealBodyWeight;
import com.example.calendarAndWykres.service.FitnessCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FitnessCalculatorController {
    private static final Logger logger = LoggerFactory.getLogger(FitnessCalculatorController.class);




 private final FitnessCalculator fitnessCalculator;

    public FitnessCalculatorController(FitnessCalculator fitnessCalculator) {
        this.fitnessCalculator = fitnessCalculator;
    }

    @GetMapping("/ideal-weight")
    public  ResponseEntity calculateIdealWeight (@RequestParam String gender,@RequestParam double height)  {
        ApiResponseIdealBodyWeight idealBodyWeight = fitnessCalculator.idealWeight(gender, height);
        return ResponseEntity.ok(idealBodyWeight);

    }

    @GetMapping("/calculate-Bmi")
    public ResponseEntity calculateBmi(@RequestParam int weight, @RequestParam  int height , @RequestParam  int age ){
        ApiResponseBmi apiResponseBmi = fitnessCalculator.calculateBmi(age, weight, height);
        return ResponseEntity.ok(apiResponseBmi);
    }
}
