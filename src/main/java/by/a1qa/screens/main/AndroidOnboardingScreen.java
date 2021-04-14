package by.a1qa.screens.main;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidOnboardingScreen extends OnboardingScreen {

    public AndroidOnboardingScreen() {
        super(By.id("content"));
    }

    @Override
    protected By getTitleOnScreenLbl() {
        return By.id("title");
    }

    @Override
    protected By getNextBtn() {
        return By.id("next_button");
    }

}
