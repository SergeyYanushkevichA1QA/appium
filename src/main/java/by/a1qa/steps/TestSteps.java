package by.a1qa.steps;

import aquality.appium.mobile.application.AqualityServices;
import by.a1qa.data.TestData;
import by.a1qa.screens.CityScreen;
import by.a1qa.screens.LocationScreen;
import by.a1qa.screens.MainScreen;
import by.a1qa.screens.SignUpScreen;
import org.testng.Assert;

public class TestSteps {
    private static MainScreen mainScreen = new MainScreen();
    private static SignUpScreen signUpScreen = new SignUpScreen();
    private static CityScreen cityScreen = new CityScreen();
    private static LocationScreen locationScreen = new LocationScreen();

    public static void onboarding() {
        mainScreen.clickNextButton();
        mainScreen.clickNextButton();
        mainScreen.clickNextButton();
        locationScreen.clickSelectButton();
        cityScreen.chooseCity(TestData.cityName);
        signUpScreen.clickContinueWithoutSignUp();
    }
}
