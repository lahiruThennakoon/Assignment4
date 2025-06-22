package util;

import java.util.Random;

public class TestUtils {
    public static int getRandomNumber(int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound - 1) + 1;

    }
}
