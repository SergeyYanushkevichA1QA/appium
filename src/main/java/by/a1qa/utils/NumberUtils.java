package by.a1qa.utils;

public class NumberUtils {

    private NumberUtils() {}

    public static int getRandomNumber(int maxExcluded) {
        return (int) (Math.random() * maxExcluded);
    }
}
