package by.a1qa.screens.allshows;


import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidAllShowsScreen extends AllShowsScreen{

    public AndroidAllShowsScreen() {
        super(By.id("root_view"));
    }

    @Override
    protected By getLocationLbl() {
        return By.id("location_name");
    }

    @Override
    protected By getAllShowsBtn() {
        return By.id("tab_all_shows");
    }

    @Override
    protected By getDiscoverBtn() {
        return By.id("tab_discover");
    }
}
