package by.a1qa.steps;

import aquality.appium.mobile.application.AqualityServices;
import by.a1qa.data.TestData;
import by.a1qa.screens.city.CityScreen;
import by.a1qa.screens.location.LocationScreen;
import by.a1qa.screens.main.MainScreen;
import by.a1qa.screens.signup.SignUpScreen;

public class TestSteps {
    private static MainScreen mainScreen = AqualityServices.getScreenFactory().getScreen(MainScreen.class);
    private static SignUpScreen signUpScreen = AqualityServices.getScreenFactory().getScreen(SignUpScreen.class);
    private static CityScreen cityScreen = AqualityServices.getScreenFactory().getScreen(CityScreen.class);
    private static LocationScreen locationScreen = AqualityServices.getScreenFactory().getScreen(LocationScreen.class);

    public static void onboarding() {
        mainScreen.clickNextButton();
        mainScreen.clickNextButton();
        mainScreen.clickNextButton();
        locationScreen.clickSelectButton();
        String cityName = "London";
        cityScreen.chooseCity(cityName);
        signUpScreen.clickContinueWithoutSignUp();
    }
}
