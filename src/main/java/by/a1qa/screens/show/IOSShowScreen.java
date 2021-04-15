package by.a1qa.screens.show;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.IOS)
public class IOSShowScreen extends ShowScreen {

    public IOSShowScreen() {
        super(By.id("asd"));
    }

    @Override
    protected By getSlideImg() {
        return null;
    }

    @Override
    protected By getShowNameLbl() {
        return null;
    }

    @Override
    protected By getAcceptTicketsLbl() {
        return null;
    }

    @Override
    protected By getCalendarLbl() {
        return null;
    }

    @Override
    protected By getDateLbl() {
        return null;
    }

    @Override
    protected By getTicketLbl() {
        return null;
    }

    @Override
    protected By getDayLoc() {
        return null;
    }
}
