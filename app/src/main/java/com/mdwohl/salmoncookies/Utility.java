package com.mdwohl.salmoncookies;

import java.util.Random;

public class Utility {
    private static Random rand = new Random();
    public static Integer randomIntInRange(int min, int max){
      Integer averageCustomersPerHour = rand.nextInt((max - min) + 1) + min;
        return averageCustomersPerHour;

    };
}
