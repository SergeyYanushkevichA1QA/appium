package by.a1qa.screens.discover;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.IOS)
public class IOSDiscoverScreen extends DiscoverScreen{

    public IOSDiscoverScreen() {
        super(By.id("asd"));
    }

    @Override
    protected By getShowsLbl() {
        return null;
    }

    @Override
    protected By getHeader() {
        return null;
    }

    @Override
    protected By getPosterLoc() {
        return null;
    }

    @Override
    protected By getPosterNameLoc() {
        return null;
    }

    @Override
    protected By getPosterCostLoc() {
        return null;
    }
}
