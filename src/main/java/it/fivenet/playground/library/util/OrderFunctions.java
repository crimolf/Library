package it.fivenet.playground.library.util;

import java.util.Random;

public class OrderFunctions {
    public long randomLong() {
        long lowerLimit = 123456712L;
        long upperLimit = 234567892L;
        Random r = new Random();
        long number = lowerLimit + ((long) (r.nextDouble() * (upperLimit - lowerLimit)));
        return number;
    }
}
