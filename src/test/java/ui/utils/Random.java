package ui.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Random {
    public static String generateRandomSting() {
        return RandomStringUtils.randomAlphabetic(8);
    }
}
