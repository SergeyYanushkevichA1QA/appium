package by.a1qa.screens.login;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidLogInScreen extends LogInScreen{

    public AndroidLogInScreen() {
        super(By.id("log_in"));
    }

}
