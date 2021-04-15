package by.a1qa.screens.discover;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidDiscoverScreen extends DiscoverScreen {
    private final String showContainer = "//android.widget.LinearLayout[@index='1']";
    //android.view.ViewGroup[@content-desc='Fan Favourites The shows that our audience love']/android.widget.TextView[1]
    private final String showLoc = "//android.view.ViewGroup[@content-desc='Fan Favourites The shows that our audience love']" +
            "/android.widget.TextView[1]";

    public AndroidDiscoverScreen() {
        super(By.xpath("android.widget.LinearLayout"));
    }

    @Override
    protected By getShowsLbl() {
        return By.xpath(showLoc);
    }

    @Override
    protected By getHeader() {
        return By.id("discover_header");
    }

    @Override
    protected By getPosterLoc() {
        return By.xpath(showContainer + "//*[@resource-id='com.todaytix.TodayTix:id/container']");
    }

    @Override
    protected By getPosterNameLoc() {
        return By.xpath(showContainer + "//*[contains(@resource-id, 'show_name')]");
    }

    @Override
    protected By getPosterCostLoc() {
        return By.xpath(showContainer + "//*[contains(@resource-id, 'price_amount_label')]");
    }
}
