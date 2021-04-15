package by.a1qa.screens.location;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidLocationScreen extends LocationScreen{

    public AndroidLocationScreen() {
        super(By.id("icon"));
    }

    @Override
    protected By getSelectBtn() {
        return By.id("secondary_button");
    }
}
