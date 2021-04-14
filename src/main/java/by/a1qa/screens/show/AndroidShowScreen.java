package by.a1qa.screens.show;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.ANDROID)
public class AndroidShowScreen extends ShowScreen{

    public AndroidShowScreen() {
        super(By.id("show_name"));
    }

    @Override
    protected By getSlideImg() {
        return By.id("slide_image");
    }

    @Override
    protected By getShowNameLbl() {
        return By.id("show_name");
    }

    @Override
    protected By getAcceptTicketsLbl() {
        return By.id("performance_time");
    }

    @Override
    protected By getCalendarLbl() {
        return By.id("show_tickets");
    }

    @Override
    protected By getDateLbl() {
        return By.id("date_label");
    }

    @Override
    protected By getTicketLbl() {
        return By.id("date_time_label");
    }

    @Override
    protected By getDayLoc() {
        return By.xpath("//*[contains(@resource-id, 'day_number')]");
    }
}
