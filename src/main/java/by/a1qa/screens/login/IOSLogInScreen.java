package by.a1qa.screens.login;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.IOS)
public class IOSLogInScreen extends LogInScreen{

    public IOSLogInScreen() {
        super(By.id("asd"));
    }
}
