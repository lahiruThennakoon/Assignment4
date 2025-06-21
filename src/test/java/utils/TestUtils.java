package utils;

import java.util.Random;

public class TestUtils {
    public static int getRandomNumber(int upperBound) {
        return new Random().nextInt(upperBound);
    }
}
