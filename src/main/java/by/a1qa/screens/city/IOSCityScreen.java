package by.a1qa.screens.city;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;


@ScreenType(platform = PlatformName.IOS)
public class IOSCityScreen extends CityScreen {

    public IOSCityScreen() {
        super(By.xpath("//XCUIElementTypeNavigationBar[@name=\"Select Location\"]"));
    }

    @Override
    protected By getCitiesLoc() {
        return By.xpath("//XCUIElementTypeCell");
    }
}
