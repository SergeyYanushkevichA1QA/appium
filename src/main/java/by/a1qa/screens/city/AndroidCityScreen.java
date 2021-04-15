package by.a1qa.screens.city;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidCityScreen extends CityScreen{

    public AndroidCityScreen() {
        super(By.className("android.widget.TextView"));
    }

    @Override
    protected By getCitiesLoc() {
        return By.xpath("//*[contains(@resource-id, 'location_text')]");
    }
}
