package by.a1qa.steps;

import by.a1qa.data.OnboardingScreenTitle;
import by.a1qa.screens.CityScreen;
import by.a1qa.screens.LocationScreen;
import by.a1qa.screens.OnboardingScreen;
import by.a1qa.screens.SignUpScreen;

public class TestSteps {
    private static OnboardingScreen onboardingScreen = new OnboardingScreen();
    private static SignUpScreen signUpScreen = new SignUpScreen();
    private static CityScreen cityScreen = new CityScreen();
    private static LocationScreen locationScreen = new LocationScreen();

    public static void onboarding() {
        onboardingScreen.clickNextButton();
        onboardingScreen.clickNextButton();
        onboardingScreen.clickNextButton();
        locationScreen.clickSelectButton();
        cityScreen.chooseCity(OnboardingScreenTitle.cityName);
        signUpScreen.clickContinueWithoutSignUp();
    }
}
