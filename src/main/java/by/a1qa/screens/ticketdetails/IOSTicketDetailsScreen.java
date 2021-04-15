package by.a1qa.screens.ticketdetails;

import aquality.appium.mobile.application.PlatformName;
import aquality.appium.mobile.screens.screenfactory.ScreenType;
import org.openqa.selenium.By;

@ScreenType(platform = PlatformName.IOS)
public class IOSTicketDetailsScreen extends TicketDetailsScreen {

    public IOSTicketDetailsScreen() {
        super(By.id("asd"));
    }

    @Override
    protected By getSeatingChartLoc() {
        return null;
    }

    @Override
    protected By getExpensiveTicketLbl() {
        return null;
    }

    @Override
    protected By getHoldTimerLbl() {
        return null;
    }

    @Override
    protected By getNumberAndPriceLbl() {
        return null;
    }

    @Override
    protected By getContinueBtn() {
        return null;
    }
}
