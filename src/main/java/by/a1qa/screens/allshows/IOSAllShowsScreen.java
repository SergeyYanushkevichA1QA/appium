package by.a1qa.screens.allshows;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

import static io.appium.java_client.MobileBy.iOSClassChain;

@ScreenType(platform = PlatformName.IOS)
public class IOSAllShowsScreen extends AllShowsScreen{

    public IOSAllShowsScreen() {
        super(iOSClassChain("**/XCUIElementTypeCell[`label == 'Show List'`]"));
    }

    @Override
    protected By getLocationLbl() {
        return By.id("Location");
    }

    @Override
    protected By getAllShowsBtn() {
        return By.id("Tab.AllShows");
    }

    @Override
    protected By getDiscoverBtn() {
        return By.id("Tab.Discover");
    }
}
