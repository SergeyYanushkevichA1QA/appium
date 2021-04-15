package by.a1qa.utils;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.logging.Logger;

public class Log {
    private static final Logger LOGGER = AqualityServices.getLogger();

    private Log() {}

    public static void step(int step, String msg) {
        LOGGER.info(String.format("Step %s: %s", step, msg));
    }

    public static void info(String msg) {
        LOGGER.info(msg);
    }
}