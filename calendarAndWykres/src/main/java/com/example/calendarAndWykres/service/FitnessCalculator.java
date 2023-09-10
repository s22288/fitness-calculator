package com.example.calendarAndWykres.service;

import com.example.calendarAndWykres.controllers.FitnessCalculatorController;
import com.example.calendarAndWykres.dto.mapper.BmiMapper.ApiResponseBmi;
import com.example.calendarAndWykres.dto.mapper.JsonToPOJO;
import com.example.calendarAndWykres.dto.mapper.idealBodyMapper.ApiResponseIdealBodyWeight;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;


@Component
public class FitnessCalculator implements FitnessCalculators {
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(FitnessCalculator.class);

    @Autowired
    private OkHttpClient client;


    private final JsonToPOJO convert = new JsonToPOJO();

    @Override
    public ApiResponseBmi calculateBmi(int age, double weight, double height) {
        Request request = new Request.Builder()
                .url("https://fitness-calculator.p.rapidapi.com/bmi?age="+ age+"&weight="+weight+"&height="+height)
                .get()
                .addHeader("X-RapidAPI-Key", "00e1ca4037msh01c1330f82d75dap133b7cjsnc6c2612e3864")
                .addHeader("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
                .build();
        ApiResponseBmi apiResponseBmi = null;

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBodyString = response.body().string();



                apiResponseBmi = convert.toJavaClass(responseBodyString, ApiResponseBmi.class);

            } else {
                logger.error("Request was not successful. HTTP code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return apiResponseBmi;
    }


    @Override
    public ApiResponseIdealBodyWeight idealWeight(String gender, double height) {
        Request request = new Request.Builder()
                .url("https://fitness-calculator.p.rapidapi.com/idealweight?gender="+ gender + "&height=" + height)
                .get()
                .addHeader("X-RapidAPI-Key", "00e1ca4037msh01c1330f82d75dap133b7cjsnc6c2612e3864")
                .addHeader("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
                .build();
        ApiResponseIdealBodyWeight idealBodyWeight = null;
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBodyString = response.body().string();


                idealBodyWeight = convert.toJavaClass(responseBodyString, ApiResponseIdealBodyWeight.class);

            } else {
                logger.error("Request was not successful. HTTP code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return idealBodyWeight;
    }

    @Override
    public Double bodyFatPercentage(int age, String sex, double weight, double height, double neck, double waist, double hip) {
        Request request = new Request.Builder()
                .url("https://fitness-calculator.p.rapidapi.com/bodyfat?age=25&gender=male&weight=70&height=178&neck=50&waist=96&hip=92")
                .get()
                .addHeader("X-RapidAPI-Key", "00e1ca4037msh01c1330f82d75dap133b7cjsnc6c2612e3864")
                .addHeader("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
                .build();
//        Response response = client.newCall(request).execute();
        return null;
    }

    @Override
    public Double dayliFatRequirement(int age, String gender, double height, double weight, int activityLevel) {
        Request request = new Request.Builder()
                .url("https://fitness-calculator.p.rapidapi.com/dailycalorie?age=25&gender=male&height=180&weight=70&activitylevel=level_1")
                .get()
                .addHeader("X-RapidAPI-Key", "00e1ca4037msh01c1330f82d75dap133b7cjsnc6c2612e3864")
                .addHeader("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
                .build();
//        Response response = client.newCall(request).execute();
        return null;
    }


    //   private JsonToPOJO convert;
//
//   private ApiResponse bmi  = new ApiResponse();
//
//   private ApiResponseIdealBodyWeight idealBodyWeight = new ApiResponseIdealBodyWeight();
//
//    private static final Logger logger = LoggerFactory.getLogger(FitnessCalculator.class);
//
//    public FitnessCalculator(JsonToPOJO convert) {
//        this.convert = convert;
//    }
//
//public String calculateIdealWeigth(){
//    OkHttpClient client = new OkHttpClient();
//List<Integer> list = Arrays.asList(3,3,5,6);
//
//    Request request = new Request.Builder()
//            .url("https://fitness-calculator.p.rapidapi.com/idealweight?gender=male&height=180")
//            .get()
//            .addHeader("X-RapidAPI-Key", "00e1ca4037msh01c1330f82d75dap133b7cjsnc6c2612e3864")
//            .addHeader("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
//            .build();
//
//
//    Response response = null;
//    try {
//        response = client.newCall(request).execute();
////        ApiResponse apiResponse = convert.ToJavaClass(response.body().toString(), new com.example.calendarAndWykres.dto.mapper.idealBodyService.Data());
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    } finally {
//        if (response != null) {
//            response.close();
//        }
//    }
//
//
//}
//
//
//
//    public void response (int age , double weight , double height)  {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("https://fitness-calculator.p.rapidapi.com/bmi?age="+age+"&weight="+weight+"&height="+ height)
//                .get()
//                .addHeader("X-RapidAPI-Key", "00e1ca4037msh01c1330f82d75dap133b7cjsnc6c2612e3864")
//                .addHeader("X-RapidAPI-Host", "fitness-calculator.p.rapidapi.com")
//                .build();
//
//        try {
//
//            client.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    e.printStackTrace();
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//                    if (!response.isSuccessful()) {
//                    } else {
//                        String responseBody = response.body().string();
//                        logger.info("body " + responseBody);
//                         bmi = convert.ToJavaClass(responseBody, new Data());
//                         setBmi(bmi);
//
//
//                    }
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//    }
//
//
//    public JsonToPOJO getConvert() {
//        return convert;
//    }
//
//    public void setConvert(JsonToPOJO convert) {
//        this.convert = convert;
//    }
//
//    public ApiResponse getBmi() {
//        return bmi;
//    }
//
//    public ApiResponseIdealBodyWeight getIdealBodyWeight() {
//        return idealBodyWeight;
//    }
//
//    public void setIdealBodyWeight(ApiResponseIdealBodyWeight idealBodyWeight) {
//        this.idealBodyWeight = idealBodyWeight;
//    }
//
//    public void setBmi(ApiResponse bmi) {
//        this.bmi = bmi;
//    }
//
//    @Override
//    public String toString() {
//        return "FitnessCalculator{" +
//                "convert=" + convert +
//                ", bmi=" + bmi +
//                '}';
//    }
}
