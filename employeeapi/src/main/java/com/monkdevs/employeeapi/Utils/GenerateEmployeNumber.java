package com.monkdevs.employeeapi.Utils;

import java.util.Random;

public class GenerateEmployeNumber {

    public static String getRandomNumberString(){
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);
    }
    
}
