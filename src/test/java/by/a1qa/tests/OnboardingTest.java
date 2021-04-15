package by.a1qa.tests;

import aquality.appium.mobile.application.AqualityServices;
import by.a1qa.data.OnboardingScreenTitle;
import by.a1qa.models.City;
import by.a1qa.screens.allshows.AllShowsScreen;
import by.a1qa.screens.city.CityScreen;
import by.a1qa.screens.location.LocationScreen;
import by.a1qa.screens.onboarding.OnboardingScreen;
import by.a1qa.screens.signup.SignUpScreen;
import by.a1qa.utils.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnboardingTest extends BaseTest {
    private static final OnboardingScreen onboardingScreen = AqualityServices.getScreenFactory().getScreen(OnboardingScreen.class);
    private static final LocationScreen locationScreen = AqualityServices.getScreenFactory().getScreen(LocationScreen.class);
    private static final SignUpScreen signUpScreen = AqualityServices.getScreenFactory().getScreen(SignUpScreen.class);
    private static final CityScreen cityScreen = AqualityServices.getScreenFactory().getScreen(CityScreen.class);
    private static final AllShowsScreen allShowsScreen = AqualityServices.getScreenFactory().getScreen(AllShowsScreen.class);

    @Test
    public void onboardingTest() {
        Log.step(1,"Open the app and check title on screen");
        Assert.assertEquals(onboardingScreen.getTitle(), OnboardingScreenTitle.firstTitle, "Isnt title of screen on 1st page indicator");

        Log.step(2,"Tap next and check title on screen");
        onboardingScreen.clickNextButton();
        Assert.assertEquals(onboardingScreen.getTitle(), OnboardingScreenTitle.secondTitle, "Isnt title of screen on 2nd page indicator");

        Log.step(3,"Tap next and check title on screen");
        onboardingScreen.clickNextButton();
        Assert.assertEquals(onboardingScreen.getTitle(), OnboardingScreenTitle.thirdTitle, "Isnt title of screen on 3rd page indicator");

        Log.step(4,"Tap next and check title on screen");
        onboardingScreen.clickNextButton();
        Assert.assertEquals(onboardingScreen.getTitle(), OnboardingScreenTitle.fourthTitle, "Isnt title of screen on 4th page indicator");

        Log.step(5,"Select random location and check tittle on screen");
        locationScreen.clickSelectButton();
        City city = new City(cityScreen.getRandomCityNameAndClick());
        Assert.assertEquals(signUpScreen.getTitle(), OnboardingScreenTitle.fifthTitle, "Title is not correct");

        Log.step(6," Continue without sign up and check location on screen");
        signUpScreen.clickContinueWithoutSignUp();
        Assert.assertTrue(allShowsScreen.isShowsScreen(), "Arent shows screen");
        City locCity = new City(allShowsScreen.getLocName());
        Assert.assertEquals(city, locCity, "Location on shows screen with chosen arent equals");
    }

}
