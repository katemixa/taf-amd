package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomUtils {
    public static String generateRandomSting() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public static int generateRandomNumber(int max) {
        return new Random().nextInt(max);
    }

    public static String generateRandomBoundary() {
        return RandomStringUtils.randomAlphanumeric(16);
    }
}
