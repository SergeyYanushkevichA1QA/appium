package by.a1qa.tests;

import by.a1qa.data.TestData;
import by.a1qa.models.City;
import by.a1qa.screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnboardingTest extends BaseTest {
    private static MainScreen mainScreen = new MainScreen();
    private static LocationScreen locationScreen = new LocationScreen();
    private static SignUpScreen signUpScreen = new SignUpScreen();
    private static CityScreen cityScreen = new CityScreen();
    private static AllShowsScreen allShowsScreen = new AllShowsScreen();

    @Test
    public void onboardingTest() {
        logger.info("Step 1 - Open the app and check title on screen");
        Assert.assertEquals(mainScreen.getTitle(), TestData.firstTitle, "Isnt title of screen on 1st page indicator");

        logger.info("Step 2 - Tap next and check title on screen");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), TestData.secondTitle, "Isnt title of screen on 2nd page indicator");

        logger.info("Step 3 - Tap next and check title on screen");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), TestData.thirdTitle, "Isnt title of screen on 3rd page indicator");

        logger.info("Step 4 - Tap next and check title on screen");
        mainScreen.clickNextButton();
        Assert.assertEquals(mainScreen.getTitle(), TestData.fourthTitle, "Isnt title of screen on 4th page indicator");

        logger.info("Step 5 - Select random location and check tittle on screen");
        locationScreen.clickSelectButton();
        City city = new City(cityScreen.getRandomCityNameAndClick());
        Assert.assertEquals(signUpScreen.getTitle(), TestData.fifthTitle, "Title is not correct");

        logger.info("Step 6 - Continue without sign up and check location on screen");
        signUpScreen.clickContinueWithoutSignUp();
        Assert.assertTrue(allShowsScreen.isShowsScreen(), "Arent shows screen");
        City locCity = new City(allShowsScreen.getLocName());
        Assert.assertEquals(city, locCity, "Location on shows screen with chosen arent equals");
    }

}
