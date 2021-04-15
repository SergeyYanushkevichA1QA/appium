package by.a1qa.steps;

import aquality.appium.mobile.application.AqualityServices;
import by.a1qa.data.OnboardingScreenTitle;
import by.a1qa.screens.city.CityScreen;
import by.a1qa.screens.location.LocationScreen;
import by.a1qa.screens.onboarding.OnboardingScreen;
import by.a1qa.screens.signup.SignUpScreen;

public class TestSteps {
    private static OnboardingScreen onboardingScreen = AqualityServices.getScreenFactory().getScreen(OnboardingScreen.class);
    private static SignUpScreen signUpScreen = AqualityServices.getScreenFactory().getScreen(SignUpScreen.class);
    private static CityScreen cityScreen = AqualityServices.getScreenFactory().getScreen(CityScreen.class);
    private static LocationScreen locationScreen = AqualityServices.getScreenFactory().getScreen(LocationScreen.class);

    public static void onboarding() {
        onboardingScreen.clickNextButton();
        onboardingScreen.clickNextButton();
        onboardingScreen.clickNextButton();
        locationScreen.clickSelectButton();
        cityScreen.chooseCity(OnboardingScreenTitle.cityName);
        signUpScreen.clickContinueWithoutSignUp();
    }
}
