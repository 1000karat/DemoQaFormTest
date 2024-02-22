package com.demoqa.helper;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

public class GenerateTestData {
    static Random random = new Random();
    static Faker faker = new Faker();

    public static String[] getCalendarDate() {
        return new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).format(faker.date().birthday(16, 100))
                .split(" ");
    }

    public static String getState() {
        String[] stateArray = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int indexStateArray = random.nextInt(stateArray.length);
        return stateArray[indexStateArray];
    }

    public static String getCity(String state) {
        switch (state) {
            case "NCR": {
                String[] cityArray = {"Delhi", "Gurgaon", "Noida"};
                int indexCityArray = random.nextInt(cityArray.length);
                return cityArray[indexCityArray];

            }
            case "Uttar Pradesh": {
                String[] cityArray = {"Agra", "Lucknow", "Merrut"};
                int indexCityArray = random.nextInt(cityArray.length);
                return cityArray[indexCityArray];

            }
            case "Haryana": {
                String[] cityArray = {"Karnal", "Panipat"};
                int indexCityArray = random.nextInt(cityArray.length);
                return cityArray[indexCityArray];

            }
            case "Rajasthan": {
                String[] cityArray = {"Jaipur", "Jaiselmer"};
                int indexCityArray = random.nextInt(cityArray.length);
                return cityArray[indexCityArray];

            }
        }
        return state;
    }
}
